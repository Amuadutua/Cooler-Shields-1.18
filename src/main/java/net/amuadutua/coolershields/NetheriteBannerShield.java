package net.amuadutua.coolershields;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class NetheriteBannerShield extends FabricBannerShieldItem {

    public NetheriteBannerShield(FabricItemSettings group, int i, int i1, Item netheriteIngot) {
        super(group, i, i1, netheriteIngot);
    }

    @Override
    public boolean isFireproof() {
        return true;
    }


}
