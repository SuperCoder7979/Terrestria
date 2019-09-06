package com.terraformersmc.terrestria.init;

import com.terraformersmc.terraform.biomeapi.OverworldBiomesExt;
import com.terraformersmc.terraform.config.BiomeConfig;
import com.terraformersmc.terraform.config.BiomeConfigNode;
import net.fabricmc.fabric.api.biomes.v1.FabricBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import static com.terraformersmc.terrestria.init.TerrestriaBiomes.*;

public class TerrestriaGeneration {
	// Note: This can handle the cases of biomes not registered, but currently biomes are always registered

	public static void init(BiomeConfig config) {
		// 33% of Jungles will be replaced by Rainforest biomes
		// 33% of Mountains will be replaced with Caldera Ridges
		// 10% of Deep Oceans will be replaced with Volcanic Islands

		addBiomeVariant(Biomes.MOUNTAINS, CALDERA_RIDGE, 0.33, "caldera", config);
		addContinentalBiome(CYPRESS_FOREST, OverworldClimate.TEMPERATE, 1.0, "cypress_forest", config);
		addContinentalBiome(CYPRESS_SWAMP, OverworldClimate.TEMPERATE, 1.0, "cypress_swamp", config);
		addContinentalBiome(DENSE_WOODLANDS, OverworldClimate.DRY, 1.0, "dense_woodlands", config);
		addContinentalBiome(HEMLOCK_RAINFOREST, OverworldClimate.COOL, 1.0, "hemlock_rainforest", config);
		addContinentalBiome(JAPANESE_MAPLE_FOREST, OverworldClimate.TEMPERATE, 1.0, "japanese_maple_forest", config);
		addContinentalBiome(LUSH_REDWOOD_FOREST, OverworldClimate.TEMPERATE, 1.0, "lush_redwood_forest", config);
		addBiomeVariant(Biomes.JUNGLE, RAINBOW_RAINFOREST, 0.33, "rainbow_rainforest", config);
		addContinentalBiome(REDWOOD_FOREST, OverworldClimate.TEMPERATE, 1.0, "redwood_forest", config);
		addContinentalBiome(SAKURA_FOREST, OverworldClimate.TEMPERATE, 1.0, "sakura_forest", config);
		addContinentalBiome(SNOWY_HEMLOCK_FOREST, OverworldClimate.SNOWY, 2.0, "snowy_hemlock_forest", config);
		addContinentalBiome(MIXED_FOREST, OverworldClimate.TEMPERATE, 20, "mixed_forest", config);
		addBiomeVariant(Biomes.DEEP_OCEAN, VOLCANIC_ISLAND_SHORE, 0.10, "volcanic_island", config);

		if(CALDERA_RIDGE != null) {
			OverworldBiomes.addEdgeBiome(CALDERA, CALDERA_BEACH, 1);
			OverworldBiomesExt.addBorderBiome(CALDERA_RIDGE, CALDERA_FOOTHILLS);
			OverworldBiomesExt.addCenterBiome(CALDERA_RIDGE, CALDERA);

			OverworldBiomes.setRiverBiome(CALDERA_FOOTHILLS, null);
			OverworldBiomes.setRiverBiome(CALDERA, null);
			OverworldBiomes.setRiverBiome(CALDERA_BEACH, null);
			OverworldBiomes.setRiverBiome(CALDERA_RIDGE, null);
		}

		if (MIXED_FOREST != null) {
			OverworldBiomes.addHillsBiome(MIXED_FOREST, MIXED_FOREST_CLEARING, 1.0);
			OverworldBiomes.addHillsBiome(MIXED_FOREST, MIXED_FOREST_LAKE, 2.0);
			OverworldBiomes.addHillsBiome(MIXED_FOREST, MIXED_FOREST_HILLS, 1.5);
			OverworldBiomes.addEdgeBiome(MIXED_FOREST, MIXED_FOREST_EDGE, 1.0);

			OverworldBiomes.addShoreBiome(MIXED_FOREST, MIXED_FOREST_BEACH, 1.0);
			OverworldBiomes.addShoreBiome(MIXED_FOREST_LAKE, MIXED_FOREST_BEACH, 1.0);
			OverworldBiomes.addShoreBiome(MIXED_FOREST_HILLS, MIXED_FOREST_BEACH, 1.0);
			OverworldBiomes.addShoreBiome(MIXED_FOREST_EDGE, MIXED_FOREST_BEACH, 1.0);

			FabricBiomes.addSpawnBiome(MIXED_FOREST);
		}

		if(CYPRESS_FOREST != null) {
			OverworldBiomes.addHillsBiome(CYPRESS_FOREST, WOODED_CYPRESS_HILLS, 1.0);

			FabricBiomes.addSpawnBiome(CYPRESS_FOREST);
		}

		if(DENSE_WOODLANDS != null) {
			OverworldBiomes.addEdgeBiome(DENSE_WOODLANDS, DENSE_WOODLANDS_EDGE, 1);
		}

		if(HEMLOCK_RAINFOREST != null) {
			OverworldBiomes.addHillsBiome(HEMLOCK_RAINFOREST, HEMLOCK_CLEARING, 1.0);

			FabricBiomes.addSpawnBiome(HEMLOCK_RAINFOREST);
		}

		if(JAPANESE_MAPLE_FOREST != null) {
			OverworldBiomes.addHillsBiome(JAPANESE_MAPLE_FOREST, WOODED_JAPANESE_MAPLE_HILLS, 1.0);
		}

		if(LUSH_REDWOOD_FOREST != null) {
			OverworldBiomes.addHillsBiome(LUSH_REDWOOD_FOREST, LUSH_REDWOOD_CLEARING, 1.0);
			OverworldBiomes.addEdgeBiome(LUSH_REDWOOD_FOREST, LUSH_REDWOOD_FOREST_EDGE, 1);

			FabricBiomes.addSpawnBiome(LUSH_REDWOOD_FOREST);
		}

		if(RAINBOW_RAINFOREST != null) {
			OverworldBiomes.addHillsBiome(RAINBOW_RAINFOREST, RAINBOW_RAINFOREST_LAKE, 0.6);
			OverworldBiomes.addHillsBiome(RAINBOW_RAINFOREST, RAINBOW_RAINFOREST_MOUNTAINS, 1.0);

			FabricBiomes.addSpawnBiome(RAINBOW_RAINFOREST);
		}

		if(REDWOOD_FOREST != null) {
			OverworldBiomes.addHillsBiome(REDWOOD_FOREST, REDWOOD_CLEARING, 1.0);
			OverworldBiomes.addEdgeBiome(REDWOOD_FOREST, REDWOOD_FOREST_EDGE, 1);

			FabricBiomes.addSpawnBiome(REDWOOD_FOREST);
		}

		if(SAKURA_FOREST != null) {
			OverworldBiomes.addHillsBiome(SAKURA_FOREST, WOODED_SAKURA_HILLS, 1.0);
		}

		if(SNOWY_HEMLOCK_FOREST != null) {
			OverworldBiomes.addHillsBiome(SNOWY_HEMLOCK_FOREST, SNOWY_HEMLOCK_CLEARING, 1.0);
		}

		if(VOLCANIC_ISLAND_SHORE != null) {
			OverworldBiomesExt.addCenterBiome(VOLCANIC_ISLAND_SHORE, VOLCANIC_ISLAND);
			OverworldBiomesExt.addBorderBiome(VOLCANIC_ISLAND_SHORE, VOLCANIC_ISLAND_SHORE);
			OverworldBiomes.addShoreBiome(VOLCANIC_ISLAND, VOLCANIC_ISLAND_BEACH, 1);
			OverworldBiomes.addShoreBiome(VOLCANIC_ISLAND_SHORE, VOLCANIC_ISLAND_BEACH, 1);

			OverworldBiomes.setRiverBiome(VOLCANIC_ISLAND, null);
			OverworldBiomes.setRiverBiome(VOLCANIC_ISLAND_BEACH, null);
			OverworldBiomes.setRiverBiome(VOLCANIC_ISLAND_SHORE, null);
		}
	}

	private static void addBiomeVariant(Biome parent, Biome biome, double chance, String name, BiomeConfig config) {
		boolean enable = !config.isFrozen();

		BiomeConfigNode.Variant variant = config.variant(name, new BiomeConfigNode.Variant(enable, chance));
		enable = variant.isEnabled();

		if(biome != null && enable && variant.getVariantChance() > 0.0) {
			OverworldBiomes.addBiomeVariant(parent, biome, variant.getVariantChance());
		}
	}

	private static void addContinentalBiome(Biome biome, OverworldClimate climate, double weight, String name, BiomeConfig config) {
		boolean enable = !config.isFrozen();

		BiomeConfigNode.Continental continental = config.continental(name, new BiomeConfigNode.Continental(enable, weight));
		enable = continental.isEnabled();

		if(biome != null && enable && continental.getWeight() > 0.0) {
			OverworldBiomes.addContinentalBiome(biome, climate, continental.getWeight());
		}
	}
}
