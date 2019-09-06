package com.terraformersmc.terrestria.surface;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;
import java.util.function.Function;

public class MixedForestSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {
	private double amountOfPodzolMax = 3;
	private double amountOfPodzolMin = 1;
	public MixedForestSurfaceBuilder(Function<Dynamic<?>, ? extends TernarySurfaceConfig> function_1) {
		super(function_1);
	}

	public MixedForestSurfaceBuilder setMaxPodzolAmount(double amt) {
		this.amountOfPodzolMax = amt;
		return this;
	}

	public MixedForestSurfaceBuilder setMinPodzolAmount(double amt) {
		this.amountOfPodzolMin = amt;
		return this;
	}

	public void generate(Random rand, Chunk chunk, Biome biome, int x, int z, int height, double noiseVal, BlockState var9, BlockState var10, int var11, long seed, TernarySurfaceConfig config) {
		if (noiseVal > amountOfPodzolMin && noiseVal < amountOfPodzolMax) {
			SurfaceBuilder.DEFAULT.generate(rand, chunk, biome, x, z, height, noiseVal, var9, var10, var11, seed, SurfaceBuilder.PODZOL_CONFIG);
		} else {
			SurfaceBuilder.DEFAULT.generate(rand, chunk, biome, x, z, height, noiseVal, var9, var10, var11, seed, SurfaceBuilder.GRASS_CONFIG);
		}

	}
}
