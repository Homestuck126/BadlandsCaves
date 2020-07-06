package me.fullpotato.badlandscaves.CustomItems;

import me.fullpotato.badlandscaves.BadlandsCaves;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.UUID;

public class LoadCustomItems {
    private final BadlandsCaves plugin = JavaPlugin.getPlugin(BadlandsCaves.class);

    private static final String[] uuid_names = {
            "2018ae4d-9bf8-47b9-8c1f-3107007afeab",
            "a552bcbf-413c-493d-a2c2-cbcbd0f008cb",
            "f3eadd40-8340-4263-ae9e-0227caa026a8",
            "be191adc-6e88-44eb-98a8-42a383a40025",
            "64bea4b3-5954-4126-bf3e-16f52a3ceec2",
            "df61c558-00a9-4d37-ac7b-2dc1019372aa",
            "af488f76-7285-4654-9602-1d2f5458e859",
            "80c07619-854b-491d-853a-d977bef56aef",
            "8ce28112-3ae0-4463-9040-704098144f56",
            "d9d3e533-d221-45a2-9472-30a8b61eae16",
            "dd867378-1e59-452a-baa5-d0afcc9e7daf",
            "683fc3b5-39aa-4fa5-8d3c-864bd3fd2f10",
            "f6cfed15-13f7-4bc2-92ef-9cf61120d639",
            "91464f55-dda0-469c-b3ae-83a5219a1d3c",
            "f1dd258b-30ac-45a5-b3df-f9354c37f0ea",
            "58d14695-8f06-4aea-a3ca-80a7c779a844",
            "18d43596-3a73-4721-8af2-2e3fbab23de3",
            "21ef0e4b-1368-4e0a-b666-35330c86e696",
            "043267a0-1318-4b45-a5df-0d11ee81316a",
            "024506c6-4fd2-40c0-897b-60007b8af856",
            "bfcabfa7-0489-4cfa-99de-285a38944844",
            "c3413cb5-7be7-4db2-be71-987083ef0dd6",
            "a76e8e2e-ce10-454f-bdc8-958a034bd111",
            "f89fb0e9-20c6-4dae-92ed-2bd0d89bb09f",
            "8006c980-a7a8-4e35-a2be-3d788313ccc2",
            "540644ec-e5a7-40fe-8ad4-fb19ef76d710",
            "ee070dcc-335c-4d34-9e69-33c6dd9feb7c",
            "60fe4d87-4c13-4e41-ba3a-c64157a86296",
            "4886b1aa-cb5f-435e-acc6-bfcf622ca990",
            "b8e8caa9-da29-4f8c-b506-e1dba9300ba9",
            "2a91a5cc-1db3-4b5b-8d73-5f2f51751ebd",
            "d62766f8-2642-4db1-89e4-8ce666b2a23e",
            "6e016348-03e1-4335-a0dd-b3da1decde5c",
            "58dd69e9-2967-4925-8b73-12bcc946972f",
            "77151592-b786-4024-b245-d14f023a0ec4",
            "1e5339e9-7496-434a-9cad-bb6fabf1dc7a",
            "81e69806-43c7-4354-9275-27f3629e5c98",
            "de3fca18-8c87-43ad-9f4b-1c46a7acc30d",
            "1c12b8a1-118c-4647-a71d-86756cf148a3",
            "fb139a0c-6507-48f4-88ed-07044d3abd94",
            "ac155a09-9905-42a9-a240-58221f07cbb2",
            "f332ed08-1974-4dd3-9a0f-d7a6c1edbf06",
    };

    public ItemStack getItem(CustomItem item) {
        if (item.equals(CustomItem.STARTER_SAPLING)){
            ItemStack starter_sapling = new ItemStack(Material.OAK_SAPLING);
            ItemMeta starter_sapling_meta = starter_sapling.getItemMeta();
            starter_sapling_meta.setDisplayName("§8[§aStarter Sapling§8]");
            starter_sapling_meta.addEnchant(Enchantment.DURABILITY, 1, false);
            starter_sapling_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            starter_sapling.setItemMeta(starter_sapling_meta);

            return starter_sapling;
        }

        else if (item.equals(CustomItem.STARTER_BONE_MEAL)){
            ItemStack starter_bone_meal = new ItemStack(Material.BONE_MEAL, 3);
            ItemMeta starter_bone_meal_meta = starter_bone_meal.getItemMeta();
            starter_bone_meal_meta.setDisplayName("§8[§fStarter Bone Meal§8]");
            starter_bone_meal_meta.addEnchant(Enchantment.DURABILITY, 1, false);
            starter_bone_meal_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            starter_bone_meal.setItemMeta(starter_bone_meal_meta);

            return starter_bone_meal;
        }

        else if (item.equals(CustomItem.TOXIC_WATER)){
            ItemStack toxic_water = new ItemStack(Material.POTION);
            PotionMeta toxic_water_meta = (PotionMeta) toxic_water.getItemMeta();
            ArrayList<String> toxic_water_lore = new ArrayList<>();

            toxic_water_meta.setDisplayName("§2Toxic Water Bottle");

            toxic_water_lore.add("§8Leaves a disgusting taste in your mouth");
            toxic_water_meta.setLore(toxic_water_lore);

            toxic_water_meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            toxic_water_meta.setColor(Color.fromRGB(55, 117, 89));
            toxic_water_meta.setBasePotionData(new PotionData(PotionType.WATER));
            toxic_water.setItemMeta(toxic_water_meta);

            return toxic_water;
        }

        else if (item.equals(CustomItem.PURIFIED_WATER)){
            ItemStack purified_water = new ItemStack(Material.POTION);
            PotionMeta purified_water_meta = (PotionMeta) purified_water.getItemMeta();
            ArrayList<String> purified_water_lore = new ArrayList<>();

            purified_water_meta.setDisplayName("§3Purified Water Bottle");

            purified_water_lore.add("§7Light and refreshing.");
            purified_water_meta.setLore(purified_water_lore);

            purified_water_meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            purified_water_meta.setBasePotionData(new PotionData(PotionType.UNCRAFTABLE));
            purified_water_meta.setColor(Color.fromRGB(76, 162, 255));
            purified_water.setItemMeta(purified_water_meta);

            return purified_water;
        }

        else if (item.equals(CustomItem.FISHING_CRATE)){
            ItemStack fishing_crate = new ItemStack(Material.BARREL);
            ItemMeta fishing_crate_meta = fishing_crate.getItemMeta();
            ArrayList<String> fishing_crate_lore = new ArrayList<>();
            fishing_crate_meta.setDisplayName("§2Fishing Crate");

            fishing_crate_lore.add("§7Right click to open.");
            fishing_crate_lore.add("§2Contains Prehardmode Loot.");
            fishing_crate_meta.setLore(fishing_crate_lore);

            fishing_crate_meta.addEnchant(Enchantment.DURABILITY, 1, false);
            fishing_crate_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            fishing_crate.setItemMeta(fishing_crate_meta);

            return fishing_crate;
        }

        else if (item.equals(CustomItem.FISHING_CRATE_HARDMODE)){
            ItemStack fishing_crate_hardmode = new ItemStack(Material.BARREL);
            ItemMeta fishing_crate_hardmode_meta = fishing_crate_hardmode.getItemMeta();
            ArrayList<String> fishing_crate_hardmode_lore = new ArrayList<>();
            fishing_crate_hardmode_meta.setDisplayName("§6Fishing Crate");

            fishing_crate_hardmode_lore.add("§7Right click to open.");
            fishing_crate_hardmode_lore.add("§6Contains Hardmode Loot.");
            fishing_crate_hardmode_meta.setLore(fishing_crate_hardmode_lore);

            fishing_crate_hardmode_meta.addEnchant(Enchantment.DURABILITY, 1, false);
            fishing_crate_hardmode_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            fishing_crate_hardmode.setItemMeta(fishing_crate_hardmode_meta);

            return fishing_crate_hardmode;
        }

        else if (item.equals(CustomItem.ANTIDOTE)){
            ItemStack antidote = new ItemStack(Material.POTION);
            PotionMeta antidote_meta = (PotionMeta) antidote.getItemMeta();
            ArrayList<String> antidote_lore = new ArrayList<>();

            antidote_meta.setDisplayName("§dAntidote Bottle");

            antidote_lore.add("§7Purges the toxins from your body.");
            antidote_meta.setLore(antidote_lore);

            antidote_meta.addEnchant(Enchantment.DURABILITY, 50, true);
            antidote_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS);
            antidote_meta.setBasePotionData(new PotionData(PotionType.UNCRAFTABLE));
            antidote_meta.setColor(Color.fromRGB(224, 74, 188));

            antidote.setItemMeta(antidote_meta);

            return antidote;
        }

