package com.github.dookbold.transdiamonds.items;

import com.github.dookbold.transdiamonds.registry.TransItemRegistration;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class AxeBase extends AxeItem {
    public AxeBase(ToolMaterial material) {
        super(material, 5, -3, TransItemRegistration.defaultSettings());
    }
}
