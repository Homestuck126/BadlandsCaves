package me.fullpotato.badlandscaves.badlandscaves.Events.SupernaturalPowers.Reflection;

import me.fullpotato.badlandscaves.badlandscaves.BadlandsCaves;
import me.fullpotato.badlandscaves.badlandscaves.NMS.FakePlayer;
import me.fullpotato.badlandscaves.badlandscaves.Runnables.SupernaturalPowers.ReflectionStage.ZombieBossBehavior;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerUnderSht implements Listener {
    private World world = Bukkit.getWorld("world_reflection");

    @EventHandler
    public void activateUnderSht (EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player &&
                event.getEntity().getWorld().equals(world) &&
                event.getDamager() instanceof Zombie &&
                event.getDamager().getWorld().equals(world)) {

            FakePlayer fakePlayer = new FakePlayer(world);
            fakePlayer.damage(ZombieBossBehavior.fakePlayer, null, false);

            final Player player = (Player) event.getEntity();
            player.setCooldown(Material.SHIELD, 20);

            final Zombie boss = (Zombie) event.getDamager();

            final double hp_before_atk = player.getHealth();
            final double hp_after_atk = hp_before_atk - event.getFinalDamage();

            if (hp_before_atk > 2 && hp_after_atk < 0) {
                event.setDamage(player.getHealth() - 1);
                player.spawnParticle(Particle.TOTEM, player.getEyeLocation(), 1);
                player.playSound(player.getEyeLocation(), Sound.ITEM_TOTEM_USE, SoundCategory.PLAYERS, 1, 1);
            }
        }
    }
}
