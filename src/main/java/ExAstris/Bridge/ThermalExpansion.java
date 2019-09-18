package ExAstris.Bridge;

import ExAstris.Data.ModData;
import cofh.api.modhelpers.ThermalExpansionHelper;
import cofh.thermalfoundation.entity.monster.EntityBlizz;
import cofh.thermalfoundation.fluid.TFFluids;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.HeatRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class ThermalExpansion {
	public static void Initialize() {
		addHeatRegistry();
		if(ModData.allowThermalExpansionHive) {
			addHiveRegistry();
		}
	}

	public static void addHiveRegistry() {
		if(Loader.isModLoaded("Forestry")) {
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")), new ItemStack(Blocks.leaves, 8), new ItemStack(GameRegistry.findBlock("Forestry", "beehives"), 1, 1));
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")), new ItemStack(Blocks.grass, 8), new ItemStack(GameRegistry.findBlock("Forestry", "beehives"), 1, 2));
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")), new ItemStack(Blocks.sand, 8), new ItemStack(GameRegistry.findBlock("Forestry", "beehives"), 1, 3));
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")), new ItemStack(Blocks.vine, 8), new ItemStack(GameRegistry.findBlock("Forestry", "beehives"), 1, 4));
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")), new ItemStack(Items.ender_pearl, 8), new ItemStack(GameRegistry.findBlock("Forestry", "beehives"), 1, 5));
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")), new ItemStack(Blocks.ice, 8), new ItemStack(GameRegistry.findBlock("Forestry", "beehives"), 1, 6));
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")), new ItemStack(Blocks.mycelium, 8), new ItemStack(GameRegistry.findBlock("Forestry", "beehives"), 1, 7));
		}
		if(Loader.isModLoaded("ExtraBees")) {
			ThermalExpansionHelper.addTransposerFill(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")), new ItemStack(GameRegistry.findBlock("ExtraBees", "hive"), 1, 0), new FluidStack(FluidRegistry.WATER, 8000), false);
			if(Loader.isModLoaded("TConstruct")) {
				//addTransposerRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")),new ItemStack(GameRegistry.findBlock("ExtraBees", "hive"),1,1),new FluidStack(TinkerSmeltery.moltenStoneFluid, 8000),false);
			}
			ThermalExpansionHelper.addTransposerFill(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")), new ItemStack(GameRegistry.findBlock("ExtraBees", "hive"), 1, 2), new FluidStack(TFFluids.fluidRedstone, 8000), false);
			if(Loader.isModLoaded("MineFactoryReloaded")) {
				ThermalExpansionHelper.addTransposerFill(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")), new ItemStack(GameRegistry.findBlock("ExtraBees", "hive"), 1, 3), new FluidStack(FluidRegistry.getFluid("milk"), 8000), false);
			}
		}
	}

	public static void addHeatRegistry() {
		if(ModData.allowThermalExpansionHeat) {
			HeatRegistry.register(GameRegistry.findBlock("ThermalFoundation", "FluidPyrotheum"), 0.5F);
			HeatRegistry.register(GameRegistry.findBlock("ThermalFoundation", "FluidPyrotheum"), 0, 0.7F);
			HeatRegistry.register(GameRegistry.findBlock("ThermalFoundation", "FluidCryotheum"), 0.2F);
			HeatRegistry.register(GameRegistry.findBlock("ThermalFoundation", "FluidCryotheum"), 0, 0.3F);
		}
	}

	public static void summonBlizz(World worldObj, double x, double y, double z) {
		EntityBlizz peck = new EntityBlizz(worldObj);
		peck.setPosition(x, y, z);
		worldObj.spawnEntityInWorld(peck);
	}
}
