package valemaximus.enderore.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import valemaximus.enderore.EnderOreMod;
import valemaximus.enderore.blocks.ModBlocks;

import java.util.List;

@Mod.EventBusSubscriber(modid = EnderOreMod.MODID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event){
        generateOres(event);
    }

    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        List<OreConfiguration.TargetBlockState> oreConfigurations = List.of(
                OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ENDER_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ENDER_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHERRACK_ENDER_ORE.get().defaultBlockState()),
                OreConfiguration.target(END_STONE_RULE_TEST, ModBlocks.ENDSTONE_ENDER_ORE.get().defaultBlockState())
        );

        Holder<ConfiguredFeature<OreConfiguration, ?>> ender_ore_holder = FeatureUtils.register("ender_ore",
                Feature.ORE, new OreConfiguration(oreConfigurations, 6));

        var placements = ModOrePlacement.commonOrePlacement(4, // VeinsPerChunk
                HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)));

        Holder<PlacedFeature> ENDER_ORE_PLACED = PlacementUtils.register("ender_ore_placed",
                ender_ore_holder, placements);

        base.add(ENDER_ORE_PLACED);
    }

    public static final RuleTest END_STONE_RULE_TEST = new BlockMatchTest(Blocks.END_STONE);
}

class ModOrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(veinsPerChunk), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int veinsPerChunk, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(veinsPerChunk), p_195351_);
    }
}


