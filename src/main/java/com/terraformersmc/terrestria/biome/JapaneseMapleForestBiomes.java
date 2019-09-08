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

public class JapaneseMapleForestBiomes {
	public static void register() {
		TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
			.precipitation(Biome.Precipitation.RAIN).category(Biome.Category.FOREST)
			.temperature(0.8F)
			.downfall(0.5F)
			.waterColor(4159204)
			.waterFogColor(329011)
			.addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DEFAULT_MUSHROOMS,
					DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER, FOREST_GRASS)
			.addStructureFeature(Feature.STRONGHOLD)
			.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
			.addDefaultSpawnEntries()
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4))
		);

		TerrestriaBiomes.JAPANESE_MAPLE_FOREST = TerrestriaBiomes.register("japanese_maple_forest", template.builder()
			.depth(0.15F)
			.scale(0.2F)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_TREE, 3)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_SHRUB, 3)
			.addTreeFeature(TerrestriaFeatures.DARK_JAPANESE_MAPLE_TREE, 3)
			.build());

		TerrestriaBiomes.WOODED_JAPANESE_MAPLE_HILLS = TerrestriaBiomes.register("wooded_japanese_maple_hills", template.builder()
			.depth(0.45F)
			.scale(0.5F)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_TREE, 3)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_SHRUB, 3)
			.addTreeFeature(TerrestriaFeatures.DARK_JAPANESE_MAPLE_TREE, 3)
			.build());

		TerrestriaBiomes.JAPANESE_MAPLE_EDGE = TerrestriaBiomes.register("japanese_maple_edge", template.builder()
			.depth(0.15F)
			.scale(0.2F)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_SHRUB, 1)
			.addTreeFeature(TerrestriaFeatures.DARK_JAPANESE_MAPLE_TREE, 1)
			.build());

		TerrestriaBiomes.JAPANESE_MAPLE_CLEARING = TerrestriaBiomes.register("japanese_maple_clearing", template.builder()
			.depth(0.15F)
			.scale(0.2F)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_SHRUB, 3)
			.addTreeFeature(TerrestriaFeatures.DARK_JAPANESE_MAPLE_TREE, 1)
			.build());

		TerrestriaBiomes.JAPANESE_MAPLE_LAKE = TerrestriaBiomes.register("japanese_maple_lake", template.builder()
			.depth(-0.2F)
			.scale(0F)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_SHRUB, 3)
			.addTreeFeature(TerrestriaFeatures.DARK_JAPANESE_MAPLE_TREE, 1)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(
				Feature.SEAGRASS, new SeagrassFeatureConfig(120, 0.6D),
				Decorator.TOP_SOLID_HEIGHTMAP, DecoratorConfig.DEFAULT))
			.build());

		TerrestriaBiomes.JAPANESE_MAPLE_LIGHT = TerrestriaBiomes.register("japanese_maple_light", template.builder()
			.depth(0.15F)
			.scale(0.2F)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_TREE, 5)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_SHRUB, 3)
			.build());

		TerrestriaBiomes.JAPANESE_MAPLE_DARK = TerrestriaBiomes.register("japanese_maple_dark", template.builder()
			.depth(0.15F)
			.scale(0.2F)
			.addTreeFeature(TerrestriaFeatures.JAPANESE_MAPLE_SHRUB, 3)
			.addTreeFeature(TerrestriaFeatures.DARK_JAPANESE_MAPLE_TREE, 5)
			.build());
	}
}
