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
            .strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)
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
