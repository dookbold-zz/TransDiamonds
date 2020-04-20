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

package com.github.dookbold.transdiamonds;

import com.github.dookbold.transdiamonds.blocks.TransmutationBlock;
import com.github.dookbold.transdiamonds.gui.TransmutationBlockController;
import com.github.dookbold.transdiamonds.recipes.TransmutationRecipe;
import com.github.dookbold.transdiamonds.recipes.TransmutationRecipeSerializer;
import com.github.dookbold.transdiamonds.registry.TransBlockRegistration;
import com.github.dookbold.transdiamonds.registry.TransItemRegistration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.container.BlockContext;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
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
        Registry.register(Registry.RECIPE_SERIALIZER, TransmutationRecipeSerializer.ID,
                TransmutationRecipeSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, TransmutationRecipe.Type.ID), TransmutationRecipe.Type.INSTANCE);
        ContainerProviderRegistry.INSTANCE.registerFactory(TransmutationBlock.IDENTIFIER, (syncId, id, player, buf) -> new TransmutationBlockController(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos())));
    }
}
