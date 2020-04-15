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

package com.github.dookbold.transdiamonds.registry;

import com.github.dookbold.transdiamonds.TransDiamonds;
import com.github.dookbold.transdiamonds.blocks.TransmutationBlock;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TransBlockRegistration {
    public static final Block TRANS_DIAMOND_BLOCK = register(new Block(FabricBlockSettings.of(Material.METAL)
            .strength(5.0F, 6.0F).sounds(BlockSoundGroup.GLASS)
            .breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3)
            .lightLevel(6).build()), "trans_diamond_block");
    public static final Block TRANSMUTATION_BLOCK = register(new TransmutationBlock(FabricBlockSettings.of(Material.METAL)
            .strength(3.0F, 3.0F).sounds(BlockSoundGroup.METAL)
            .breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2)
            .lightLevel(6).build()), "transmutation_block");

    private static Block register(Block block, String name) {
        Registry.register(Registry.BLOCK, new Identifier(TransDiamonds.MOD_ID, name), block);
        BlockItem item = new BlockItem(block, TransItemRegistration.defaultSettings());
        TransItemRegistration.register(item, name);
        return block;
    }

    public static void init () {
        TransDiamonds.LOGGER.info("[TransDiamonds] Registered blocks!");
    }

}
