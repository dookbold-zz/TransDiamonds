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

package com.github.dookbold.transdiamonds.gui;

import io.github.cottonmc.cotton.gui.CottonCraftingController;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import net.minecraft.container.BlockContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;

public class TransmutationBlockController extends CottonCraftingController {
    public TransmutationBlockController(int syncId, PlayerInventory inventory, BlockContext context) {
        super(RecipeType.SMELTING, syncId, inventory, getBlockInventory(context), getBlockPropertyDelegate(context));

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(200,200);
        WItemSlot itemSlotA = WItemSlot.of(blockInventory, 0);
        WItemSlot itemSlotB = WItemSlot.of(blockInventory, 1);
        WItemSlot itemSlotC = WItemSlot.of(blockInventory, 2);
        WItemSlot itemSlotD = WItemSlot.of(blockInventory, 3);
        root.add(itemSlotA, 5, 1);
        root.add(itemSlotB, 3, 4);
        root.add(itemSlotC, 7, 4);
        root.add(itemSlotD, 5, 3);
        root.add(this.createPlayerInventoryPanel(), 1, 6);
        root.validate(this);

    }

}
