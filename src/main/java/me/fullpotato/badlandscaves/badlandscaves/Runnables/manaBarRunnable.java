package me.fullpotato.badlandscaves.badlandscaves.Runnables;

import me.fullpotato.badlandscaves.badlandscaves.BadlandsCaves;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class manaBarRunnable extends BukkitRunnable {
    private BadlandsCaves plugin;
    public manaBarRunnable (BadlandsCaves bcav) {
        plugin = bcav;
    }

    @Override
    public void run() {

        for (Player player : Bukkit.getOnlinePlayers()) {
            int has_powers = player.getMetadata("has_supernatural_powers").get(0).asInt();
            if (has_powers >= 1.0) {
                NamespacedKey key = new NamespacedKey(plugin, "mana_bar_" + player.getUniqueId());
                KeyedBossBar manaBar = Bukkit.getBossBar(key);
                String title = ChatColor.DARK_AQUA + "Mana";
                if (manaBar == null) {
                    manaBar = Bukkit.createBossBar(key, title, BarColor.BLUE, BarStyle.SEGMENTED_10);
                    manaBar.addPlayer(player);
                }

                double max_mana = player.getMetadata("max_mana").get(0).asDouble();
                double mana = player.getMetadata("Mana").get(0).asDouble();
                double percentage;
                try {
                    percentage = Math.min(Math.max(mana / max_mana, 0.0), 1.0);
                }
                catch (ArithmeticException e) {
                    percentage = 0.0;
                }
                manaBar.setProgress(percentage);


                int swap_slot = player.getMetadata("swap_slot").get(0).asInt();
                int swap_name_timer = player.getMetadata("swap_name_timer").get(0).asInt();
                int mana_needed_timer = player.getMetadata("mana_needed_timer").get(0).asInt();

                if (mana_needed_timer > 0) {
                    manaBar.setTitle(ChatColor.RED + "Not enough Mana!");
                    player.setMetadata("mana_needed_timer", new FixedMetadataValue(plugin, mana_needed_timer - 1));
                }
                else if (swap_name_timer > 0 && swap_slot != -1) {
                    final String[] names = {
                            ChatColor.BOLD.toString() + ChatColor.LIGHT_PURPLE + "Displace",
                            ChatColor.BOLD.toString() + ChatColor.BLUE + "Enhanced Eyes",
                            ChatColor.BOLD.toString() + ChatColor.GRAY + "Withdraw",
                            ChatColor.BOLD.toString() + ChatColor.DARK_GREEN + "Possession",
                    };

                    manaBar.setTitle(names[swap_slot]);
                }
                else {
                    manaBar.setTitle(title);
                }

                int active_timer = player.getMetadata("mana_bar_active_timer").get(0).asInt();
                if (active_timer > 0) {
                    manaBar.setVisible(true);
                    active_timer--;
                    player.setMetadata("mana_bar_active_timer", new FixedMetadataValue(plugin, active_timer));
                }
                else {
                    manaBar.setVisible(false);
                }

            }
        }
    }
}
