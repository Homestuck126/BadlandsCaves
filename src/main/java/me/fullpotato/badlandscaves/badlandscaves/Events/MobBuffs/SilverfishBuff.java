package me.fullpotato.badlandscaves.badlandscaves.Events.MobBuffs;

import me.fullpotato.badlandscaves.badlandscaves.BadlandsCaves;
import org.bukkit.entity.Silverfish;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class SilverfishBuff implements Listener {
    private BadlandsCaves plugin;
    public SilverfishBuff(BadlandsCaves bcav) {
        plugin = bcav;
    }

    @EventHandler
    public void HMsilverfish (CreatureSpawnEvent event) {
        if (!(event.getEntity() instanceof Silverfish)) return;
        boolean isHardmode = plugin.getConfig().getBoolean("game_values.hardmode");
        if (!isHardmode) return;

        Silverfish silverfish = (Silverfish) event.getEntity();

        Random random = new Random();
        silverfish.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999, random.nextInt(3) + 1, true, true));
        silverfish.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 9999, random.nextInt(3) + 1, true, true));
    }
}