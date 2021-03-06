package me.fullpotato.badlandscaves.CustomItems.Crafting;

import me.fullpotato.badlandscaves.BadlandsCaves;
import me.fullpotato.badlandscaves.CustomItems.CustomItem;
import me.fullpotato.badlandscaves.CustomItems.CustomItemManager;
import me.fullpotato.badlandscaves.Util.PlayerScore;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Shield implements Listener {
    private final BadlandsCaves plugin;
    private final CustomItemManager customItemManager;

    public Shield(BadlandsCaves plugin) {
        this.plugin = plugin;
        customItemManager = plugin.getCustomItemManager();
    }

    @SuppressWarnings("deprecation")
    public void craftRegularShield () {
        plugin.getServer().removeRecipe(new NamespacedKey(NamespacedKey.MINECRAFT, "shield"));

        ItemStack shield = new ItemStack(Material.SHIELD);
        ItemMeta meta = shield.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "Wooden Shield");
        shield.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "wooden_shield"), shield);
        recipe.shape("# #", "###", " # ");
        recipe.setIngredient('#', new RecipeChoice.MaterialChoice(Material.OAK_PLANKS, Material.ACACIA_PLANKS, Material.BIRCH_PLANKS, Material.DARK_OAK_PLANKS, Material.JUNGLE_PLANKS, Material.SPRUCE_PLANKS));

        plugin.getServer().addRecipe(recipe);
    }

    public void craftStoneShield() {
        final ItemStack shield = customItemManager.getItem(CustomItem.STONE_SHIELD);

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "stone_shield"), shield);
        recipe.shape("# #", "###", " # ");
        recipe.setIngredient('#', Material.COBBLESTONE);

        plugin.getServer().addRecipe(recipe);
    }

    public void craftIronShield() {
        final ItemStack shield = customItemManager.getItem(CustomItem.IRON_SHIELD);

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "iron_shield"), shield);
        recipe.shape("# #", "###", " # ");
        recipe.setIngredient('#', Material.IRON_INGOT);

        plugin.getServer().addRecipe(recipe);
    }

    public void craftDiamondShield() {
        final ItemStack shield = customItemManager.getItem(CustomItem.DIAMOND_SHIELD);

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "diamond_shield"), shield);
        recipe.shape("# #", "###", " # ");
        recipe.setIngredient('#', Material.DIAMOND);

        plugin.getServer().addRecipe(recipe);
    }

    public void craftNetheriteShield() {
        final ItemStack shield = customItemManager.getItem(CustomItem.NETHERITE_SHIELD);

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "netherite_shield"), shield);
        recipe.shape("# #", "###", " # ");
        recipe.setIngredient('#', Material.NETHERITE_SCRAP);

        plugin.getServer().addRecipe(recipe);
    }

    @EventHandler
    public void craftShield(PrepareItemCraftEvent event) {
        if (event.getRecipe() == null || event.getRecipe().getResult() == null) return;

        final ItemStack result = event.getRecipe().getResult();
        final ItemStack stoneShield = customItemManager.getItem(CustomItem.STONE_SHIELD);
        final ItemStack ironShield = customItemManager.getItem(CustomItem.IRON_SHIELD);
        final ItemStack diamondShield = customItemManager.getItem(CustomItem.DIAMOND_SHIELD);
        final ItemStack netheriteShield = customItemManager.getItem(CustomItem.NETHERITE_SHIELD);

        if (result.isSimilar(stoneShield) || result.isSimilar(ironShield) || result.isSimilar(diamondShield) || result.isSimilar(netheriteShield)) {
            for (HumanEntity humanEntity : event.getViewers()) {
                Player player = (Player) humanEntity;
                if ((byte) PlayerScore.HAS_SUPERNATURAL_POWERS.getScore(plugin, player) == 1) {
                    event.getInventory().setResult(null);
                    return;
                }
            }
        }
    }
}
