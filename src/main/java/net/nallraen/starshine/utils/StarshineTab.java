package net.nallraen.starshine.utils;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.nallraen.starshine.registers.item.RegisterItems;

public class StarshineTab {

    public static final CreativeModeTab STARSHINE_BASE_TAB = new CreativeModeTab("base_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RegisterItems.RUBY.get());
        }
    };
    public static final CreativeModeTab STARSHINE_TOOLS_TAB = new CreativeModeTab("tools_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RegisterItems.EPIDOTE.get());
        }
    };
    public static final CreativeModeTab STARSHINE_BLOCKS_TAB = new CreativeModeTab("blocks_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.ACACIA_DOOR);
        }
    };

}
