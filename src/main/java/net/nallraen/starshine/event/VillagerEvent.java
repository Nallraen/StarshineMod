package net.nallraen.starshine.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nallraen.starshine.StarshineMod;
import net.nallraen.starshine.registers.entity.villager.RegisterVillager;
import net.nallraen.starshine.registers.item.RegisterItems;

import java.util.List;

@Mod.EventBusSubscriber(modid = StarshineMod.MOD_ID)
public class VillagerEvent {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent e) {
        if(e.getType() == RegisterVillager.GLOW_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = e.getTrades();
            ItemStack s = new ItemStack(RegisterItems.EIGHT_BALL.get(), 2);
            ItemStack s2 = new ItemStack(RegisterItems.EPIDOTE.get(), 10);
            int villagerLevel = 1;

            /*
            @Method MechantOffer
            @Params : - ItemStack > Buying item
                      - ItemStack > Selling item
                      - int > Max Use
                      - int > XP
                      - Float > price multiplier
             */

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.STICK, 5),
                    s, 10, 8, 0.02F)
            );

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.STONE, 32),
                    s2, 10, 8, 0.02F)
            );

        }
    }
}
