package net.nallraen.starshine.event;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.nallraen.starshine.StarshineMod;
import net.nallraen.starshine.player.capabilities.thrist.PlayerThirst;
import net.nallraen.starshine.player.capabilities.thrist.PlayerThirstProvider;


@Mod.EventBusSubscriber(modid = StarshineMod.MOD_ID)
public class PlayerEvents {

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> e) {
        if(e.getObject() instanceof Player){
            if(!e.getObject().getCapability(PlayerThirstProvider.PLAYER_THIRST).isPresent()) {
                e.addCapability(new ResourceLocation(StarshineMod.MOD_ID, "properties"), new PlayerThirstProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone e) {
        if(e.isWasDeath()) {
            e.getOriginal().getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(oldStore -> {
                e.getOriginal().getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent e) {
        e.register(PlayerThirst.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if(e.side == LogicalSide.SERVER) {
            e.player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                if(thirst.getThirst() > 0 && e.player.getRandom().nextFloat() < 0.002f) {
                    thirst.subThirst(0.5f);
                    e.player.sendSystemMessage(Component.literal("Lost 1 water point"));
                }
            });
        }
    }
}
