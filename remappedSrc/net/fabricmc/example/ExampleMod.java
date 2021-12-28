package net.fabricmc.coolershields;

import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLib;
import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldBlockCallback;
import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldDisabledCallback;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldEnchantment;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExampleMod implements ModInitializer {

	public static final String MOD_ID = "examplemod";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public static final Item EXAMPLE_SHIELD = new FabricShieldItem(new FabricItemSettings().maxDamage(2500).group(ItemGroup.COMBAT), 100, 9, Items.OAK_PLANKS); // FabricShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)

	public static final Item DIAMOND_BANNER_SHIELD = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2500).group(ItemGroup.COMBAT), 100, 9,Items.DIAMOND); // FabricBannerShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)

	public static final Item WOODEN_BANNER_SHIELD = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(300).group(ItemGroup.COMBAT), 100, 9, Items.OAK_PLANKS);

	public static final FabricShieldEnchantment EXAMPLE_ENCHANTMENT = new FabricShieldEnchantment(Rarity.VERY_RARE);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "example_shield"), EXAMPLE_SHIELD);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "example_banner_shield"), DIAMOND_BANNER_SHIELD);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "wooden_banner_shield"), WOODEN_BANNER_SHIELD);


		LOGGER.info(MOD_ID + " initialized.");
	}
}
