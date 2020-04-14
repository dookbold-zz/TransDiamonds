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
import com.github.dookbold.transdiamonds.blockentity.TransmutationBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

public class TransBlockEntityRegistration {
    private static final List<BlockEntityType<?>> TYPES = new ArrayList<>();
    public static BlockEntityType<TransmutationBlockEntity> TRANSMUTATION_BLOCK_ENTITY =
            register(TransmutationBlockEntity.class, "transmutation_block", TransBlockRegistration.TRANSMUTATION_BLOCK);


    public static <T extends BlockEntity> BlockEntityType<T> register(Class<T> tClass, String name, Block... blocks) {
        Validate.isTrue(blocks.length > 0, "no blocks for blockEntity entity type!");
        return register(new Identifier(TransDiamonds.MOD_ID, name).toString(), BlockEntityType.Builder.create(() -> createBlockEntity(tClass), blocks));
    }

    private static <T extends BlockEntity> T createBlockEntity(Class<T> tClass){
        try {
            return tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to createBlockEntity blockEntity", e);
        }
    }
    public static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType.Builder<T> builder) {
        BlockEntityType<T> blockEntityType = builder.build(null);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(id), blockEntityType);
        TransBlockEntityRegistration.TYPES.add(blockEntityType);
        return blockEntityType;
    }
}
