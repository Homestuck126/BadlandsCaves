package me.fullpotato.badlandscaves.badlandscaves.CustomItemRecipes;

import me.fullpotato.badlandscaves.badlandscaves.BadlandsCaves;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class hellEssence implements Listener {
    private BadlandsCaves plugin;
    public hellEssence (BadlandsCaves bcav) {
        plugin = bcav;
    }

    public void craft_hell_essence () {
        ItemStack hell_essence = ItemStack.deserialize(plugin.getConfig().getConfigurationSection("items.hell_essence").getValues(true));

        ShapelessRecipe hell_ess_craft = new ShapelessRecipe(new NamespacedKey(plugin, "hell_essence"), hell_essence);
        hell_ess_craft.addIngredient(Material.BLAZE_POWDER);
        hell_ess_craft.addIngredient(Material.MAGMA_CREAM);

        plugin.getServer().addRecipe(hell_ess_craft);
    }
}
