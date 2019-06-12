package net.coderbot.terrestria.init;

import net.coderbot.terrestria.block.TransparentLeavesBlock;
import net.coderbot.terrestria.block.*;
import net.coderbot.terrestria.feature.RubberTreeFeature;
import net.coderbot.terrestria.feature.TreeDefinition;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class TerrestriaBlocks {
	public static WoodBlocks RUBBER;
	public static WoodBlocks CYPRESS;
	public static WoodBlocks BALD_CYPRESS;
	public static WoodBlocks JAPANESE_MAPLE;
	public static WoodBlocks RAINBOW_EUCALYPTUS;
	public static WoodBlocks SAKURA;

	public static LeavesBlock JAPANESE_MAPLE_SHRUB_LEAVES;
	public static LeafPileBlock SAKURA_LEAF_PILE;

	public static SeagrassBlock CATTAIL;
	public static TallSeagrassBlock TALL_CATTAIL;

	public static QuarterLogBlock BALD_CYPRESS_QUARTER_LOG;
	public static QuarterLogBlock RAINBOW_EUCALYPTUS_QUARTER_LOG;

	public static CustomSaplingBlock RUBBER_SAPLING;
	public static CustomSaplingBlock CYPRESS_SAPLING;
	public static CustomSaplingBlock BALD_CYPRESS_SAPLING;
	public static CustomSaplingBlock JAPANESE_MAPLE_SAPLING;
	public static CustomSaplingBlock JAPANESE_MAPLE_SHRUB_SAPLING;
	public static CustomSaplingBlock RAINBOW_EUCALYPTUS_SAPLING;
	public static CustomSaplingBlock SAKURA_SAPLING;

	public static void init() {
		RUBBER = WoodBlocks.register("rubber");
		CYPRESS = WoodBlocks.register("cypress");
		BALD_CYPRESS = WoodBlocks.register("bald_cypress");
		JAPANESE_MAPLE = WoodBlocks.register("japanese_maple");
		RAINBOW_EUCALYPTUS = WoodBlocks.register("rainbow_eucalyptus");

		SAKURA = WoodBlocks.registerManufactured("sakura");
		SAKURA.log = register("sakura_log", new SakuraLogBlock(Block.Settings.copy(Blocks.OAK_LOG)));
		SAKURA.wood = SAKURA.log;
		SAKURA.leaves = register("sakura_leaves", new TransparentLeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES)));

		JAPANESE_MAPLE_SHRUB_LEAVES = register("japanese_maple_shrub_leaves", new LeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES)));
		SAKURA_LEAF_PILE = register("sakura_leaf_pile", new LeafPileBlock(Block.Settings.copy(Blocks.OAK_LEAVES).noCollision()));

		CATTAIL = register("cattail", new CustomSeagrassBlock(Block.Settings.copy(Blocks.SEAGRASS)));
		TALL_CATTAIL = register("tall_cattail", new CustomTallSeagrassBlock(Block.Settings.copy(Blocks.SEAGRASS)));

		BALD_CYPRESS_QUARTER_LOG = register("bald_cypress_log_quarter", new QuarterLogBlock(Block.Settings.copy(Blocks.OAK_LOG)));
		RAINBOW_EUCALYPTUS_QUARTER_LOG = register("rainbow_eucalyptus_log_quarter", new QuarterLogBlock(Block.Settings.copy(Blocks.OAK_LOG)));

		RUBBER_SAPLING = register("rubber_sapling", new CustomSaplingBlock (
				new CustomSaplingGenerator (
						rand -> new RubberTreeFeature(DefaultFeatureConfig::deserialize, true, RUBBER.getBasicDefinition())
				)
		));

		CYPRESS_SAPLING = register("cypress_sapling", new CustomSaplingBlock (
				new CustomSaplingGenerator (rand -> TerrestriaBiomes.CYPRESS_TREE)
		));

		BALD_CYPRESS_SAPLING = register("bald_cypress_sapling", new CustomSaplingBlock (
				new CustomSaplingGenerator (rand -> TerrestriaBiomes.BALD_CYPRESS_TREE)
		));

		JAPANESE_MAPLE_SAPLING = register("japanese_maple_sapling", new CustomSaplingBlock (
				new CustomSaplingGenerator (rand -> TerrestriaBiomes.JAPANESE_MAPLE_TREE)
		));

		JAPANESE_MAPLE_SHRUB_SAPLING = register("japanese_maple_shrub_sapling", new CustomSaplingBlock (
				new CustomSaplingGenerator (rand -> TerrestriaBiomes.JAPANESE_MAPLE_SHRUB)
		));

		RAINBOW_EUCALYPTUS_SAPLING = register("rainbow_eucalyptus_sapling", new CustomSaplingBlock (
				new CustomSaplingGenerator (rand -> TerrestriaBiomes.RAINBOW_EUCALYPTUS_TREE)
		));

		SAKURA_SAPLING = register("sakura_sapling", new CustomSaplingBlock (
				new CustomSaplingGenerator(rand -> TerrestriaBiomes.SAKURA_TREE)
		));

		// TODO: Flammability
		// TODO: Wood, Stripped Logs, Stripped Wood
	}

	public static <T extends Block> T register(String name, T block) {
		return Registry.register(Registry.BLOCK, new Identifier("terrestria", name), block);
	}

	public static class WoodBlocks {
		public Block log;
		public Block wood;
		public LeavesBlock leaves;

		public Block planks;
		public SlabBlock slab;
		public CustomStairsBlock stairs;
		public FenceBlock fence;
		public FenceGateBlock fenceGate;
		public CustomDoorBlock door;

		private WoodBlocks() {}

		// TODO: Map colors
		public static WoodBlocks register(String name) {
			WoodBlocks blocks = registerManufactured(name);

			blocks.log = TerrestriaBlocks.register(name + "_log", new LogBlock(MaterialColor.SPRUCE, Block.Settings.copy(Blocks.OAK_LOG)));
			blocks.wood = TerrestriaBlocks.register(name + "_wood", new LogBlock(MaterialColor.SPRUCE, Block.Settings.copy(Blocks.OAK_LOG)));
			blocks.leaves = TerrestriaBlocks.register(name + "_leaves", new LeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES)));

			return blocks;
		}

		public static WoodBlocks registerManufactured(String name) {
			WoodBlocks blocks = new WoodBlocks();

			blocks.planks = TerrestriaBlocks.register(name + "_planks", new Block(Block.Settings.copy(Blocks.OAK_PLANKS)));
			blocks.slab = TerrestriaBlocks.register(name + "_slab", new SlabBlock(Block.Settings.copy(Blocks.OAK_SLAB)));
			blocks.stairs = TerrestriaBlocks.register(name + "_stairs", new CustomStairsBlock(blocks.planks.getDefaultState(), Block.Settings.copy(Blocks.OAK_STAIRS)));
			blocks.fence = TerrestriaBlocks.register(name + "_fence", new FenceBlock(Block.Settings.copy(Blocks.OAK_FENCE)));
			blocks.fenceGate = TerrestriaBlocks.register(name + "_fence_gate", new FenceGateBlock(Block.Settings.copy(Blocks.OAK_FENCE_GATE)));
			blocks.door = TerrestriaBlocks.register(name + "_door", new CustomDoorBlock(Block.Settings.copy(Blocks.OAK_FENCE_GATE)));

			return blocks;
		}

		public TreeDefinition.Basic getBasicDefinition() {
			TreeDefinition.Basic basic = new TreeDefinition.Basic();

			basic.leaves = this.leaves.getDefaultState();
			basic.wood = this.log.getDefaultState();

			return basic;
		}
	}
}