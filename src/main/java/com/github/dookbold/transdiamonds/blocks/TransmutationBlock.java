package com.github.dookbold.transdiamonds.blocks;

import com.github.dookbold.transdiamonds.blockentity.TransmutationBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class TransmutationBlock extends Block implements BlockEntityProvider {
     public TransmutationBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        return new TransmutationBlockEntity();
    }
}
