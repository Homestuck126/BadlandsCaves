package me.fullpotato.badlandscaves.CustomItems.Using;

import me.fullpotato.badlandscaves.BadlandsCaves;
import me.fullpotato.badlandscaves.CustomItems.CustomItem;
import me.fullpotato.badlandscaves.Util.PlayerScore;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class PreservationTotem implements Listener {
    private final BadlandsCaves plugin;

    public PreservationTotem(BadlandsCaves plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void playerDie(PlayerDeathEvent event) {
        final Player player = event.getEntity();

        for (ItemStack item : player.getInventory()) {
            if (item != null && item.isSimilar(plugin.getCustomItemManager().getItem(CustomItem.TOTEM_OF_PRESERVATION))) {
                event.setKeepInventory(true);
                event.getDrops().clear();
                event.setDroppedExp(0);
                event.setKeepLevel(true);
                item.setAmount(item.getAmount() - 1);
                PlayerScore.USED_PRESERVE_TOTEM.setScore(plugin, player, (byte) 1);
                return;
            }
        }
    }

    @EventHandler
    public void playerRespawnAfterUsingTotem (PlayerRespawnEvent event) {
        final Player player = event.getPlayer();
        if ((byte) PlayerScore.USED_PRESERVE_TOTEM.getScore(plugin, player) == (byte) 1) {
            PlayerScore.USED_PRESERVE_TOTEM.setScore(plugin, player, (byte) 0);

            new BukkitRunnable() {
                @Override
                public void run() {
                    player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, SoundCategory.PLAYERS, 1, 0.7F);
                    player.spawnParticle(Particle.BLOCK_DUST, player.getLocation().add(0, 1, 0), 50, 0.5, 1, 0.5, 1, Material.BLACKSTONE.createBlockData());
                    player.spawnParticle(Particle.BLOCK_DUST, player.getLocation().add(0, 1, 0), 50, 0.5, 1, 0.5, 1, Material.REDSTONE_BLOCK.createBlockData());
                }
            }.runTaskLaterAsynchronously(plugin, 1);
        }
    }
}
