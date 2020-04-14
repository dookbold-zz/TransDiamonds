package com.github.dookbold.transdiamonds.registry;

import com.github.dookbold.transdiamonds.TransDiamonds;
import com.github.dookbold.transdiamonds.items.AxeBase;
import com.github.dookbold.transdiamonds.items.PickaxeBase;
import com.github.dookbold.transdiamonds.items.ShovelBase;
import com.github.dookbold.transdiamonds.items.SwordBase;
import com.github.dookbold.transdiamonds.items.trans.TransMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TransItemRegistration {
    public static final Item TRANS_DIAMOND = register(new Item(defaultSettings()), "trans_diamond");
    public static final Item TRANS_PICKAXE = register(new PickaxeBase(new TransMaterial()),"trans_pickaxe");
    public static final Item TRANS_AXE = register(new AxeBase(new TransMaterial()), "trans_axe");
    public static final Item TRANS_SWORD = register(new SwordBase(new TransMaterial()), "trans_sword");
    public static final Item TRANS_SHOVEL = register(new ShovelBase(new TransMaterial()), "trans_shovel");

    public static Item register(Item item, String name) {
        return Registry.register(Registry.ITEM, new Identifier(TransDiamonds.MOD_ID, name), item);
    }

    public static Item.Settings defaultSettings() {
        return new Item.Settings().group(TransDiamonds.TRANS_GROUP);
    }

    public static void init() {
        TransDiamonds.LOGGER.info("[TransDiamonds] Registered items!");
    }
}
