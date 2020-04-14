package com.github.dookbold.transdiamonds.items;

import com.github.dookbold.transdiamonds.registry.TransItemRegistration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SwordBase extends SwordItem {
    public SwordBase(ToolMaterial material) {
        super(material, 3, -2.4F, TransItemRegistration.defaultSettings());
    }
}
