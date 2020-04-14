package com.github.dookbold.transdiamonds;

import com.github.dookbold.transdiamonds.registry.TransBlockRegistration;
import com.github.dookbold.transdiamonds.registry.TransItemRegistration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransDiamonds implements ModInitializer {
    public static final String MOD_ID = "trans_diamonds";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup TRANS_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "general"))
            .icon(() -> new ItemStack(TransItemRegistration.TRANS_DIAMOND))
            .build();
    @Override
    public void onInitialize() {
        TransItemRegistration.init();
        TransBlockRegistration.init();

    }
}
