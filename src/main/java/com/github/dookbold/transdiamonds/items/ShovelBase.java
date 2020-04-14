package com.github.dookbold.transdiamonds.items;

import com.github.dookbold.transdiamonds.registry.TransItemRegistration;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class ShovelBase extends ShovelItem {
    public ShovelBase(ToolMaterial material) {
        super(material, 1.5F, -3.0F, TransItemRegistration.defaultSettings());
    }
}
