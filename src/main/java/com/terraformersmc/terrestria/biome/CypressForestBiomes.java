package com.terraformersmc.terrestria.biome;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import com.terraformersmc.terrestria.init.TerrestriaFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import net.minecraft.world.gen.feature.SeagrassFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class CypressForestBiomes {
	public static void register() {
		TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
				.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
				.precipitation(Biome.Precipitation.RAIN).category(Biome.Category.FOREST)
				.temperature(0.7F)
				.downfall(0.8F)
				.waterColor(4159204)
				.waterFogColor(329011)
				.addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, FOREST_FLOWERS, MINEABLES, ORES, DISKS,
						DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, FOREST_GRASS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER)
				.addStructureFeature(Feature.STRONGHOLD)
				.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
				.addDefaultSpawnEntries()
				.addSpawnEntry(new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4))
		);

		TerrestriaBiomes.CYPRESS_FOREST = TerrestriaBiomes.register("cypress_forest", template.builder()
				.depth(0.1F)
				.scale(0.2F)
				.addTreeFeature(TerrestriaFeatures.CYPRESS_TREE, 9)
				.addTreeFeature(TerrestriaFeatures.TALLER_BIRCH_TREE, 4)
				.build());

		TerrestriaBiomes.WOODED_CYPRESS_HILLS = TerrestriaBiomes.register("wooded_cypress_hills", template.builder()
				.depth(0.45F)
				.scale(0.3F)
				.addTreeFeature(TerrestriaFeatures.CYPRESS_TREE, 9)
				.addTreeFeature(TerrestriaFeatures.TALLER_BIRCH_TREE, 4)
				.build());

		TerrestriaBiomes.CYPRESS_FOREST_EDGE = TerrestriaBiomes.register("cypress_forest_edge", template.builder()
			.depth(0.05F)
			.scale(0.1F)
			.addTreeFeature(TerrestriaFeatures.CYPRESS_TREE, 5)
			.addTreeFeature(TerrestriaFeatures.TALLER_BIRCH_TREE, 2)
			.build());

		TerrestriaBiomes.CYPRESS_FOREST_CLEARING = TerrestriaBiomes.register("cypress_forest_clearing", template.builder()
			.depth(0.1F)
			.scale(0.05F)
			.addTreeFeature(TerrestriaFeatures.CYPRESS_TREE, 2)
			.addTreeFeature(TerrestriaFeatures.TALLER_BIRCH_TREE, 1)
			.build());

		TerrestriaBiomes.CYPRESS_FOREST_LAKE = TerrestriaBiomes.register("cypress_forest_lake", template.builder()
			.depth(-0.225F)
			.scale(0F)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(
				Feature.SEAGRASS, new SeagrassFeatureConfig(120, 0.6D),
				Decorator.TOP_SOLID_HEIGHTMAP, DecoratorConfig.DEFAULT))
			.addTreeFeature(TerrestriaFeatures.CYPRESS_TREE, 5)
			.addTreeFeature(TerrestriaFeatures.TALLER_BIRCH_TREE, 2)
			.build());
	}
}
