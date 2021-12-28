package net.amuadutua.coolershields.mixin;

import net.amuadutua.coolershields.CoolerShields;
import net.amuadutua.coolershields.CoolerShieldsClient;

import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltinModelItemRenderer.class)
public class RendererMixin {

	private ShieldEntityModel modelTestShield;
	private static final SpriteIdentifier NETHERITE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(CoolerShields.MOD_ID,"entity/netherite_shield_base"));
	private static final SpriteIdentifier NETHERITE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(CoolerShields.MOD_ID,"entity/netherite_shield_base_nopattern"));
	private static final SpriteIdentifier DIAMOND_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(CoolerShields.MOD_ID,"entity/diamond_shield_base"));
	private static final SpriteIdentifier DIAMOND_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(CoolerShields.MOD_ID,"entity/diamond_shield_base_nopattern"));
	private static final SpriteIdentifier GOLDEN_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(CoolerShields.MOD_ID,"entity/golden_shield_base"));
	private static final SpriteIdentifier GOLDEN_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(CoolerShields.MOD_ID,"entity/golden_shield_base_nopattern"));
	private static final SpriteIdentifier IRON_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(CoolerShields.MOD_ID,"entity/iron_shield_base"));
	private static final SpriteIdentifier IRON_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(CoolerShields.MOD_ID,"entity/iron_shield_base_nopattern"));
	private static final SpriteIdentifier WOODEN_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(CoolerShields.MOD_ID,"entity/wooden_shield_base"));
	private static final SpriteIdentifier WOODEN_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(CoolerShields.MOD_ID,"entity/wooden_shield_base_nopattern"));

	@Final
	@Shadow
	private EntityModelLoader entityModelLoader;


	@Inject(method = "reload", at = @At("HEAD"))
	private void setModelTestShield(CallbackInfo ci){
		this.modelTestShield = new ShieldEntityModel(this.entityModelLoader.getModelPart(CoolerShieldsClient.DIAMOND_SHIELD_MODEL_LAYER));
	}

	@Inject(method = "render", at = @At("HEAD"))
	private void mainRender(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {
		if (stack.isOf(CoolerShields.NETHERITE_BANNER_SHIELD)) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, modelTestShield, NETHERITE_SHIELD_BASE, NETHERITE_SHIELD_BASE_NO_PATTERN);
		}
		if (stack.isOf(CoolerShields.DIAMOND_BANNER_SHIELD)) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, modelTestShield, DIAMOND_SHIELD_BASE, DIAMOND_SHIELD_BASE_NO_PATTERN);
		}
		if (stack.isOf(CoolerShields.GOLDEN_BANNER_SHIELD)) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, modelTestShield, GOLDEN_SHIELD_BASE, GOLDEN_SHIELD_BASE_NO_PATTERN);
		}
		if (stack.isOf(CoolerShields.IRON_BANNER_SHIELD)) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, modelTestShield, IRON_SHIELD_BASE, IRON_SHIELD_BASE_NO_PATTERN);
		}
		if (stack.isOf(CoolerShields.WOODEN_BANNER_SHIELD)) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, modelTestShield, WOODEN_SHIELD_BASE, WOODEN_SHIELD_BASE_NO_PATTERN);
		}
	}
}