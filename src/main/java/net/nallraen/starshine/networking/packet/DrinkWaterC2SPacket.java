package net.nallraen.starshine.networking.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkEvent;
import net.nallraen.starshine.player.capabilities.thrist.PlayerThirstProvider;

import java.util.function.Supplier;

public class DrinkWaterC2SPacket {

    private static final String MESSAGE_DRINK = "message.starshine.drink_water";
    private static final String MESSAGE_NO_WATER = "message.starshine.no_water";
    public DrinkWaterC2SPacket() {

    }

    public DrinkWaterC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // ServerSide
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();
            // Check if close to water
            // TODO: Add a water bottle check
            if(hasWaterAround(player, level, 2)) {
                player.sendSystemMessage(Component.translatable(MESSAGE_DRINK).withStyle(ChatFormatting.DARK_AQUA));
                level.playSound(null, player.getOnPos(), SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS,
                        0.5f, level.random.nextFloat() * 0.1f + 0.9f);
                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                    thirst.addThrist(thirst.getMaxThirst());
                    player.sendSystemMessage(Component.translatable("Current thirst level: "+ thirst.getThirst()).withStyle(ChatFormatting.DARK_AQUA));
                });


            } else {
                player.sendSystemMessage(Component.translatable(MESSAGE_NO_WATER).withStyle(ChatFormatting.DARK_RED));
                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                    player.sendSystemMessage(Component.translatable("Current thirst level: "+ thirst.getThirst()).withStyle(ChatFormatting.RED));
                });

            }
        });
        return true;
    }

    private boolean hasWaterAround(ServerPlayer player, ServerLevel level, int size) {
        return level.getBlockStates(player.getBoundingBox().inflate(size))
                .filter(state -> state.is(Blocks.WATER)).toArray().length > 0;
    }
}
