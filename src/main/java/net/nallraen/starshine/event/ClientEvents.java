package net.nallraen.starshine.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nallraen.starshine.StarshineMod;
import net.nallraen.starshine.networking.NetMessages;
import net.nallraen.starshine.networking.packet.DefaultC2SPacket;
import net.nallraen.starshine.networking.packet.DrinkWaterC2SPacket;
import net.nallraen.starshine.utils.KeyBinding;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = StarshineMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key e) {
            if(KeyBinding.DRINKING_KEY.consumeClick()) {
                NetMessages.sendToServer(new DrinkWaterC2SPacket());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = StarshineMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent e) {
            e.register(KeyBinding.DRINKING_KEY);
        }
    }
}
