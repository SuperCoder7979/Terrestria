package com.terraformersmc.terrestria.mixin;

import com.terraformersmc.terrestria.init.TerrestriaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidBlock.class)
public class MixinFluidBlock {
	@Inject(method = "receiveNeighborFluids", at = @At("RETURN"))
	public void formBasaltCobblestone(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> callback) {
		// Either Cobblestone or Obsidian formed

		if(!callback.getReturnValueZ()) {
			FluidState fluid = world.getFluidState(pos);

			if(fluid.isStill()) {
				// Obsidian was formed, nothing to override

				return;
			}

			Block below = world.getBlockState(pos.down()).getBlock();
			Block cobblestone = TerrestriaBlocks.BASALT.cobblestone.full;

			// If basalt cobblestone / stone is below, change to basalt cobblestone

			if(below == TerrestriaBlocks.BASALT.plain.full || below == cobblestone) {
				world.setBlockState(pos, cobblestone.getDefaultState());
			}
		}
	}
}
