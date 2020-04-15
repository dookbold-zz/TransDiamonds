/*
 * MIT License
 *
 * Copyright (c) 2020 Mazzie S.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.dookbold.transdiamonds.recipes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.PacketByteBuf;
import net.minecraft.util.registry.Registry;

public class TransmutationRecipeSerializer implements RecipeSerializer<TransmutationRecipe> {
    private TransmutationRecipeSerializer() {}
    public static final TransmutationRecipeSerializer INSTANCE = new TransmutationRecipeSerializer();
    public static final Identifier ID = new Identifier("trans_diamonds:transmutation_recipe");
    @Override
    public TransmutationRecipe read(Identifier id, JsonObject json) {
        TransmutationRecipe.TransmutationRecipeJsonFormat recipeJson = new Gson().fromJson(json, TransmutationRecipe.TransmutationRecipeJsonFormat.class);
        if (recipeJson.inputA == null || recipeJson.inputB == null || recipeJson.outputItem == null) {
            throw new JsonSyntaxException("Missing required attribute");
        }
        if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;
        Ingredient inputA = Ingredient.fromJson(recipeJson.inputA);
        Ingredient inputB = Ingredient.fromJson(recipeJson.inputB);
        Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem))
                .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));
        ItemStack outputStack = new ItemStack(outputItem, recipeJson.outputAmount);

        return new TransmutationRecipe(inputA, inputB, outputStack, id);
    }

    @Override
    public TransmutationRecipe read(Identifier id, PacketByteBuf buf) {
        Ingredient inputA = Ingredient.fromPacket(buf);
        Ingredient inputB = Ingredient.fromPacket(buf);
        ItemStack outputItem = buf.readItemStack();
        return new TransmutationRecipe(inputA, inputB, outputItem, id);
    }

    @Override
    public void write(PacketByteBuf buf, TransmutationRecipe recipe) {
        recipe.getInputA().write(buf);
        recipe.getInputB().write(buf);
        buf.writeItemStack(recipe.getOutput());
    }
}
