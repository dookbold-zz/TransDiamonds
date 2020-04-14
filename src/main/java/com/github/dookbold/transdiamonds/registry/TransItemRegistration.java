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
import com.github.dookbold.transdiamonds.items.AxeBase;
import com.github.dookbold.transdiamonds.items.PickaxeBase;
import com.github.dookbold.transdiamonds.items.ShovelBase;
import com.github.dookbold.transdiamonds.items.SwordBase;
import com.github.dookbold.transdiamonds.items.trans.TransMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TransItemRegistration {
    public static final Item TRANS_DIAMOND = register(new Item(defaultSettings()), "trans_diamond");
    public static final Item TRANS_PICKAXE = register(new PickaxeBase(new TransMaterial()),"trans_pickaxe");
    public static final Item TRANS_AXE = register(new AxeBase(new TransMaterial()), "trans_axe");
    public static final Item TRANS_SWORD = register(new SwordBase(new TransMaterial()), "trans_sword");
    public static final Item TRANS_SHOVEL = register(new ShovelBase(new TransMaterial()), "trans_shovel");

    public static Item register(Item item, String name) {
        return Registry.register(Registry.ITEM, new Identifier(TransDiamonds.MOD_ID, name), item);
    }

    public static Item.Settings defaultSettings() {
        return new Item.Settings().group(TransDiamonds.TRANS_GROUP);
    }

    public static void init() {
        TransDiamonds.LOGGER.info("[TransDiamonds] Registered items!");
    }
}
