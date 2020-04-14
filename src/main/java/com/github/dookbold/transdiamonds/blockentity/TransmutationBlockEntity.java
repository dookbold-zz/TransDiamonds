package com.github.dookbold.transdiamonds.blockentity;

import com.github.dookbold.transdiamonds.registry.TransBlockEntityRegistration;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DefaultedList;

public class TransmutationBlockEntity extends BlockEntity implements ImplementedInventory{
    private final DefaultedList<ItemStack> ITEMS = DefaultedList.ofSize(3, ItemStack.EMPTY);
    public TransmutationBlockEntity() {
        super(TransBlockEntityRegistration.TRANSMUTATION_BLOCK_ENTITY);
    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return ITEMS;
    }
    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        Inventories.fromTag(tag,ITEMS);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        Inventories.toTag(tag,ITEMS);
        return super.toTag(tag);
    }
}