        else if (item.equals(CustomItem.MANA_POTION)){
            ItemStack mana_potion = new ItemStack(Material.POTION);
            PotionMeta mana_potion_meta = (PotionMeta) mana_potion.getItemMeta();
            ArrayList<String> mana_potion_lore = new ArrayList<>();

            mana_potion_meta.setDisplayName("§9Mana Potion");

            mana_potion_lore.add("§7Recovers §9100 §7Mana points.");
            mana_potion_meta.setLore(mana_potion_lore);

            mana_potion_meta.addEnchant(Enchantment.DURABILITY, 100, true);
            mana_potion_meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ENCHANTS);
            mana_potion_meta.setColor(Color.fromRGB(54, 137, 255));
            mana_potion_meta.setBasePotionData(new PotionData(PotionType.UNCRAFTABLE));

            mana_potion.setItemMeta(mana_potion_meta);

            return mana_potion;
        }

        else if (item.equals(CustomItem.PURGE_ESSENCE)){
            ItemStack purge_essence = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta purge_essence_meta = purge_essence.getItemMeta();
            purge_essence_meta.setDisplayName("§dEssence of Purging");
            purge_essence_meta.setCustomModelData(101);
            purge_essence.setItemMeta(purge_essence_meta);

            return purge_essence;
        }

        else if (item.equals(CustomItem.HELL_ESSENCE)){
            ItemStack hell_essence = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta hell_essence_meta = hell_essence.getItemMeta();
            hell_essence_meta.setDisplayName("§cEssence of Hell");
            hell_essence_meta.setCustomModelData(105);
            hell_essence.setItemMeta(hell_essence_meta);

            return hell_essence;
        }

        else if (item.equals(CustomItem.MAGIC_ESSENCE)){
            ItemStack magic_essence = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta magic_essence_meta = magic_essence.getItemMeta();
            magic_essence_meta.setDisplayName("§9Essence of Magic");
            magic_essence_meta.setCustomModelData(108);
            magic_essence.setItemMeta(magic_essence_meta);

            return magic_essence;
        }

        else if (item.equals(CustomItem.DISPLACE)){
            ItemStack displace = new ItemStack(Material.KNOWLEDGE_BOOK);
            ItemMeta displace_meta = displace.getItemMeta();
            displace_meta.setDisplayName("§dDisplace");
            displace_meta.setCustomModelData(103);
            displace.setItemMeta(displace_meta);

            return displace;
        }

        else if (item.equals(CustomItem.WITHDRAW)){
            ItemStack withdraw = new ItemStack(Material.KNOWLEDGE_BOOK);
            ItemMeta withdraw_meta = withdraw.getItemMeta();
            withdraw_meta.setDisplayName("§7Withdraw");
            withdraw_meta.setCustomModelData(104);
            withdraw.setItemMeta(withdraw_meta);

            return withdraw;
        }

        else if (item.equals(CustomItem.ENHANCED_EYES)){
            ItemStack enhanced_eyes = new ItemStack(Material.KNOWLEDGE_BOOK);
            ItemMeta enhanced_eyes_meta = enhanced_eyes.getItemMeta();
            enhanced_eyes_meta.setDisplayName("§9Enhanced Eyes");
            enhanced_eyes_meta.setCustomModelData(106);
            enhanced_eyes.setItemMeta(enhanced_eyes_meta);

            return enhanced_eyes;
        }

        else if (item.equals(CustomItem.POSSESS)){
            ItemStack possess = new ItemStack(Material.KNOWLEDGE_BOOK);
            ItemMeta possess_meta = possess.getItemMeta();
            possess_meta.setDisplayName("§2Possession");
            possess_meta.setCustomModelData(107);
            possess.setItemMeta(possess_meta);

            return possess;
        }

        else if (item.equals(CustomItem.TINY_BLAZE_POWDER)){
            ItemStack tiny_blaze_powder = new ItemStack(Material.STRUCTURE_BLOCK, 9);
            ItemMeta tiny_blaze_powder_meta = tiny_blaze_powder.getItemMeta();
            tiny_blaze_powder_meta.setDisplayName(ChatColor.WHITE + "Tiny Pile of Blaze Powder");
            tiny_blaze_powder_meta.setCustomModelData(100);
            tiny_blaze_powder.setItemMeta(tiny_blaze_powder_meta);

            return tiny_blaze_powder;
        }

        else if (item.equals(CustomItem.TAINTED_POWDER)){
            ItemStack tainted_powder = new ItemStack(Material.COMMAND_BLOCK, 2);
            ItemMeta tainted_powder_meta = tainted_powder.getItemMeta();
            ArrayList<String> tainted_powder_lore = new ArrayList<>();
            tainted_powder_meta.setDisplayName("§2Tainted Powder");

            tainted_powder_lore.add("§7Right click to throw.");
            tainted_powder_meta.setLore(tainted_powder_lore);

            tainted_powder_meta.setCustomModelData(102);
            tainted_powder.setItemMeta(tainted_powder_meta);

            return tainted_powder;
        }

        else if (item.equals(CustomItem.ZOMBIE_SOUL)){
            ItemStack zombie_soul = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta zombie_soul_meta = zombie_soul.getItemMeta();
            zombie_soul_meta.setDisplayName(ChatColor.WHITE + "Soul of Decay");
            zombie_soul_meta.setCustomModelData(109);
            zombie_soul.setItemMeta(zombie_soul_meta);

            return zombie_soul;
        }

        else if (item.equals(CustomItem.CREEPER_SOUL)){
            ItemStack creeper_soul = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta creeper_soul_meta = creeper_soul.getItemMeta();
            creeper_soul_meta.setDisplayName(ChatColor.WHITE + "Soul of Destruction");
            creeper_soul_meta.setCustomModelData(110);
            creeper_soul.setItemMeta(creeper_soul_meta);

            return creeper_soul;
        }

        else if (item.equals(CustomItem.SKELETON_SOUL)){
            ItemStack skeleton_soul = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta skeleton_soul_meta = skeleton_soul.getItemMeta();
            skeleton_soul_meta.setDisplayName(ChatColor.WHITE + "Soul of War");
            skeleton_soul_meta.setCustomModelData(111);
            skeleton_soul.setItemMeta(skeleton_soul_meta);

            return skeleton_soul;
        }

        else if (item.equals(CustomItem.SPIDER_SOUL)){
            ItemStack spider_soul = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta spider_soul_meta = spider_soul.getItemMeta();
            spider_soul_meta.setDisplayName(ChatColor.WHITE + "Soul of Arachnid");
            spider_soul_meta.setCustomModelData(112);
            spider_soul.setItemMeta(spider_soul_meta);

            return spider_soul;
        }

        else if (item.equals(CustomItem.PIGZOMBIE_SOUL)){
            ItemStack pigzombie_soul = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta pigzombie_soul_meta = pigzombie_soul.getItemMeta();
            pigzombie_soul_meta.setDisplayName(ChatColor.WHITE + "Soul of Hellish Decay");
            pigzombie_soul_meta.setCustomModelData(113);
            pigzombie_soul.setItemMeta(pigzombie_soul_meta);

            return pigzombie_soul;
        }

        else if (item.equals(CustomItem.GHAST_SOUL)){
            ItemStack ghast_soul = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta ghast_soul_meta = ghast_soul.getItemMeta();
            ghast_soul_meta.setDisplayName(ChatColor.WHITE + "Soul of Suffering");
            ghast_soul_meta.setCustomModelData(114);
            ghast_soul.setItemMeta(ghast_soul_meta);

            return ghast_soul;
        }

        else if (item.equals(CustomItem.SILVERFISH_SOUL)){
            ItemStack silverfish_soul = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta silverfish_soul_meta = silverfish_soul.getItemMeta();
            silverfish_soul_meta.setDisplayName(ChatColor.WHITE + "Soul of Parasite");
            silverfish_soul_meta.setCustomModelData(115);
            silverfish_soul.setItemMeta(silverfish_soul_meta);

            return silverfish_soul;
        }

        else if (item.equals(CustomItem.WITCH_SOUL)){
            ItemStack witch_soul = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta witch_soul_meta = witch_soul.getItemMeta();
            witch_soul_meta.setDisplayName(ChatColor.WHITE + "Soul of Supernatural");
            witch_soul_meta.setCustomModelData(116);
            witch_soul.setItemMeta(witch_soul_meta);

            return witch_soul;
        }

        else if (item.equals(CustomItem.PHANTOM_SOUL)){
            ItemStack phantom_soul = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta phantom_soul_meta = phantom_soul.getItemMeta();
            phantom_soul_meta.setDisplayName(ChatColor.WHITE + "Soul of Insomnia");
            phantom_soul_meta.setCustomModelData(117);
            phantom_soul.setItemMeta(phantom_soul_meta);

            return phantom_soul;
        }

        else if (item.equals(CustomItem.MERGED_SOULS)){
            ItemStack merged_souls = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta merged_souls_meta = merged_souls.getItemMeta();
            ArrayList<String> merged_souls_lore = new ArrayList<>();

            merged_souls_meta.setDisplayName("§9§k%§r§d§lMerged Souls§r§9§k%");
            merged_souls_lore.add(ChatColor.GRAY + "If you listen closely, you can hear the screams.");
            merged_souls_meta.setLore(merged_souls_lore);
            merged_souls_meta.setCustomModelData(118);
            merged_souls.setItemMeta(merged_souls_meta);

            return merged_souls;
        }

        else if (item.equals(CustomItem.SOUL_CRYSTAL_INCOMPLETE)){
            ItemStack soul_crystal_incomplete = new ItemStack(Material.KNOWLEDGE_BOOK);
            ItemMeta soul_crystal_incomplete_meta = soul_crystal_incomplete.getItemMeta();
            ArrayList<String> soul_crystal_incomplete_lore = new ArrayList<>();

            soul_crystal_incomplete_meta.setDisplayName("§3§k%§r§5§lIncomplete Soul Crystal§r§3§k%");

            soul_crystal_incomplete_lore.add("§9§lRight Click§r§7 to collect your own soul. Be prepared to fight.");
            soul_crystal_incomplete_lore.add("§7Requires a human soul to complete.");
            soul_crystal_incomplete_lore.add("§7Uses Left: 9");
            soul_crystal_incomplete_meta.setLore(soul_crystal_incomplete_lore);

            soul_crystal_incomplete_meta.setCustomModelData(119);
            soul_crystal_incomplete.setItemMeta(soul_crystal_incomplete_meta);

            return soul_crystal_incomplete;
        }

        else if (item.equals(CustomItem.SOUL_CRYSTAL)){
            ItemStack soul_crystal = new ItemStack(Material.KNOWLEDGE_BOOK);
            ItemMeta soul_crystal_meta = soul_crystal.getItemMeta();
            ArrayList<String> soul_crystal_lore = new ArrayList<>();

            soul_crystal_meta.setDisplayName("§b§k%§r§d§lSoul Crystal§r§b§k%");

            soul_crystal_lore.add("§9§lRight Click§r§7 to use.");
            soul_crystal_lore.add("§7Can be used as a sacrifice to enter Descension§r§7.");
            soul_crystal_lore.add("§7Uses Left: 10");
            soul_crystal_meta.setLore(soul_crystal_lore);

            soul_crystal_meta.setCustomModelData(120);
            soul_crystal.setItemMeta(soul_crystal_meta);

            return soul_crystal;
        }

        else if (item.equals(CustomItem.RUNE)){
            ItemStack rune = new ItemStack(Material.KNOWLEDGE_BOOK);
            ItemMeta rune_meta = rune.getItemMeta();
            ArrayList<String> rune_lore = new ArrayList<>();

            rune_meta.setDisplayName("§8§lRune");

            rune_lore.add("§9§lRight Click§r§7 to use.");
            rune_lore.add("§7Used to upgrade Supernatural Abilities.");
            rune_lore.add("§70 / 8 §dMerged Souls");
            rune_lore.add("§70 / 8 §9Essences of Magic");

            rune_meta.setLore(rune_lore);

            rune_meta.setCustomModelData(121);
            rune.setItemMeta(rune_meta);

            return rune;
        }

        else if (item.equals(CustomItem.CHARGED_RUNE)){
            ItemStack charged_rune = new ItemStack(Material.KNOWLEDGE_BOOK);
            ItemMeta charged_rune_meta = charged_rune.getItemMeta();
            ArrayList<String> charged_rune_lore = new ArrayList<>();

            charged_rune_meta.setDisplayName("§d§k%§r§8§lRune§r§9§k%");

            charged_rune_lore.add("§9§lRight Click§r§7 to upgrade Supernatural Abilities.");

            charged_rune_meta.setLore(charged_rune_lore);

            charged_rune_meta.setCustomModelData(122);
            charged_rune.setItemMeta(charged_rune_meta);

            return charged_rune;
        }

        else if (item.equals(CustomItem.VOLTSHOCK_BATTERY)){
            ItemStack voltshock_battery = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta voltshock_batter_meta = voltshock_battery.getItemMeta();
            voltshock_batter_meta.setDisplayName(ChatColor.WHITE + "Battery");
            voltshock_batter_meta.setCustomModelData(125);
            voltshock_battery.setItemMeta(voltshock_batter_meta);

            return voltshock_battery;
        }

        else if (item.equals(CustomItem.VOLTSHOCK_SHOCKER)){
            ItemStack voltshock_shocker = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta voltshock_shocker_meta = voltshock_shocker.getItemMeta();
            voltshock_shocker_meta.setDisplayName(ChatColor.WHITE + "Shocker");
            voltshock_shocker_meta.setCustomModelData(126);
            voltshock_shocker.setItemMeta(voltshock_shocker_meta);

            return voltshock_shocker;
        }

        else if (item.equals(CustomItem.VOLTSHOCK_PLACEHOLDER)) {
            ItemStack voltshock_placeholder = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta voltshock_placeholder_meta = voltshock_placeholder.getItemMeta();
            voltshock_placeholder_meta.setDisplayName(ChatColor.WHITE + "Voltshock Sword");
            voltshock_placeholder_meta.setCustomModelData(136);
            voltshock_placeholder.setItemMeta(voltshock_placeholder_meta);

            return voltshock_placeholder;
        }

        else if (item.equals(CustomItem.VOLTSHOCK_SWORD_CHARGE_PLACEHOLDER)) {
            ItemStack voltshock_sword_charge_placeholder = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta voltshock_sword_charge_placeholder_meta = voltshock_sword_charge_placeholder.getItemMeta();
            voltshock_sword_charge_placeholder_meta.setDisplayName(ChatColor.WHITE + "Charge Voltshock Sword");
            voltshock_sword_charge_placeholder_meta.setCustomModelData(137);
            voltshock_sword_charge_placeholder.setItemMeta(voltshock_sword_charge_placeholder_meta);

            return voltshock_sword_charge_placeholder;
        }

        else if (item.equals(CustomItem.VOLTSHOCK_ARROW)){
            ItemStack voltshock_arrow = new ItemStack(Material.ARROW);
            ItemMeta voltshock_arrow_meta = voltshock_arrow.getItemMeta();
            voltshock_arrow_meta.setDisplayName("§3Voltshock Arrow");
            voltshock_arrow_meta.setCustomModelData(131);
            voltshock_arrow.setItemMeta(voltshock_arrow_meta);

            return voltshock_arrow;
        }

        else if (item.equals(CustomItem.CORROSIVE_SUBSTANCE)){
            ItemStack corrosive_substance = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta corrosive_substance_meta = corrosive_substance.getItemMeta();
            corrosive_substance_meta.setDisplayName("§2Corrosive Substance");
            corrosive_substance_meta.setCustomModelData(129);
            corrosive_substance.setItemMeta(corrosive_substance_meta);

            return corrosive_substance;
        }

        else if (item.equals(CustomItem.CORROSIVE_PLACEHOLDER)) {
            ItemStack corrosive_placeholder = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta corrosive_placeholder_meta = corrosive_placeholder.getItemMeta();
            corrosive_placeholder_meta.setDisplayName(ChatColor.WHITE + "Corrosive Sword");
            corrosive_placeholder_meta.setCustomModelData(138);
            corrosive_placeholder.setItemMeta(corrosive_placeholder_meta);

            return corrosive_placeholder;
        }

        else if (item.equals(CustomItem.CORROSIVE_ARROW)){
            ItemStack corrosive_arrow = new ItemStack(Material.ARROW);
            ItemMeta corrosive_arrow_meta = corrosive_arrow.getItemMeta();
            corrosive_arrow_meta.setDisplayName("§2Corrosive Arrow");
            corrosive_arrow_meta.setCustomModelData(132);
            corrosive_arrow.setItemMeta(corrosive_arrow_meta);

            return corrosive_arrow;
        }

        else if (item.equals(CustomItem.CHAMBER_MAGMA_KEY)){
            ItemStack chamber_magma_key = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta chamber_magma_key_meta = chamber_magma_key.getItemMeta();
            chamber_magma_key_meta.setDisplayName("§cMagma Key");
            chamber_magma_key_meta.setCustomModelData(133);
            chamber_magma_key.setItemMeta(chamber_magma_key_meta);

            return chamber_magma_key;
        }

        else if (item.equals(CustomItem.CHAMBER_GLOWSTONE_KEY)){
            ItemStack chamber_glowstone_key = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta chamber_glowstone_key_meta = chamber_glowstone_key.getItemMeta();
            chamber_glowstone_key_meta.setDisplayName("§6Glowstone Key");
            chamber_glowstone_key_meta.setCustomModelData(134);
            chamber_glowstone_key.setItemMeta(chamber_glowstone_key_meta);

            return chamber_glowstone_key;
        }

        else if (item.equals(CustomItem.CHAMBER_SOULSAND_KEY)){
            ItemStack chamber_soulsand_key = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta chamber_soulsand_key_meta = chamber_soulsand_key.getItemMeta();
            chamber_soulsand_key_meta.setDisplayName("§8Soul Sand Key");
            chamber_soulsand_key_meta.setCustomModelData(135);
            chamber_soulsand_key.setItemMeta(chamber_soulsand_key_meta);

            return chamber_soulsand_key;
        }

        else if (item.equals(CustomItem.BLESSED_APPLE)){
            ItemStack blessed_apple = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta blessed_apple_meta = blessed_apple.getItemMeta();
            blessed_apple_meta.setDisplayName("§bBlessed Apple");
            blessed_apple_meta.setCustomModelData(139);
            blessed_apple.setItemMeta(blessed_apple_meta);

            return blessed_apple;
        }

        else if (item.equals(CustomItem.ENCHANTED_BLESSED_APPLE)){
            ItemStack enchanted_blessed_apple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
            ItemMeta enchanted_blessed_apple_meta = enchanted_blessed_apple.getItemMeta();
            enchanted_blessed_apple_meta.setDisplayName("§dEnchanted Blessed Apple");
            enchanted_blessed_apple_meta.setCustomModelData(140);
            enchanted_blessed_apple.setItemMeta(enchanted_blessed_apple_meta);

            return enchanted_blessed_apple;
        }

        else if (item.equals(CustomItem.STONE_SHIELD)){
            ItemStack stone_shield = new ItemStack(Material.SHIELD);
            ItemMeta stone_shield_meta = stone_shield.getItemMeta();
            stone_shield_meta.setDisplayName(ChatColor.WHITE + "Stone Shield");
            stone_shield_meta.setCustomModelData(141);
            stone_shield_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.fromString(uuid_names[0]), "Shield Speed Modifier", -0.2, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.OFF_HAND));
            stone_shield_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.fromString(uuid_names[1]), "Shield Speed Modifier", -0.2, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND));
            stone_shield_meta.addEnchant(Enchantment.DURABILITY, 4, true);
            stone_shield.setItemMeta(stone_shield_meta);

            return stone_shield;
        }

        else if (item.equals(CustomItem.IRON_SHIELD)){
            ItemStack iron_shield = new ItemStack(Material.SHIELD);
            ItemMeta iron_shield_meta = iron_shield.getItemMeta();
            iron_shield_meta.setDisplayName(ChatColor.WHITE + "Iron Shield");
            iron_shield_meta.setCustomModelData(142);
            iron_shield_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.fromString(uuid_names[2]), "Shield Speed Modifier", -0.3, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.OFF_HAND));
            iron_shield_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.fromString(uuid_names[3]), "Shield Speed Modifier", -0.3, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND));
            iron_shield_meta.addEnchant(Enchantment.DURABILITY, 5, true);
            iron_shield.setItemMeta(iron_shield_meta);

            return iron_shield;
        }

        else if (item.equals(CustomItem.DIAMOND_SHIELD)){
            ItemStack diamond_shield = new ItemStack(Material.SHIELD);
            ItemMeta diamond_shield_meta = diamond_shield.getItemMeta();
            diamond_shield_meta.setDisplayName(ChatColor.WHITE + "Diamond Shield");
            diamond_shield_meta.setCustomModelData(144);
            diamond_shield_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.fromString(uuid_names[4]), "Shield Speed Modifier", -0.4, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.OFF_HAND));
            diamond_shield_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.fromString(uuid_names[5]), "Shield Speed Modifier", -0.4, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND));
            diamond_shield_meta.addEnchant(Enchantment.DURABILITY, 6, true);
            diamond_shield.setItemMeta(diamond_shield_meta);

            return diamond_shield;
        }

        else if (item.equals(CustomItem.RECALL_POTION)){
            ItemStack recall_potion = new ItemStack(Material.POTION);
            PotionMeta recall_potion_meta = (PotionMeta) recall_potion.getItemMeta();
            ArrayList<String> recall_potion_lore = new ArrayList<>();

            recall_potion_meta.setDisplayName("§eRecall Potion");

            recall_potion_lore.add("§7Brings you home.");
            recall_potion_lore.add("§cDo not move when using!");
            recall_potion_meta.setLore(recall_potion_lore);

            recall_potion_meta.addEnchant(Enchantment.DURABILITY, 50, true);
            recall_potion_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS);
            recall_potion_meta.setBasePotionData(new PotionData(PotionType.UNCRAFTABLE));
            recall_potion_meta.setColor(Color.fromRGB(255, 255, 0));

            recall_potion.setItemMeta(recall_potion_meta);

            return recall_potion;
        }

        else if (item.equals(CustomItem.TITANIUM_FRAGMENT)){
            ItemStack titanium_fragment = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta titanium_fragment_meta = titanium_fragment.getItemMeta();
            titanium_fragment_meta.setDisplayName("§bTitanium Fragment");
            titanium_fragment_meta.setCustomModelData(143);
            titanium_fragment.setItemMeta(titanium_fragment_meta);

            return titanium_fragment;
        }

        else if (item.equals(CustomItem.TITANIUM_INGOT)) {
            ItemStack titanium_ingot = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta titanium_ingot_meta = titanium_ingot.getItemMeta();
            titanium_ingot_meta.setDisplayName("§bTitanium Ingot");
            titanium_ingot_meta.setCustomModelData(144);
            titanium_ingot.setItemMeta(titanium_ingot_meta);

            return titanium_ingot;
        }

        else if (item.equals(CustomItem.REINFORCED_TITANIUM)) {
            ItemStack reinforced_titanium = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta meta = reinforced_titanium.getItemMeta();
            meta.setDisplayName("§eReinforced Titanium Ingot");
            meta.setCustomModelData(176);
            reinforced_titanium.setItemMeta(meta);

            return reinforced_titanium;
        }

        else if (item.equals(CustomItem.TITANIUM_ROD)) {
            ItemStack titanium_rod = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta titanium_rod_meta = titanium_rod.getItemMeta();
            titanium_rod_meta.setDisplayName("§bTitanium Rod");
            titanium_rod_meta.setCustomModelData(166);
            titanium_rod.setItemMeta(titanium_rod_meta);

            return titanium_rod;
        }

        else if (item.equals(CustomItem.BINDING)){
            ItemStack binding = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta binding_meta = binding.getItemMeta();
            binding_meta.setDisplayName(ChatColor.WHITE + "Binding");
            binding_meta.setCustomModelData(145);
            binding.setItemMeta(binding_meta);

            return binding;
        }

        else if (item.equals(CustomItem.GOLDEN_CABLE)){
            ItemStack golden_cable = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta golden_cable_meta = golden_cable.getItemMeta();
            golden_cable_meta.setDisplayName(ChatColor.WHITE + "Golden Cable");
            golden_cable_meta.setCustomModelData(146);
            golden_cable.setItemMeta(golden_cable_meta);

            return golden_cable;
        }

        else if (item.equals(CustomItem.NETHER_STAR_FRAGMENT)){
            ItemStack nether_star_fragment = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta nether_star_fragment_meta = nether_star_fragment.getItemMeta();
            nether_star_fragment_meta.setDisplayName("§eNether Star Fragment");
            nether_star_fragment_meta.setCustomModelData(147);
            nether_star_fragment.setItemMeta(nether_star_fragment_meta);

            return nether_star_fragment;
        }

        else if (item.equals(CustomItem.STARLIGHT_CIRCUIT)){
            ItemStack starlight_circuit = new ItemStack(Material.STRUCTURE_BLOCK);
            ItemMeta starlight_circuit_meta = starlight_circuit.getItemMeta();
            starlight_circuit_meta.setDisplayName("§eStarlight Circuit");
            starlight_circuit_meta.setCustomModelData(148);
            starlight_circuit.setItemMeta(starlight_circuit_meta);

            return starlight_circuit;
        }

        else if (item.equals(CustomItem.STARLIGHT_BATTERY)){
            ItemStack starlight_battery = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta starlight_battery_meta = starlight_battery.getItemMeta();
            starlight_battery_meta.setDisplayName("§eStarlight Battery");
            starlight_battery_meta.setCustomModelData(149);
            starlight_battery.setItemMeta(starlight_battery_meta);

            return starlight_battery;
        }

        else if (item.equals(CustomItem.STARLIGHT_MODULE)){
            ItemStack starlight_module = new ItemStack(Material.STRUCTURE_BLOCK);
            ItemMeta starlight_module_meta = starlight_module.getItemMeta();
            starlight_module_meta.setDisplayName("§eStarlight Module");
            starlight_module_meta.setCustomModelData(150);
            starlight_module.setItemMeta(starlight_module_meta);

            return starlight_module;
        }

        else if (item.equals(CustomItem.PHOTON_EMITTER)) {
            ItemStack photon_emitter = new ItemStack(Material.STRUCTURE_BLOCK);
            ItemMeta photon_emitter_meta = photon_emitter.getItemMeta();
            photon_emitter_meta.setDisplayName("§ePhoton Emitter");
            photon_emitter_meta.setCustomModelData(167);
            photon_emitter.setItemMeta(photon_emitter_meta);

            return photon_emitter;
        }

        else if (item.equals(CustomItem.FOREVER_FISH)) {
            ItemStack forever_fish = new ItemStack(Material.COOKED_COD);
            ItemMeta forever_fish_meta = forever_fish.getItemMeta();
            forever_fish_meta.setDisplayName("§6Forever Fish");
            forever_fish_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            forever_fish_meta.addEnchant(Enchantment.DURABILITY, 1, true);

            ArrayList<String> forever_fish_lore = new ArrayList<>();
            forever_fish_lore.add("§7Give a man a fish, feed him for a day.");
            forever_fish_lore.add("§7Give him a Forever Fish, feed him for a lifetime.");
            forever_fish_meta.setLore(forever_fish_lore);

            forever_fish.setItemMeta(forever_fish_meta);

            return forever_fish;
        }
        else if (item.equals(CustomItem.STARLIGHT_HELMET)) {
            ItemStack starlight_helmet = new ItemStack(Material.NETHERITE_HELMET);
            ItemMeta starlight_helmet_meta = starlight_helmet.getItemMeta();
            starlight_helmet_meta.setDisplayName("§eStarlight Helmet");

            ArrayList<String> starlight_helmet_lore = new ArrayList<>();
            starlight_helmet_lore.add("§7Charge: 0 / 1000");
            starlight_helmet_meta.setLore(starlight_helmet_lore);

            starlight_helmet_meta.setCustomModelData(151);
            starlight_helmet_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_charge"), PersistentDataType.INTEGER, 0);
            starlight_helmet_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_plating"), PersistentDataType.SHORT, (short) 0);
            starlight_helmet_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_max_charge"), PersistentDataType.INTEGER, 1000);
            starlight_helmet_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_starlight_armor"), PersistentDataType.BYTE, (byte) 1);
            starlight_helmet_meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.fromString(uuid_names[6]), "Starlight Base Armor", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
            starlight_helmet_meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.fromString(uuid_names[7]), "Starlight Base Armor Toughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
            starlight_helmet_meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
            starlight_helmet_meta.addEnchant(Enchantment.DURABILITY, 5, true);

            Damageable damageable = (Damageable) starlight_helmet_meta;
            damageable.setDamage(starlight_helmet.getType().getMaxDurability() - 1);

            Repairable repairable = (Repairable) damageable;
            repairable.setRepairCost(999999);

            starlight_helmet.setItemMeta((ItemMeta) repairable);
            return starlight_helmet;
        }
        else if (item.equals(CustomItem.STARLIGHT_CHESTPLATE)) {
            ItemStack starlight_chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
            ItemMeta starlight_chestplate_meta = starlight_chestplate.getItemMeta();
            starlight_chestplate_meta.setDisplayName("§eStarlight Chestplate");

            ArrayList<String> starlight_chestplate_lore = new ArrayList<>();
            starlight_chestplate_lore.add("§7Charge: 0 / 1000");
            starlight_chestplate_meta.setLore(starlight_chestplate_lore);

            starlight_chestplate_meta.setCustomModelData(152);
            starlight_chestplate_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_charge"), PersistentDataType.INTEGER, 0);
            starlight_chestplate_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_plating"), PersistentDataType.SHORT, (short) 0);
            starlight_chestplate_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_max_charge"), PersistentDataType.INTEGER, 1000);
            starlight_chestplate_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_starlight_armor"), PersistentDataType.BYTE, (byte) 1);
            starlight_chestplate_meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.fromString(uuid_names[8]), "Starlight Base Armor", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST));
            starlight_chestplate_meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.fromString(uuid_names[9]), "Starlight Base Armor Toughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST));
            starlight_chestplate_meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
            starlight_chestplate_meta.addEnchant(Enchantment.DURABILITY, 5, true);

            Damageable damageable = (Damageable) starlight_chestplate_meta;
            damageable.setDamage(starlight_chestplate.getType().getMaxDurability() - 1);

            Repairable repairable = (Repairable) damageable;
            repairable.setRepairCost(999999);

            starlight_chestplate.setItemMeta((ItemMeta) repairable);
            return starlight_chestplate;
        }
        else if (item.equals(CustomItem.STARLIGHT_LEGGINGS)) {
            ItemStack starlight_leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
            ItemMeta starlight_leggings_meta = starlight_leggings.getItemMeta();
            starlight_leggings_meta.setDisplayName("§eStarlight Leggings");

            ArrayList<String> starlight_leggings_lore = new ArrayList<>();
            starlight_leggings_lore.add("§7Charge: 0 / 1000");
            starlight_leggings_meta.setLore(starlight_leggings_lore);

            starlight_leggings_meta.setCustomModelData(153);
            starlight_leggings_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_charge"), PersistentDataType.INTEGER, 0);
            starlight_leggings_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_plating"), PersistentDataType.SHORT, (short) 0);
            starlight_leggings_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_max_charge"), PersistentDataType.INTEGER, 1000);
            starlight_leggings_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_starlight_armor"), PersistentDataType.BYTE, (byte) 1);
            starlight_leggings_meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.fromString(uuid_names[10]), "Starlight Base Armor", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS));
            starlight_leggings_meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.fromString(uuid_names[11]), "Starlight Base Armor Toughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS));
            starlight_leggings_meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
            starlight_leggings_meta.addEnchant(Enchantment.DURABILITY, 5, true);

            Damageable damageable = (Damageable) starlight_leggings_meta;
            damageable.setDamage(starlight_leggings.getType().getMaxDurability() - 1);

            Repairable repairable = (Repairable) damageable;
            repairable.setRepairCost(999999);

            starlight_leggings.setItemMeta((ItemMeta) repairable);
            return starlight_leggings;
        }
        else if (item.equals(CustomItem.STARLIGHT_BOOTS)) {
            ItemStack starlight_boots = new ItemStack(Material.NETHERITE_BOOTS);
            ItemMeta starlight_boots_meta = starlight_boots.getItemMeta();
            starlight_boots_meta.setDisplayName("§eStarlight Boots");

            ArrayList<String> starlight_boots_lore = new ArrayList<>();
            starlight_boots_lore.add("§7Charge: 0 / 1000");
            starlight_boots_meta.setLore(starlight_boots_lore);

            starlight_boots_meta.setCustomModelData(154);
            starlight_boots_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_charge"), PersistentDataType.INTEGER, 0);
            starlight_boots_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_plating"), PersistentDataType.SHORT, (short) 0);
            starlight_boots_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_max_charge"), PersistentDataType.INTEGER, 1000);
            starlight_boots_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_starlight_armor"), PersistentDataType.BYTE, (byte) 1);
            starlight_boots_meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.fromString(uuid_names[12]), "Starlight Base Armor", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
            starlight_boots_meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.fromString(uuid_names[13]), "Starlight Base Armor Toughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
            starlight_boots_meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
            starlight_boots_meta.addEnchant(Enchantment.DURABILITY, 5, true);

            Damageable damageable = (Damageable) starlight_boots_meta;
            damageable.setDamage(starlight_boots.getType().getMaxDurability() - 1);

            Repairable repairable = (Repairable) damageable;
            repairable.setRepairCost(999999);

            starlight_boots.setItemMeta((ItemMeta) repairable);
            return starlight_boots;
        }
        else if (item.equals(CustomItem.STARLIGHT_SABER)) {
            ItemStack saber = new ItemStack(Material.NETHERITE_SWORD);
            ItemMeta saber_meta = saber.getItemMeta();
            saber_meta.setDisplayName("§eStarlight Saber");
            saber_meta.setCustomModelData(163);

            ArrayList<String> saber_lore = new ArrayList<>();
            saber_lore.add("§7Charge: 0 / 2000");
            saber_meta.setLore(saber_lore);

            saber_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_starlight_saber"), PersistentDataType.BYTE, (byte) 1);
            saber_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_charge"), PersistentDataType.INTEGER, 0);
            saber_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_max_charge"), PersistentDataType.INTEGER, 2000);

            saber_meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
            saber_meta.addEnchant(Enchantment.DURABILITY, 5, true);

            Damageable damageable = (Damageable) saber_meta;
            damageable.setDamage(saber.getType().getMaxDurability() - 1);

            Repairable repairable = (Repairable) damageable;
            repairable.setRepairCost(999999);

            saber.setItemMeta((ItemMeta) repairable);
            return saber;
        }
        else if (item.equals(CustomItem.STARLIGHT_SHIELD)) {
            ItemStack shield = new ItemStack(Material.SHIELD);
            ItemMeta meta = shield.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + "Starlight Shield");
            meta.setCustomModelData(177);

            ArrayList<String> lore = new ArrayList<>();
            lore.add("§7Charge: 0 / 2000");
            meta.setLore(lore);

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_starlight_shield"), PersistentDataType.BYTE, (byte) 1);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_charge"), PersistentDataType.INTEGER, 0);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_max_charge"), PersistentDataType.INTEGER, 2000);

            meta.addEnchant(Enchantment.DURABILITY, 5, true);

            Damageable damageable = (Damageable) meta;
            damageable.setDamage(shield.getType().getMaxDurability() - 1);

            Repairable repairable = (Repairable) damageable;
            repairable.setRepairCost(999999);

            shield.setItemMeta((ItemMeta) repairable);
            return shield;
        }
        else if (item.equals(CustomItem.STARLIGHT_BLASTER)) {
            ItemStack blaster = new ItemStack(Material.CROSSBOW);
            CrossbowMeta blaster_meta = (CrossbowMeta) blaster.getItemMeta();
            blaster_meta.setDisplayName("§eStarlight Blaster");
            blaster_meta.setCustomModelData(164);

            ArrayList<String> blaster_lore = new ArrayList<>();
            blaster_lore.add("§7Charge: 0 / 2000");
            blaster_meta.setLore(blaster_lore);

            blaster_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_starlight_blaster"), PersistentDataType.BYTE, (byte) 1);
            blaster_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_charge"), PersistentDataType.INTEGER, 0);
            blaster_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_max_charge"), PersistentDataType.INTEGER, 2000);
            blaster_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "blaster_cooldown"), PersistentDataType.SHORT, (short) 0);

            blaster_meta.addEnchant(Enchantment.DURABILITY, 1, true);
            blaster_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            ItemStack empty = new ItemStack(Material.ARROW);
            ItemMeta emptyMeta = empty.getItemMeta();
            emptyMeta.setDisplayName(ChatColor.WHITE + "");
            empty.setItemMeta(emptyMeta);

            blaster_meta.addChargedProjectile(empty);

            Damageable damageable = (Damageable) blaster_meta;
            damageable.setDamage(blaster.getType().getMaxDurability() - 1);

            Repairable repairable = (Repairable) damageable;
            repairable.setRepairCost(999999);

            blaster.setItemMeta((ItemMeta) repairable);
            return blaster;
        }
        else if (item.equals(CustomItem.STARLIGHT_PAXEL)) {
            ItemStack paxel_pick = new ItemStack(Material.NETHERITE_PICKAXE);
            ItemMeta paxel_meta = paxel_pick.getItemMeta();
            paxel_meta.setDisplayName("§eStarlight Paxel");
            paxel_meta.setCustomModelData(165);

            ArrayList<String> paxel_lore = new ArrayList<>();
            paxel_lore.add("§7Charge: 0 / 2000");
            paxel_meta.setLore(paxel_lore);

            paxel_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_starlight_paxel"), PersistentDataType.BYTE, (byte) 1);
            paxel_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_charge"), PersistentDataType.INTEGER, 0);
            paxel_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "starlight_max_charge"), PersistentDataType.INTEGER, 2000);

            paxel_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.fromString(uuid_names[14]), "Starlight Paxel No Damage", -999999, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
            paxel_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.fromString(uuid_names[15]), "Starlight Paxel Instant Raise", 999999, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
            paxel_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            paxel_meta.addEnchant(Enchantment.DIG_SPEED, 7, true);
            paxel_meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
            paxel_meta.addEnchant(Enchantment.DURABILITY, 5, true);

            Damageable damageable = (Damageable) paxel_meta;
            damageable.setDamage(paxel_pick.getType().getMaxDurability() - 1);

            Repairable repairable = (Repairable) damageable;
            repairable.setRepairCost(999999);

            paxel_pick.setItemMeta(paxel_meta);
            return paxel_pick;
        }
        else if (item.equals(CustomItem.ENERGIUM)) {
            ItemStack energium = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta energium_meta = energium.getItemMeta();
            energium_meta.setDisplayName("§cEnergium");
            energium_meta.setCustomModelData(155);
            energium.setItemMeta(energium_meta);

            return energium;
        }
        else if (item.equals(CustomItem.ENERGY_CORE)) {
            ItemStack energy_core = new ItemStack(Material.KNOWLEDGE_BOOK);
            ItemMeta energy_core_meta = energy_core.getItemMeta();
            energy_core_meta.setCustomModelData(156);
            energy_core_meta.setDisplayName("§bEnergy Core");

            ArrayList<String> energy_core_lore = new ArrayList<>();
            energy_core_lore.add("§7Charge: 0");
            energy_core_meta.setLore(energy_core_lore);

            energy_core_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "energy_core_charge"), PersistentDataType.INTEGER, 0);
            energy_core_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_energy_core"), PersistentDataType.BYTE, (byte) 1);
            energy_core.setItemMeta(energy_core_meta);

            return energy_core;
        }
        else if (item.equals(CustomItem.STARLIGHT_CHARGE_PLACEHOLDER)) {
            ItemStack charge_placeholder = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta charge_placeholder_meta = charge_placeholder.getItemMeta();
            charge_placeholder_meta.setCustomModelData(157);
            charge_placeholder_meta.setDisplayName(ChatColor.WHITE + "Charge Starlight Armor");

            charge_placeholder.setItemMeta(charge_placeholder_meta);

            return charge_placeholder;
        }
        else if (item.equals(CustomItem.VOIDMATTER)) {
            ItemStack voidmatter = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta voidmatter_meta = voidmatter.getItemMeta();
            voidmatter_meta.setDisplayName("§5Voidmatter");
            voidmatter_meta.setCustomModelData(158);
            voidmatter.setItemMeta(voidmatter_meta);

            return voidmatter;
        }
        else if (item.equals(CustomItem.VOIDMATTER_STICK)) {
            ItemStack voidmatter_stick = new ItemStack(Material.STRUCTURE_BLOCK);
            ItemMeta meta = voidmatter_stick.getItemMeta();
            meta.setDisplayName("§5Void Stick");
            meta.setCustomModelData(173);
            voidmatter_stick.setItemMeta(meta);

            return voidmatter_stick;
        }
        else if (item.equals(CustomItem.VOIDMATTER_STRING)) {
            ItemStack string = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta meta = string.getItemMeta();
            meta.setDisplayName("§5Void String");
            meta.setCustomModelData(174);
            string.setItemMeta(meta);

            return string;
        }
        else if (item.equals(CustomItem.VOIDMATTER_HELMET)) {
            ItemStack voidmatter_helmet = new ItemStack(Material.NETHERITE_HELMET);
            ItemMeta voidmatter_helmet_meta = voidmatter_helmet.getItemMeta();
            voidmatter_helmet_meta.setDisplayName("§5Void Mask");

            ArrayList<String> voidmatter_helmet_lore = new ArrayList<>();
            voidmatter_helmet_lore.add("§7Set Effect: 2x Mana Regeneration");
            voidmatter_helmet_meta.setLore(voidmatter_helmet_lore);

            voidmatter_helmet_meta.setCustomModelData(159);
            voidmatter_helmet_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_voidmatter_armor"), PersistentDataType.BYTE, (byte) 1);
            voidmatter_helmet_meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            voidmatter_helmet_meta.addEnchant(Enchantment.DURABILITY, 10, true);

            Repairable repairable = (Repairable) voidmatter_helmet_meta;
            repairable.setRepairCost(999999);

            voidmatter_helmet.setItemMeta((ItemMeta) repairable);
            return voidmatter_helmet;
        }
        else if (item.equals(CustomItem.VOIDMATTER_CHESTPLATE)) {
            ItemStack voidmatter_chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
            ItemMeta voidmatter_chestplate_meta = voidmatter_chestplate.getItemMeta();
            voidmatter_chestplate_meta.setDisplayName("§5Void Tunic");

            ArrayList<String> voidmatter_chesplate_lore = new ArrayList<>();
            voidmatter_chesplate_lore.add("§7Set Effect: 2x Mana Regeneration");
            voidmatter_chestplate_meta.setLore(voidmatter_chesplate_lore);

            voidmatter_chestplate_meta.setCustomModelData(160);
            voidmatter_chestplate_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_voidmatter_armor"), PersistentDataType.BYTE, (byte) 1);
            voidmatter_chestplate_meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            voidmatter_chestplate_meta.addEnchant(Enchantment.DURABILITY, 10, true);

            Repairable repairable = (Repairable) voidmatter_chestplate_meta;
            repairable.setRepairCost(999999);

            voidmatter_chestplate.setItemMeta((ItemMeta) repairable);
            return voidmatter_chestplate;
        }
        else if (item.equals(CustomItem.VOIDMATTER_LEGGINGS)) {
            ItemStack voidmatter_leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
            ItemMeta voidmatter_leggings_meta = voidmatter_leggings.getItemMeta();
            voidmatter_leggings_meta.setDisplayName("§5Void Slacks");

            ArrayList<String> voidmatter_leggings_lore = new ArrayList<>();
            voidmatter_leggings_lore.add("§7Set Effect: 2x Mana Regeneration");
            voidmatter_leggings_meta.setLore(voidmatter_leggings_lore);

            voidmatter_leggings_meta.setCustomModelData(161);
            voidmatter_leggings_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_voidmatter_armor"), PersistentDataType.BYTE, (byte) 1);
            voidmatter_leggings_meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            voidmatter_leggings_meta.addEnchant(Enchantment.DURABILITY, 10, true);

            Repairable repairable = (Repairable) voidmatter_leggings_meta;
            repairable.setRepairCost(999999);

            voidmatter_leggings.setItemMeta((ItemMeta) repairable);
            return voidmatter_leggings;
        }
        else if (item.equals(CustomItem.VOIDMATTER_BOOTS)) {
            ItemStack voidmatter_boots = new ItemStack(Material.NETHERITE_BOOTS);
            ItemMeta voidmatter_boots_meta = voidmatter_boots.getItemMeta();
            voidmatter_boots_meta.setDisplayName("§5Void Boots");

            ArrayList<String> voidmatter_boots_lore = new ArrayList<>();
            voidmatter_boots_lore.add("§7Set Effect: 2x Mana Regeneration");
            voidmatter_boots_meta.setLore(voidmatter_boots_lore);

            voidmatter_boots_meta.setCustomModelData(162);
            voidmatter_boots_meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_voidmatter_armor"), PersistentDataType.BYTE, (byte) 1);
            voidmatter_boots_meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            voidmatter_boots_meta.addEnchant(Enchantment.DURABILITY, 10, true);

            Repairable repairable = (Repairable) voidmatter_boots_meta;
            repairable.setRepairCost(999999);

            voidmatter_boots.setItemMeta((ItemMeta) repairable);
            return voidmatter_boots;
        }
        else if (item.equals(CustomItem.VOIDMATTER_BLADE)) {
            ItemStack blade = new ItemStack(Material.NETHERITE_SWORD);
            ItemMeta meta = blade.getItemMeta();

            meta.setDisplayName("§5Void Blade");
            meta.setCustomModelData(168);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_voidmatter_blade"), PersistentDataType.BYTE, (byte) 1);
            meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            meta.addEnchant(Enchantment.DURABILITY, 10, true);

            Repairable repairable = (Repairable) meta;
            repairable.setRepairCost(999999);

            blade.setItemMeta((ItemMeta) repairable);
            return blade;
        }

        else if (item.equals(CustomItem.VOIDMATTER_BOW)) {
            ItemStack bow = new ItemStack(Material.BOW);
            ItemMeta meta = bow.getItemMeta();

            meta.setDisplayName("§5Void Bow");
            meta.setCustomModelData(169);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_voidmatter_bow"), PersistentDataType.BYTE, (byte) 1);
            meta.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            meta.addEnchant(Enchantment.DURABILITY, 10, true);
            meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);

            Repairable repairable = (Repairable) meta;
            repairable.setRepairCost(999999);

            bow.setItemMeta((ItemMeta) repairable);
            return bow;
        }

        else if (item.equals(CustomItem.VOIDMATTER_PICKAXE)) {
            ItemStack pickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
            ItemMeta meta = pickaxe.getItemMeta();

            meta.setDisplayName("§5Void Pickaxe");
            meta.setCustomModelData(170);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_voidmatter_pickaxe"), PersistentDataType.BYTE, (byte) 1);
            meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
            meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
            meta.addEnchant(Enchantment.DURABILITY, 10, true);

            Repairable repairable = (Repairable) meta;
            repairable.setRepairCost(999999);

            pickaxe.setItemMeta((ItemMeta) repairable);
            return pickaxe;
        }

        else if (item.equals(CustomItem.VOIDMATTER_SHOVEL)) {
            ItemStack shovel = new ItemStack(Material.NETHERITE_SHOVEL);
            ItemMeta meta = shovel.getItemMeta();

            meta.setDisplayName("§5Void Shovel");
            meta.setCustomModelData(171);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_voidmatter_shovel"), PersistentDataType.BYTE, (byte) 1);
            meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
            meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
            meta.addEnchant(Enchantment.DURABILITY, 10, true);

            Repairable repairable = (Repairable) meta;
            repairable.setRepairCost(999999);

            shovel.setItemMeta((ItemMeta) repairable);
            return shovel;
        }

        else if (item.equals(CustomItem.VOIDMATTER_AXE)) {
            ItemStack axe = new ItemStack(Material.NETHERITE_AXE);
            ItemMeta meta = axe.getItemMeta();

            meta.setDisplayName("§5Void Axe");
            meta.setCustomModelData(172);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_voidmatter_axe"), PersistentDataType.BYTE, (byte) 1);
            meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
            meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
            meta.addEnchant(Enchantment.DURABILITY, 10, true);

            Repairable repairable = (Repairable) meta;
            repairable.setRepairCost(999999);

            axe.setItemMeta((ItemMeta) repairable);
            return axe;
        }
        else if (item.equals(CustomItem.DIMENSIONAL_ANCHOR)) {
            ItemStack map = new ItemStack(Material.KNOWLEDGE_BOOK);
            ItemMeta meta = map.getItemMeta();
            meta.setDisplayName("§9Dimensional Anchor");
            meta.setCustomModelData(175);

            String uuid = UUID.randomUUID().toString();
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§7" + uuid);
            meta.setLore(lore);

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "world_name"), PersistentDataType.STRING, uuid);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "is_dim_anchor"), PersistentDataType.BYTE, (byte) 1);
            map.setItemMeta(meta);
            return map;
        }


        return null;
    }
}