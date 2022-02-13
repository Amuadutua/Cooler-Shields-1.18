package net.amuadutua.coolershields;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CoolerShields implements ModInitializer {

	public static final String MOD_ID = "coolershields";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public static final Item EXAMPLE_SHIELD = new FabricShieldItem(new FabricItemSettings().maxDamage(99999).group(ItemGroup.COMBAT), 0, 100, Items.OAK_PLANKS); // FabricShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)

	public static final Item NETHERITE_BANNER_SHIELD = new NetheriteBannerShield(new FabricItemSettings().maxDamage(900).group(ItemGroup.COMBAT), 25, 15,Items.NETHERITE_INGOT); // FabricBannerShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)

	public static final Item DIAMOND_BANNER_SHIELD = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(800).group(ItemGroup.COMBAT), 50, 10,Items.DIAMOND); // FabricBannerShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)

	public static final Item GOLDEN_BANNER_SHIELD = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(112).group(ItemGroup.COMBAT), 50, 10,Items.GOLD_INGOT); // FabricBannerShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)

	public static final Item IRON_BANNER_SHIELD = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(500).group(ItemGroup.COMBAT), 100, 6,Items.IRON_INGOT); // FabricBannerShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)

	public static final Item WOODEN_BANNER_SHIELD = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(80).group(ItemGroup.COMBAT), 300, 2, Items.OAK_PLANKS);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "diamond_shield"), EXAMPLE_SHIELD);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "netherite_banner_shield"), NETHERITE_BANNER_SHIELD);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "diamond_banner_shield"), DIAMOND_BANNER_SHIELD);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "golden_banner_shield"), GOLDEN_BANNER_SHIELD);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "iron_banner_shield"), IRON_BANNER_SHIELD);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "wooden_banner_shield"), WOODEN_BANNER_SHIELD);


		LOGGER.info(MOD_ID + " initialized.");
	}
}
