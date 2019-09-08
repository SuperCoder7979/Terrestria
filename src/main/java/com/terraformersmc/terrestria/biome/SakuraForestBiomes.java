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

public class SakuraForestBiomes {
	public static void register() {
		TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
			.precipitation(Biome.Precipitation.RAIN).category(Biome.Category.FOREST)
			.temperature(0.8F)
			.downfall(1.0F)
			.waterColor(4159204)
			.waterFogColor(329011)
			.addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DEFAULT_MUSHROOMS,
					DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER)
			.addStructureFeature(Feature.STRONGHOLD)
			.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
			.addDefaultSpawnEntries()
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4))
		);

		TerrestriaBiomes.SAKURA_FOREST = TerrestriaBiomes.register("sakura_forest", template.builder()
			.depth(0.15F)
			.scale(0.1F)
			.addTreeFeature(TerrestriaFeatures.SAKURA_TREE, 6)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_SHRUB, 4)
			.build());

		TerrestriaBiomes.WOODED_SAKURA_HILLS = TerrestriaBiomes.register("wooded_sakura_hills", template.builder()
			.depth(0.4F)
			.scale(0.3F)
			.addTreeFeature(TerrestriaFeatures.SAKURA_TREE, 6)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_SHRUB, 4)
			.build());

		TerrestriaBiomes.SAKURA_EDGE = TerrestriaBiomes.register("sakura_edge", template.builder()
			.depth(0.15F)
			.scale(0.1F)
			.addTreeFeature(TerrestriaFeatures.SAKURA_TREE, 2)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_SHRUB, 2)
			.build());

		TerrestriaBiomes.SAKURA_LAKE = TerrestriaBiomes.register("sakura_lake", template.builder()
			.depth(-0.2F)
			.scale(0F)
			.addTreeFeature(TerrestriaFeatures.SAKURA_TREE, 4)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_SHRUB, 3)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(
				Feature.SEAGRASS, new SeagrassFeatureConfig(120, 0.6D),
				Decorator.TOP_SOLID_HEIGHTMAP, DecoratorConfig.DEFAULT))
			.build());

		TerrestriaBiomes.SAKURA_CLEARING = TerrestriaBiomes.register("sakura_clearing", template.builder()
			.depth(0.1F)
			.scale(0.1F)
			.addTreeFeature(TerrestriaFeatures.SAKURA_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_SHRUB, 2)
			.build());
	}
}
