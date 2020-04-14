package com.github.dookbold.transdiamonds.items;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialBase implements ToolMaterial {
    public Ingredient ingredient;
    public MaterialBase(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    @Override
    public int getDurability() {
        return 2564;
    }

    @Override
    public float getMiningSpeed() {
        return 12.0F;
    }

    @Override
    public float getAttackDamage() {
        return 4.0F;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return ingredient;
    }


}
