package net.nallraen.starshine.player.capabilities.thrist;

import net.minecraft.nbt.CompoundTag;

public class PlayerThirst {
    private float thirst;
    private final float MAX_THIRST = 10.0f;
    private final float MIN_THIRST = 0.0f;

    public float getThirst() {
        return thirst;
    }

    public float getMaxThirst() { return MAX_THIRST; }

    public void addThrist(float add) {
        this.thirst = Math.min(thirst + add, MAX_THIRST);
    }
    public void subThirst(float sub) {
        this.thirst = Math.max(thirst - sub, MIN_THIRST);
    }

    public void copyFrom(PlayerThirst source) {
        this.thirst = source.thirst;
    }

    public void savedNBTData(CompoundTag nbt){
        nbt.putFloat("thirst",thirst);
    }
    public void loadNBTData(CompoundTag nbt){
        thirst = nbt.getFloat("thirst");
    }

}
