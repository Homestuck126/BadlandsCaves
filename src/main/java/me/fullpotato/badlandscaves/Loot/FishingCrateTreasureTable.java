package me.fullpotato.badlandscaves.Loot;

import me.fullpotato.badlandscaves.BadlandsCaves;
import me.fullpotato.badlandscaves.CustomItems.CustomItem;
import me.fullpotato.badlandscaves.Util.PlayerScore;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class FishingCrateTreasureTable implements LootTable {

    private final BadlandsCaves plugin;
    private final Player player;
    private final boolean hardmode;
    private final NamespacedKey key;

    public FishingCrateTreasureTable(BadlandsCaves plugin, Player player, boolean hardmode) {
        this.plugin = plugin;
        this.player = player;
        this.hardmode = hardmode;
        key = new NamespacedKey(plugin, "fishing_crate_treasure");
    }

    @Override
    public Collection<ItemStack> populateLoot(Random random, LootContext context) {
        final double luck = context.getLuck();
        final int chaos = plugin.getSystemConfig().getInt("chaos_level");
        final int count = random.nextInt(Math.max(Math.min((int) (Math.pow((luck + 10.0) / 7.0, 1.65) + 3.0 + (chaos / 25.0)), 10), 3));
        final int tier_upgrade = plugin.getOptionsConfig().getInt("fishing_crate_tier_upgrade") + (int) (Math.pow(chaos / 35.0, 3.25));
        int tier;
        final TreasureGear treasureGear = new TreasureGear();


        if (hardmode) {
            final boolean heretic = (byte) PlayerScore.HAS_SUPERNATURAL_POWERS.getScore(plugin, player) == 1;
        //HARDMODE-------------------------------------
            ArrayList<ItemStack> tier1 = new ArrayList<>();
            tier1.add(new ItemStack(Material.IRON_BLOCK, randomCount(random, 1, 8)));
            tier1.add(new ItemStack(Material.DIAMOND_BLOCK, randomCount(random, 1, 8)));
            tier1.add(new ItemStack(Material.EMERALD_BLOCK, randomCount(random, 1, 8)));
            tier1.add(new ItemStack(Material.QUARTZ_BLOCK, randomCount(random, 1, 8)));
            tier1.add(new ItemStack(Material.EXPERIENCE_BOTTLE, randomCount(random, 1, 16)));
            tier1.add(new ItemStack(Material.BLAZE_ROD, randomCount(random, 1, 16)));
            tier1.add(new ItemStack(Material.GOLD_BLOCK, randomCount(random, 1, 8)));
            tier1.add(new ItemStack(Material.GOLDEN_APPLE, randomCount(random, 1, 16)));
            tier1.add(CustomItem.PURGE_ESSENCE.getItem());
            tier1.add(CustomItem.ANTIDOTE.getItem());
            tier1.add(CustomItem.TAINTED_POWDER.getItem());
            tier1.add(CustomItem.RECALL_POTION.getItem());

            ArrayList<ItemStack> tier2 = new ArrayList<>();
            tier2.add(new ItemStack(Material.SHULKER_SHELL, randomCount(random, 1, 4)));
            tier2.add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, randomCount(random, 1, 4)));
            tier2.add(new ItemStack(Material.TOTEM_OF_UNDYING));
            tier2.add(CustomItem.TOTEM_OF_PRESERVATION.getItem());
            tier2.add(new ItemStack(Material.COW_SPAWN_EGG, randomCount(random, 1, 4)));
            tier2.add(new ItemStack(Material.PIG_SPAWN_EGG, randomCount(random, 1, 4)));
            tier2.add(new ItemStack(Material.SHEEP_SPAWN_EGG, randomCount(random, 1, 4)));
            tier2.add(new ItemStack(Material.GRASS_BLOCK, randomCount(random, 1, 4)));
            tier2.add(new ItemStack(Material.ACACIA_SAPLING, randomCount(random, 1, 4)));
            tier2.add(new ItemStack(Material.BIRCH_SAPLING, randomCount(random, 1, 4)));
            tier2.add(new ItemStack(Material.SPRUCE_SAPLING, randomCount(random, 1, 4)));
            tier2.add(new ItemStack(Material.JUNGLE_SAPLING, randomCount(random, 1, 4)));
            tier2.add(new ItemStack(Material.DARK_OAK_SAPLING, randomCount(random, 1, 4)));
            if (heretic) {
                tier2.add(CustomItem.MANA_POTION.getItem());
                tier2.add(new ItemStack(Material.WITCH_SPAWN_EGG, randomCount(random, 1, 4)));
                tier2.add(new ItemStack(Material.LAPIS_BLOCK, randomCount(random, 8, 32)));
            }
            else {
                tier2.add(new ItemStack(Material.EXPERIENCE_BOTTLE, randomCount(random, 16, 48)));
                tier2.add(new ItemStack(Material.REDSTONE_BLOCK, randomCount(random, 8, 32)));
            }

            ArrayList<ItemStack> tier3 = new ArrayList<>();
            tier3.add(treasureGear.getTreasureGear(true, Material.DIAMOND_HELMET, random));
            tier3.add(treasureGear.getTreasureGear(true, Material.DIAMOND_CHESTPLATE, random));
            tier3.add(treasureGear.getTreasureGear(true, Material.DIAMOND_LEGGINGS, random));
            tier3.add(treasureGear.getTreasureGear(true, Material.DIAMOND_BOOTS, random));
            tier3.add(treasureGear.getTreasureGear(true, Material.DIAMOND_SWORD, random));
            tier3.add(treasureGear.getTreasureGear(true, Material.DIAMOND_SHOVEL, random));
            tier3.add(treasureGear.getTreasureGear(true, Material.DIAMOND_PICKAXE, random));
            tier3.add(treasureGear.getTreasureGear(true, Material.DIAMOND_AXE, random));
            if (!heretic) {
                tier3.add(CustomItem.TITANIUM_FRAGMENT.getItem());
            }

            ArrayList<ItemStack> tier4 = new ArrayList<>();
            tier4.add(CustomItem.FOREVER_FISH.getItem());

            ArrayList<ArrayList<ItemStack>> items = new ArrayList<>();
            items.add(tier1);
            items.add(tier2);
            items.add(tier3);
            items.add(tier4);

            ArrayList<ItemStack> output = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                tier = getTier(random, tier_upgrade, 1);
                output.add(items.get(tier - 1).get(random.nextInt(items.get(tier - 1).size())));
            }
            return output;
        }
        else {
        //PREHARDMODE----------------------------------
            ArrayList<ItemStack> tier1 = new ArrayList<>();
            tier1.add(new ItemStack(Material.IRON_INGOT, randomCount(random, 1, 16)));
            tier1.add(new ItemStack(Material.QUARTZ, randomCount(random, 1, 16)));
            tier1.add(new ItemStack(Material.EMERALD, randomCount(random, 1, 16)));
            tier1.add(new ItemStack(Material.OAK_SAPLING, randomCount(random, 1, 16)));
            tier1.add(new ItemStack(Material.APPLE, randomCount(random, 1, 16)));
            tier1.add(new ItemStack(Material.EXPERIENCE_BOTTLE, randomCount(random, 1, 16)));
            tier1.add(new ItemStack(Material.WHEAT_SEEDS, randomCount(random, 1, 16)));
            tier1.add(new ItemStack(Material.POTATO, randomCount(random, 1, 16)));
            tier1.add(new ItemStack(Material.NETHER_WART, randomCount(random, 1, 16)));
            tier1.add(new ItemStack(Material.GOLD_INGOT, randomCount(random, 1, 16)));

            ArrayList<ItemStack> tier2 = new ArrayList<>();
            tier2.add(new ItemStack(Material.DIAMOND_HELMET));
            tier2.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
            tier2.add(new ItemStack(Material.DIAMOND_LEGGINGS));
            tier2.add(new ItemStack(Material.DIAMOND_BOOTS));
            tier2.add(new ItemStack(Material.DIAMOND_SWORD));
            tier2.add(new ItemStack(Material.DIAMOND_SHOVEL));
            tier2.add(new ItemStack(Material.DIAMOND_PICKAXE));
            tier2.add(new ItemStack(Material.DIAMOND_AXE));
            tier2.add(new ItemStack(Material.DIAMOND, randomCount(random, 1, 8)));
            tier2.add(new ItemStack(Material.BLAZE_POWDER, randomCount(random, 1, 8)));
            tier2.add(CustomItem.PURIFIED_WATER.getItem());
            tier2.add(CustomItem.ANTIDOTE.getItem());
            tier2.add(new ItemStack(Material.GOLDEN_APPLE, randomCount(random, 1, 8)));
            tier2.add(CustomItem.TAINTED_POWDER.getItem());
            tier2.add(CustomItem.RECALL_POTION.getItem());

            ArrayList<ItemStack> tier3 = new ArrayList<>();
            tier3.add(new ItemStack(Material.SHULKER_SHELL, randomCount(random, 1, 4)));
            tier3.add(getDiamondGear(Material.DIAMOND_HELMET, random));
            tier3.add(getDiamondGear(Material.DIAMOND_CHESTPLATE, random));
            tier3.add(getDiamondGear(Material.DIAMOND_LEGGINGS, random));
            tier3.add(getDiamondGear(Material.DIAMOND_BOOTS, random));
            tier3.add(getDiamondGear(Material.DIAMOND_SWORD, random));
            tier3.add(getDiamondGear(Material.DIAMOND_SHOVEL, random));
            tier3.add(getDiamondGear(Material.DIAMOND_PICKAXE, random));
            tier3.add(getDiamondGear(Material.DIAMOND_AXE, random));

            ArrayList<ItemStack> tier4 = new ArrayList<>();
            tier4.add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, randomCount(random, 1, 2)));
            tier4.add(new ItemStack(Material.TOTEM_OF_UNDYING));
            tier4.add(CustomItem.TOTEM_OF_PRESERVATION.getItem());
            tier4.add(treasureGear.getTreasureGear(false, Material.DIAMOND_HELMET, random));
            tier4.add(treasureGear.getTreasureGear(false, Material.DIAMOND_CHESTPLATE, random));
            tier4.add(treasureGear.getTreasureGear(false, Material.DIAMOND_LEGGINGS, random));
            tier4.add(treasureGear.getTreasureGear(false, Material.DIAMOND_BOOTS, random));
            tier4.add(treasureGear.getTreasureGear(false, Material.DIAMOND_SWORD, random));
            tier4.add(treasureGear.getTreasureGear(false, Material.DIAMOND_SHOVEL, random));
            tier4.add(treasureGear.getTreasureGear(false, Material.DIAMOND_PICKAXE, random));
            tier4.add(treasureGear.getTreasureGear(false, Material.DIAMOND_AXE, random));

            ArrayList<ArrayList<ItemStack>> items = new ArrayList<>();
            items.add(tier1);
            items.add(tier2);
            items.add(tier3);
            items.add(tier4);

            ArrayList<ItemStack> output = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                tier = getTier(random, tier_upgrade, 1);
                output.add(items.get(tier - 1).get(random.nextInt(items.get(tier - 1).size())));
            }
            return output;
        }
    }

    @Override
    public void fillInventory(Inventory inventory, Random random, LootContext context) {
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }

    private int getTier(Random random, int chance, int current_number) {
        if (current_number != 4 && random.nextInt(100) < chance) {
            return getTier(random, chance, current_number + 1);
        }
        else {
            return current_number;
        }
    }

    private ItemStack getDiamondGear (Material material, Random random) {
        ItemStack output = new ItemStack(material);
        ItemMeta meta = output.getItemMeta();
        RandomlyEnchantedGear ench = new RandomlyEnchantedGear();

        if (material.equals(Material.DIAMOND_HELMET) || material.equals(Material.DIAMOND_CHESTPLATE) || material.equals(Material.DIAMOND_LEGGINGS) || material.equals(Material.DIAMOND_BOOTS)) {
            ench.randomlyEnchant(meta, Enchantment.PROTECTION_ENVIRONMENTAL, random, 1);
            if (material.equals(Material.DIAMOND_HELMET)) {
                ench.randomlyEnchant(meta, Enchantment.WATER_WORKER, random, 0);
                ench.randomlyEnchant(meta, Enchantment.OXYGEN, random, 0);
            }
            else if (material.equals(Material.DIAMOND_CHESTPLATE)) {
                ench.randomlyEnchant(meta, Enchantment.THORNS, random, 0);
            }
            else if (material.equals(Material.DIAMOND_BOOTS)) {
                ench.randomlyEnchant(meta, Enchantment.DEPTH_STRIDER, random, 0);
                ench.randomlyEnchant(meta, Enchantment.PROTECTION_FALL, random, 0);
            }
        }

        else if (material.equals(Material.DIAMOND_SWORD)) {
            ench.randomlyEnchant(meta, Enchantment.DAMAGE_ALL, random, 1);
            ench.randomlyEnchant(meta, Enchantment.FIRE_ASPECT, random, 0);
            ench.randomlyEnchant(meta, Enchantment.KNOCKBACK, random, 0);
            ench.randomlyEnchant(meta, Enchantment.LOOT_BONUS_MOBS, random, 0);
            ench.randomlyEnchant(meta, Enchantment.SWEEPING_EDGE, random, 0);
        }
        else if (material.equals(Material.DIAMOND_SHOVEL) || material.equals(Material.DIAMOND_PICKAXE) || material.equals(Material.DIAMOND_AXE)) {
            ench.randomlyEnchant(meta, Enchantment.DIG_SPEED, random, 1);
            if (random.nextBoolean()) {
                ench.randomlyEnchant(meta, Enchantment.LOOT_BONUS_BLOCKS, random, 0);
            }
            else if (random.nextBoolean()) {
                meta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            }
        }

        output.setItemMeta(meta);
        return output;
    }

    /**Returns a random integer between min and max, inclusive. */
    private int randomCount (Random random, int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
