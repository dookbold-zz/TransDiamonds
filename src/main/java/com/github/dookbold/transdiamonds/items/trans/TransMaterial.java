package com.github.dookbold.transdiamonds.items.trans;

import com.github.dookbold.transdiamonds.registry.TransItemRegistration;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TransMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 2564;
    }

    @Override
    public float getMiningSpeed() {
        return 12;
    }

    @Override
    public float getAttackDamage() {
        return 4;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TransItemRegistration.TRANS_DIAMOND);
    }
}
