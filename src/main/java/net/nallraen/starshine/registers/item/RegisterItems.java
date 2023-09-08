package net.nallraen.starshine.registers.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nallraen.starshine.StarshineMod;
import net.nallraen.starshine.registers.item.customs.EightBallItem;
import net.nallraen.starshine.utils.StarshineTab;

public class RegisterItems {

    public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, StarshineMod.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(StarshineTab.STARSHINE_BASE_TAB)));
    public static final RegistryObject<Item> EPIDOTE = ITEMS.register("epidote",
            () -> new Item(new Item.Properties().tab(StarshineTab.STARSHINE_BASE_TAB)));
    public static final RegistryObject<Item> MAGENTITE = ITEMS.register("magentite",
            () -> new Item(new Item.Properties().tab(StarshineTab.STARSHINE_BASE_TAB)));


    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties().tab(StarshineTab.STARSHINE_BASE_TAB)
                    .stacksTo(1)));

    public static void register(IEventBus e) {
        ITEMS.register(e);
    }
}
