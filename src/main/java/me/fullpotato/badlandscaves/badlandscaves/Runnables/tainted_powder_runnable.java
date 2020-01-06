package me.fullpotato.badlandscaves.badlandscaves.Runnables;

import me.fullpotato.badlandscaves.badlandscaves.BadlandsCaves;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class tainted_powder_runnable extends BukkitRunnable {

    private BadlandsCaves plugin;
    private Item item;
    public tainted_powder_runnable (BadlandsCaves bcav, Item itm) {
        plugin = bcav;
        item = itm;
    }

    @Override
    public void run() {
        Location location = item.getLocation();
        World world = location.getWorld();
        int X = location.getBlockX();
        int Y = location.getBlockY();
        int Z = location.getBlockZ();


        for (int x = X - 3; x < X + 3; x++) {
            for (int y = Y - 3; y < Y + 3; y++) {
                for (int z = Z - 3; z < Z + 3; z++) {
                    Location affected_block_loc = new Location(world, x, y, z);
                    Block affected_block = affected_block_loc.getBlock();
                    boolean foundblock = false;

                    if (affected_block.getType() != null) {
                        if (affected_block.getType().equals(Material.INFESTED_STONE)) {
                            affected_block.setType(Material.STONE);
                            foundblock = true;
                        }
                        else if (affected_block.getType().equals(Material.INFESTED_COBBLESTONE)) {
                            affected_block.setType(Material.COBBLESTONE);
                            foundblock = true;
                        }
                        else if (affected_block.getType().equals(Material.INFESTED_STONE_BRICKS)) {
                            affected_block.setType(Material.STONE_BRICKS);
                            foundblock = true;
                        }
                        else if (affected_block.getType().equals(Material.INFESTED_CHISELED_STONE_BRICKS)) {
                            affected_block.setType(Material.CHISELED_STONE_BRICKS);
                            foundblock = true;
                        }
                        else if (affected_block.getType().equals(Material.INFESTED_CRACKED_STONE_BRICKS)) {
                            affected_block.setType(Material.CRACKED_STONE_BRICKS);
                            foundblock = true;
                        }
                        else if (affected_block.getType().equals(Material.INFESTED_MOSSY_STONE_BRICKS)) {
                            affected_block.setType(Material.MOSSY_STONE_BRICKS);
                            foundblock = true;
                        }
                        affected_block.getState().update(true);

                        if (foundblock) {
                            world.spawnParticle(Particle.CLOUD, affected_block_loc, 1);
                        }
                    }
                }
            }
        }

        Entity[] entity_list = location.getChunk().getEntities();
        for (int a = 0; a < entity_list.length; a++) {
            if (location.distance(entity_list[a].getLocation()) <= 3) {
                if (entity_list[a].getType().equals(EntityType.SILVERFISH)) {
                    LivingEntity silverfish = (LivingEntity) entity_list[a];
                    silverfish.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 9999, 4));
                    world.spawnParticle(Particle.DAMAGE_INDICATOR, entity_list[a].getLocation(), 50,0.2,0.5,0.2);
                }
                else if (entity_list[a].getType().equals(EntityType.PLAYER)) {
                    Player player = (Player) entity_list[a];
                    if (player.getGameMode().equals(GameMode.SURVIVAL) || player.getGameMode().equals(GameMode.ADVENTURE)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,100, 1));
                        double tox = player.getMetadata("Toxicity").get(0).asDouble();

                        if (player.hasPotionEffect(PotionEffectType.WATER_BREATHING) || player.hasPotionEffect(PotionEffectType.CONDUIT_POWER)) {
                            player.setMetadata("Toxicity", new FixedMetadataValue(plugin, tox + 1));
                            world.spawnParticle(Particle.DAMAGE_INDICATOR, entity_list[a].getLocation(), 10,0.2, 0.5 ,0.2);
                        }
                        else {
                            player.setMetadata("Toxicity", new FixedMetadataValue(plugin, tox + 10));
                            world.spawnParticle(Particle.DAMAGE_INDICATOR, entity_list[a].getLocation(), 20,0.2, 0.5 ,0.2);
                        }

                    }
                }
                else {
                    try {
                        LivingEntity living = (LivingEntity) entity_list[a];
                        living.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,100, 1));
                        world.spawnParticle(Particle.DAMAGE_INDICATOR, living.getLocation(), 5,0.2, 0.5 ,0.2);
                    }
                    catch (ClassCastException ignore) {
                    }
                }
            }
        }

        assert world != null;
        world.playEffect(location, Effect.ANVIL_LAND, 1);

        item.teleport(new Location(world, X, -1000, Z));

    }
}
