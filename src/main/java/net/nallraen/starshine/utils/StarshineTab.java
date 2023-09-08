package net.nallraen.starshine.utils;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.nallraen.starshine.registers.Items;

public class StarshineTab {

    public static final CreativeModeTab STARSHINE_BASE_TAB = new CreativeModeTab("base_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.RUBY.get());
        }
    };
    public static final CreativeModeTab STARSHINE_TOOLS_TAB = new CreativeModeTab("tools_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.EPIDOTE.get());
        }
    };

}
