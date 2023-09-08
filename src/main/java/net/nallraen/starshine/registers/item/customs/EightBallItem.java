package net.nallraen.starshine.registers.item.customs;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EightBallItem extends Item {
    public EightBallItem(Properties prop) {
        super(prop);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player p_Player, InteractionHand p_Hand) {
        if(!level.isClientSide() && p_Hand == InteractionHand.MAIN_HAND) {
            // Something to output there when we right click
            // As example we generate random int and put a 1 sec cooldown
            ouput(p_Player);
            p_Player.getCooldowns().addCooldown(this, 20);
        }
        return super.use(level, p_Player, p_Hand);
    }

    private void ouput(Player p_Player) {
        p_Player.sendSystemMessage(Component.literal("Nombre de fou malade >> " + getRandomNumber()));
    }

    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}
