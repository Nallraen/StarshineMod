package net.nallraen.starshine;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nallraen.starshine.networking.NetMessages;
import net.nallraen.starshine.registers.block.RegisterBlocks;
import net.nallraen.starshine.registers.entity.villager.RegisterVillager;
import net.nallraen.starshine.registers.item.RegisterItems;
import net.nallraen.starshine.world.feature.RegisterConfiguredFeatures;
import net.nallraen.starshine.world.feature.RegisterPlacedFeatures;
import org.slf4j.Logger;

@Mod(StarshineMod.MOD_ID)
public class StarshineMod
{
    public static final String MOD_ID = "starshine";
    private static final Logger LOGGER = LogUtils.getLogger();
    public StarshineMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RegisterItems.register(modEventBus);
        RegisterBlocks.register(modEventBus);

        RegisterVillager.register(modEventBus);

        RegisterConfiguredFeatures.register(modEventBus);
        RegisterPlacedFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            NetMessages.register();
            // Add under this comment
            RegisterVillager.registerPOIs();
        });
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
