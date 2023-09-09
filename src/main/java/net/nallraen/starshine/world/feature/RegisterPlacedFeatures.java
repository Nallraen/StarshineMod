package net.nallraen.starshine.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nallraen.starshine.StarshineMod;

import java.util.List;

public class RegisterPlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, StarshineMod.MOD_ID);

    public static final RegistryObject<PlacedFeature> RUBY_ORE_PLACED = PLACED_FEATURE.register("ruby_ore_placed",
            () ->  new PlacedFeature(RegisterConfiguredFeatures.RUBY_ORE.getHolder().get(),
                    commonOrePlacement(7,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80),
                                    VerticalAnchor.aboveBottom(80)))));

        public static final RegistryObject<PlacedFeature> MAGENTITE_ORE_PLACED = PLACED_FEATURE.register("magentite_ore_placed",
            () ->  new PlacedFeature(RegisterConfiguredFeatures.MAGENTITE_ORE.getHolder().get(),
                    commonOrePlacement(7,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80),
                                    VerticalAnchor.aboveBottom(80)))));








    public static List<PlacementModifier> orePlacement(PlacementModifier p_1, PlacementModifier p_2) {
        return List.of(p_1, InSquarePlacement.spread(),p_2, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_19, PlacementModifier p_20) {
        return orePlacement(CountPlacement.of(p_19), p_20);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_21, PlacementModifier p_22) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_21), p_22);
    }


    public static void register(IEventBus e) {
        PLACED_FEATURE.register(e);
    }
}
