package me.fullpotato.badlandscaves.badlandscaves.Runnables.SupernaturalPowers.DescensionStage;

import me.fullpotato.badlandscaves.badlandscaves.BadlandsCaves;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class ForceFixDescensionValues extends BukkitRunnable {
    private BadlandsCaves plugin;
    private World descension_world = Bukkit.getWorld("world_descension");

    public ForceFixDescensionValues(BadlandsCaves plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.getWorld().equals(descension_world)) {
                int in_descension = player.getMetadata("in_descension").get(0).asInt();
                if (in_descension == 1 || in_descension == 2) {
                    player.setMetadata("in_descension", new FixedMetadataValue(plugin, 0));
                }
            }
        }
    }
}