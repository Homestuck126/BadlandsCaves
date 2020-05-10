package me.fullpotato.badlandscaves.badlandscaves.CustomItemRecipes;

import me.fullpotato.badlandscaves.badlandscaves.BadlandsCaves;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CorrosiveCrafting {
    private BadlandsCaves plugin;

    public CorrosiveCrafting(BadlandsCaves plugin) {
        this.plugin = plugin;
    }

    public void craftCorrosiveSubstance() {
        final ItemStack corrosive_substance = ItemStack.deserialize(plugin.getConfig().getConfigurationSection("items.corrosive_substance").getValues(true));
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "corrosive_substance"), corrosive_substance);

        /*
        * X**
        * *&*
        * **X
        *
        * where X is spider eye, * is tainted powder, and & is poison 2 potion
        * */
        recipe.shape("X**", "*&*", "**X");
        recipe.setIngredient('X', Material.SPIDER_EYE);
        recipe.setIngredient('*', Material.COMMAND_BLOCK);
        recipe.setIngredient('&', Material.POTION);

        plugin.getServer().addRecipe(recipe);
    }

    public void craftCorrosiveSword() {
        final ItemStack corrosive_placeholder = ItemStack.deserialize(plugin.getConfig().getConfigurationSection("items.corrosive_placeholder").getValues(true));
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "corrosive_sword"), corrosive_placeholder);
        recipe.addIngredient(Material.COMMAND_BLOCK);
        recipe.addIngredient(new RecipeChoice.MaterialChoice(Material.WOODEN_SWORD, Material.STONE_SWORD, Material.IRON_SWORD, Material.GOLDEN_SWORD, Material.DIAMOND_SWORD));

        plugin.getServer().addRecipe(recipe);
    }

    public void craftCorrosiveArrow() {
        final ItemStack corrosive_arrow = ItemStack.deserialize(plugin.getConfig().getConfigurationSection("items.corrosive_arrow").getValues(true));
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, "corrosive_arrow"), corrosive_arrow);
        recipe.addIngredient(Material.ARROW);
        recipe.addIngredient(Material.COMMAND_BLOCK);

        plugin.getServer().addRecipe(recipe);

    }
}
