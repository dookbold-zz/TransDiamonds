package com.github.dookbold.transdiamonds.items;

import com.github.dookbold.transdiamonds.registry.TransItemRegistration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class PickaxeBase extends PickaxeItem {
    public PickaxeBase(ToolMaterial material) {
        super(material, 1, -2.8F, TransItemRegistration.defaultSettings());
    }

}
