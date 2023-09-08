package net.nallraen.starshine.registers;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nallraen.starshine.StarshineMod;
import net.nallraen.starshine.utils.StarshineTab;

public class Items {

    public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, StarshineMod.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(StarshineTab.STARSHINE_BASE_TAB)));
    public static final RegistryObject<Item> EPIDOTE = ITEMS.register("epidote",
            () -> new Item(new Item.Properties().tab(StarshineTab.STARSHINE_BASE_TAB)));

    public static void register(IEventBus e) {
        ITEMS.register(e);
    }
}
