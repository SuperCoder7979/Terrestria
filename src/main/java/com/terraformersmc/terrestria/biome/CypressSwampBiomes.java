package com.terraformersmc.terrestria.biome;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import com.terraformersmc.terrestria.init.TerrestriaFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class CypressSwampBiomes {
	public static void register() {
		TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
			.configureSurfaceBuilder(SurfaceBuilder.SWAMP, SurfaceBuilder.GRASS_CONFIG)
			.precipitation(Biome.Precipitation.RAIN).category(Biome.Category.SWAMP)
			.temperature(0.7F)
			.downfall(0.7F)
			.waterColor(0x2c7f32)
			.waterFogColor(0x053305)
			.addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, MINEABLES, ORES, CLAY, DEFAULT_GRASS,
				DEFAULT_MUSHROOMS, SPRINGS, SEAGRASS, MORE_SEAGRASS, FOSSILS, FROZEN_TOP_LAYER, SWAMP_VEGETATION,
				DESERT_VEGETATION)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(
				TerrestriaFeatures.CATTAIL, new SeagrassFeatureConfig(80, 0.3D),
				Decorator.TOP_SOLID_HEIGHTMAP, DecoratorConfig.DEFAULT))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(
				Feature.WATERLILY, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(32)))
			.addGrassFeature(Blocks.GRASS.getDefaultState(), 2)
			.addGrassFeature(Blocks.BROWN_MUSHROOM.getDefaultState(), 1)
			.addDoubleGrassFeature(Blocks.TALL_GRASS.getDefaultState(), 1)
			.addStructureFeature(Feature.STRONGHOLD)
			.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
			.addDefaultSpawnEntries()
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.COD, 8, 2, 4))
		);

		TerrestriaBiomes.CYPRESS_SWAMP = TerrestriaBiomes.register("cypress_swamp", template.builder()
			.depth(-0.25F)
			.scale(0.05F)
			.addTreeFeature(TerrestriaFeatures.MEGA_CYPRESS_TREE, 2)
			.addTreeFeature(TerrestriaFeatures.RUBBER_TREE, 3)
			.addTreeFeature(TerrestriaFeatures.WILLOW_TREE, 1)
			.build());

		TerrestriaBiomes.CYPRESS_SWAMP_EDGE = TerrestriaBiomes.register("cypress_swamp_edge", template.builder()
			.depth(-0.2F)
			.scale(0.05F)
			.addTreeFeature(TerrestriaFeatures.MEGA_CYPRESS_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.RUBBER_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.WILLOW_TREE, 1)
			.build());

		TerrestriaBiomes.CYPRESS_SWAMP_CLEARING = TerrestriaBiomes.register("cypress_swamp_clearing", template.builder()
			.depth(-0.175F)
			.scale(0.01F)
			.addTreeFeature(TerrestriaFeatures.RUBBER_TREE, 1)
			.build());

		TerrestriaBiomes.CYPRESS_SWAMP_RUBBER = TerrestriaBiomes.register("cypress_swamp_rubber", template.builder()
			.depth(-0.1F)
			.scale(0.03F)
			.addTreeFeature(TerrestriaFeatures.MEGA_CYPRESS_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.RUBBER_TREE, 8)
			.build());

		TerrestriaBiomes.CYPRESS_SWAMP_WILLOW = TerrestriaBiomes.register("cypress_swamp_willow", template.builder()
			.depth(-0.1F)
			.scale(0.03F)
			.addTreeFeature(TerrestriaFeatures.MEGA_CYPRESS_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.WILLOW_TREE, 6)
			.build());

		TerrestriaBiomes.SWAMPY_RIVER = TerrestriaBiomes.register("swampy_river", template.builder()
			.depth(-0.45F)
			.scale(0.05F)
			.addTreeFeature(TerrestriaFeatures.MEGA_CYPRESS_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.RUBBER_TREE, 1)
			.addTreeFeature(TerrestriaFeatures.WILLOW_TREE, 1)
			.build());
	}
}
