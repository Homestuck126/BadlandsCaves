package me.fullpotato.badlandscaves.badlandscaves.Events;

import me.fullpotato.badlandscaves.badlandscaves.BadlandsCaves;
import me.fullpotato.badlandscaves.badlandscaves.Events.SupernaturalPowers.Withdraw;
import me.fullpotato.badlandscaves.badlandscaves.Util.PlayerConfigLoadSave;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class PlayerJoinLeave implements Listener {

    private BadlandsCaves plugin;
    private String[] values;
    public PlayerJoinLeave(BadlandsCaves bcav, String[] ply_vals) {
        plugin = bcav;
        values = ply_vals;
    }

    @EventHandler
    public void player_join (PlayerJoinEvent event) {
        //give items
        Player player = event.getPlayer();

        PlayerConfigLoadSave loader = new PlayerConfigLoadSave(plugin, values);
        //NEW PLAYER--------------------------------
        if (!player.hasPlayedBefore()) {

            ItemStack starter_sapling = ItemStack.deserialize(plugin.getConfig().getConfigurationSection("items.starter_sapling").getValues(true));
            ItemStack starter_bone_meal = ItemStack.deserialize(plugin.getConfig().getConfigurationSection("items.starter_bone_meal").getValues(true));
            player.getInventory().addItem(starter_sapling);
            player.getInventory().addItem(starter_bone_meal);

            //default values
            loader.saveDefault(player);
        }

        //EVERYONE---------------------------------------
        //load config back into metadata
        loader.loadPlayer(player);

        //REGARDING SUPERNATURAL POWERS----------------------------------

        //if they log off in the withdraw pocket dimension, it sends them back to the real world when they log back in
        int has_powers = player.getMetadata("has_supernatural_powers").get(0).asInt();
        if (has_powers >= 1.0) {

        }

        if (player.getWorld().equals(Bukkit.getWorld("world_empty"))) {
                String origworldname = plugin.getConfig().getString("Scores.users." + player.getUniqueId() + ".withdraw_orig_world");

                if (origworldname == null) {
                    player.setHealth(0);
                }
                else {
                    player.setMetadata("withdraw_timer", new FixedMetadataValue(plugin, 0));
                    final World origworld = Bukkit.getWorld(origworldname);
                    final double x = player.getMetadata("withdraw_x").get(0).asDouble();
                    final double y = player.getMetadata("withdraw_y").get(0).asDouble();
                    final double z = player.getMetadata("withdraw_z").get(0).asDouble();

                    final Location location = new Location(origworld, x, y, z);
                    Withdraw sendback = new Withdraw(plugin);
                    sendback.getOuttaHere(player, location, player.getLocation());
                }
        }

        //reset agility jump timer
        player.setMetadata("agility_jump_id", new FixedMetadataValue(plugin, 0));
        player.setMetadata("agility_jump_timer", new FixedMetadataValue(plugin, 0));
    }

    @EventHandler
    public void player_leave (PlayerQuitEvent event) {
        Player player = event.getPlayer();
        PlayerConfigLoadSave save_player = new PlayerConfigLoadSave(plugin, values);
        save_player.saveToConfig(player, false);
    }
}