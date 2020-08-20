package me.fullpotato.badlandscaves.Other;

import me.fullpotato.badlandscaves.BadlandsCaves;
import me.fullpotato.badlandscaves.CustomItems.CustomItem;
import me.fullpotato.badlandscaves.Info.GuideBook;
import me.fullpotato.badlandscaves.SupernaturalPowers.Spells.Withdraw;
import me.fullpotato.badlandscaves.Util.InitializePlayer;
import me.fullpotato.badlandscaves.Util.PlayerScore;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinLeave implements Listener {

    private final BadlandsCaves plugin;
    private final GuideBook guideBook;
    private final Withdraw withdraw;
    private final InitializePlayer data;
    public PlayerJoinLeave(BadlandsCaves bcav, GuideBook guideBook, Withdraw withdraw) {
        plugin = bcav;
        this.guideBook = guideBook;
        this.withdraw = withdraw;
        data = new InitializePlayer(plugin);
    }

    @EventHandler
    public void player_join (PlayerJoinEvent event) {
        //give items
        Player player = event.getPlayer();

        //NEW PLAYER--------------------------------
        if (!player.hasPlayedBefore() || (!(PlayerScore.INITIALIZED.hasScore(plugin, player))) || (byte) PlayerScore.INITIALIZED.getScore(plugin, player) == (byte) 0) {
            data.initializePlayer(player);

            if (!player.hasPlayedBefore()) {
                player.getInventory().addItem(plugin.getCustomItemManager().getItem(CustomItem.STARTER_SAPLING));
                player.getInventory().addItem(guideBook.getGuideBook());

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.setHealth(40.0);
                        player.setSaturation(20.0F);
                    }
                }.runTaskLaterAsynchronously(plugin, 5);
            }
        }

        //EVERYONE---------------------------------------

        //if in wither fight, tp out
        if (player.getWorld().equals(plugin.getServer().getWorld(plugin.getChambersWorldName()))) {
            if (plugin.getSystemConfig().getInt("wither_fight.fight_stage") == -1) {
                Location warp = player.getBedSpawnLocation() == null ? plugin.getServer().getWorld(plugin.getMainWorldName()).getSpawnLocation() : player.getBedSpawnLocation();
                warp.setYaw(player.getLocation().getYaw());
                warp.setPitch(player.getLocation().getPitch());

                player.teleport(warp, PlayerTeleportEvent.TeleportCause.PLUGIN);
            }
        }


        //REGARDING SUPERNATURAL POWERS----------------------------------
        final boolean has_powers = (byte) PlayerScore.HAS_SUPERNATURAL_POWERS.getScore(plugin, player) == 1;
        if (has_powers) {
            //if they log off in the withdraw pocket dimension, it sends them back to the real world when they log back in
            if (player.getWorld().equals(plugin.getServer().getWorld(plugin.getWithdrawWorldName()))) {
                String origworldname = plugin.getSystemConfig().getString("player_info." + player.getUniqueId() + ".withdraw_orig_world");
                if (origworldname == null) {
                    player.setHealth(0);
                } else {
                    PlayerScore.WITHDRAW_TIMER.setScore(plugin, player, 0);
                    final World origworld = plugin.getServer().getWorld(origworldname);
                    final double x = (double) PlayerScore.WITHDRAW_X.getScore(plugin, player);
                    final double y = (double) PlayerScore.WITHDRAW_Y.getScore(plugin, player);
                    final double z = (double) PlayerScore.WITHDRAW_Z.getScore(plugin, player);

                    final Location location = new Location(origworld, x, y, z);
                    withdraw.exitWithdraw(player, location, player.getLocation());
                }
            }

            //reset agility jump timer
            player.setMetadata("agility_jump_id", new FixedMetadataValue(plugin, 0));
            player.setMetadata("agility_jump_timer", new FixedMetadataValue(plugin, 0));

            //reset cooldowns
            PlayerScore.SWAP_DOUBLESHIFT_WINDOW.setScore(plugin, player, 0);
            PlayerScore.SWAP_WINDOW.setScore(plugin, player, 0);
            PlayerScore.SWAP_COOLDOWN.setScore(plugin, player, 0);
            PlayerScore.SPELL_COOLDOWN.setScore(plugin, player, 0);
        }
    }

    // TODO: 8/18/2020 somehow find a better way than this
    @EventHandler
    public void playerLeaveInDimension (PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        final World world = player.getWorld();

        if (world.getName().startsWith(plugin.getDimensionPrefixName())) {
            Location location = player.getBedSpawnLocation();
            if (location == null) location = plugin.getServer().getWorld(plugin.getMainWorldName()).getSpawnLocation();

            player.teleport(location);
        }
    }
}
