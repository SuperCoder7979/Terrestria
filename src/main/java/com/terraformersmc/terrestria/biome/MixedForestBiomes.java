package com.terraformersmc.terrestria.biome;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import com.terraformersmc.terrestria.init.TerrestriaFeatures;
import com.terraformersmc.terrestria.init.TerrestriaSurfaces;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.decorator.LakeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class MixedForestBiomes {
	public static void register() {
		TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
			.precipitation(Biome.Precipitation.RAIN).category(Biome.Category.FOREST)
			.depth(0.15F)
			.scale(0.05F)
			.temperature(0.8F)
			.downfall(0.4F)
			.waterColor(0x5c5214)
			.waterFogColor(0x50533)
			.grassColor(0xd1c35c)
			.foliageColor(0xBFA243)
			.addGrassFeature(Blocks.BROWN_MUSHROOM.getDefaultState(), 1)
			.addDefaultFeatures(LAND_CARVERS, STRUCTURES, DUNGEONS, LAKES, PLAINS_TALL_GRASS, MINEABLES, ORES, DISKS,
				PLAINS_FEATURES, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER, LARGE_FERNS)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(
				TerrestriaFeatures.CATTAIL, new SeagrassFeatureConfig(80, 0.4D),
				Decorator.TOP_SOLID_HEIGHTMAP, DecoratorConfig.DEFAULT))
			.addStructureFeature(Feature.STRONGHOLD)
			.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
			.addDefaultSpawnEntries()
		);

		TerrestriaBiomes.MIXED_FOREST = TerrestriaBiomes.register("mixed_forest", template.builder()
			.configureSurfaceBuilder(TerrestriaSurfaces.MIXED_FOREST, SurfaceBuilder.GRASS_CONFIG)
			.addTreeFeature(Feature.FANCY_TREE, 1)
			.addTreeFeature(Feature.BIRCH_TREE, 3)
			.addTreeFeature(Feature.NORMAL_TREE, 4)
			.addTreeFeature(Feature.PINE_TREE, 3)
			.addTreeFeature(TerrestriaFeatures.HEMLOCK_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.FALLEN_OAK_LOG, 2)
			.addTreeFeature(TerrestriaFeatures.FALLEN_SPRUCE_LOG, 1)
			.build()
		);

		TerrestriaBiomes.MIXED_FOREST_CLEARING = TerrestriaBiomes.register("mixed_forest_clearing", template.builder()
			.configureSurfaceBuilder(TerrestriaSurfaces.MIXED_FOREST, SurfaceBuilder.GRASS_CONFIG)
			.scale(0.02F)
			.addTreeFeature(Feature.NORMAL_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.TINY_HEMLOCK_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.FALLEN_OAK_LOG, 1)
			.build()
		);

		TerrestriaBiomes.MIXED_FOREST_LAKE = TerrestriaBiomes.register("mixed_forest_lake", template.builder()
			.configureSurfaceBuilder(TerrestriaSurfaces.MIXED_FOREST, SurfaceBuilder.GRASS_SAND_UNDERWATER_CONFIG)
			.depth(-0.35F)
			.scale(0.0F)
			.build()
		);

		TerrestriaBiomes.MIXED_FOREST_HILLS = TerrestriaBiomes.register("mixed_forest_hills", template.builder()
			.configureSurfaceBuilder(TerrestriaSurfaces.MIXED_FOREST.setMaxPodzolAmount(2), SurfaceBuilder.GRASS_CONFIG)
			.depth(0.4F)
			.scale(0.3F)
			.addTreeFeature(Feature.FANCY_TREE, 1)
			.addTreeFeature(Feature.BIRCH_TREE, 2)
			.addTreeFeature(Feature.NORMAL_TREE, 4)
			.addTreeFeature(Feature.PINE_TREE, 4)
			.addTreeFeature(TerrestriaFeatures.HEMLOCK_TREE, 2)
			.addTreeFeature(TerrestriaFeatures.FALLEN_OAK_LOG, 3)
			.build()
		);

		TerrestriaBiomes.MIXED_FOREST_EDGE = TerrestriaBiomes.register("mixed_forest_edge", template.builder()
			.configureSurfaceBuilder(TerrestriaSurfaces.MIXED_FOREST.setMaxPodzolAmount(2.5), SurfaceBuilder.GRASS_CONFIG)
			.scale(0.02F)
			.addTreeFeature(Feature.NORMAL_TREE, 2)
			.addTreeFeature(TerrestriaFeatures.TINY_HEMLOCK_TREE, 2)
			.addTreeFeature(Feature.PINE_TREE, 1)
			.build()
		);

		TerrestriaBiomes.MIXED_FOREST_BEACH = TerrestriaBiomes.register("mixed_forest_beach", template.builder()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.SAND_CONFIG)
			.precipitation(Biome.Precipitation.RAIN).category(Biome.Category.BEACH)
			.depth(0F)
			.scale(0.025F)
			.build());
	}
}
