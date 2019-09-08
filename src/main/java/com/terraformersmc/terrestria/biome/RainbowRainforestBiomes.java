package com.terraformersmc.terrestria.biome;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import com.terraformersmc.terrestria.init.TerrestriaFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class RainbowRainforestBiomes {
	public static void register() {
		TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
			.precipitation(Biome.Precipitation.RAIN).category(Biome.Category.JUNGLE)
			.temperature(0.95F)
			.downfall(0.9F)
			.waterColor(4159204)
			.waterFogColor(329011)
			.addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, DISKS, DEFAULT_FLOWERS,
					JUNGLE_GRASS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, JUNGLE_VEGETATION, FROZEN_TOP_LAYER)
			.addStructureFeature(Feature.STRONGHOLD)
			.addStructureFeature(Feature.JUNGLE_TEMPLE)
			.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
			.addDefaultSpawnEntries()
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.PARROT, 40, 1, 2))
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.OCELOT, 2, 1, 1))
		);

		TerrestriaBiomes.RAINBOW_RAINFOREST = TerrestriaBiomes.register("rainbow_rainforest", template.builder()
			.depth(0.4F)
			.scale(0.4F)
			.addTreeFeature(TerrestriaFeatures.RAINBOW_EUCALYPTUS_TREE, 5)
			.addTreeFeature(Feature.FANCY_TREE, 5)
			.addTreeFeature(TerrestriaFeatures.RUBBER_TREE, 3)
			.build());

		TerrestriaBiomes.RAINBOW_RAINFOREST_MOUNTAINS = TerrestriaBiomes.register("rainbow_rainforest_mountains", template.builder()
			.depth(1.0F)
			.scale(0.5F)
			.addTreeFeature(TerrestriaFeatures.RAINBOW_EUCALYPTUS_TREE, 5)
			.addTreeFeature(Feature.FANCY_TREE, 5)
			.addTreeFeature(TerrestriaFeatures.RUBBER_TREE, 3)
			.build());

		TerrestriaBiomes.RAINBOW_RAINFOREST_LAKE = TerrestriaBiomes.register("rainbow_rainforest_lake", template.builder()
			.depth(-0.2F)
			.scale(0.0F)
			.addTreeFeature(TerrestriaFeatures.RAINBOW_EUCALYPTUS_TREE, 6)
			.addTreeFeature(Feature.FANCY_TREE, 3)
			.addTreeFeature(TerrestriaFeatures.RUBBER_TREE, 3)
			.build());

		TerrestriaBiomes.RAINBOW_RAINFOREST_EDGE = TerrestriaBiomes.register("rainbow_rainforest_edge", template.builder()
			.depth(0.2F)
			.scale(0.2F)
			.addTreeFeature(TerrestriaFeatures.RAINBOW_EUCALYPTUS_TREE, 3)
			.addTreeFeature(TerrestriaFeatures.RUBBER_TREE, 3)
			.build());
	}
}
