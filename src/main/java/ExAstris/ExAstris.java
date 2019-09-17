package ExAstris;

import ExAstris.Bridge.*;
import ExAstris.CreativeTab.CreativeTabExAstris;
import ExAstris.Data.ModData;
import ExAstris.GUI.GUIHandler;
import ExAstris.Proxy.Proxy;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = ModData.ID, name = ModData.NAME, version = ModData.VERSION, dependencies = ModData.DEPENDENCIES)
public class ExAstris {
	@Instance(ModData.ID)
	public static ExAstris instance;

	@SidedProxy(clientSide = "ExAstris.Proxy.ProxyClient", serverSide = "ExAstris.Proxy.ProxyServer")
	public static Proxy proxy = Proxy.getProxy();

	public static Configuration config;
	public static Logger log;

	public static CreativeTabs ExAstrisTab = new CreativeTabExAstris(CreativeTabs.getNextID());

	@EventHandler
	public void PreInitialize(FMLPreInitializationEvent event) {
		log = LogManager.getLogger(ModData.NAME);

		ModData.setMetadata(event.getModMetadata());


		config = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + "ExAstris.cfg"));
		config.load();

		ModData.load(config);

		ExAstrisBlock.registerBlocks();
		ExAstrisItem.registerItems();

		proxy.initializeSounds();
		proxy.initializeRenderers();
		MinecraftForge.EVENT_BUS.register(this);

		if(config.hasChanged()) {
			config.save();
		}
	}

	@EventHandler
	public void Initialize(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());


		ExAstrisRecipe.registerCraftingRecipes();
		ExAstrisRecipe.registerFurnaceRecipes();
		FMLInterModComms.sendMessage("Waila", "register", "ExAstris.Bridge.Waila.callbackRegister");

		if(Loader.isModLoaded("chisel")) {
			log.info("+++ - Found Chisel!");
			Chisel.sendIMC();
		}

	}

	@EventHandler
	public void PostInitialize(FMLPostInitializationEvent event) {
		if(Loader.isModLoaded("ThermalExpansion")) {
			log.info("+++ - Found ThermalExpansion!");

			ThermalExpansion.Initialize();
		}

		if(Loader.isModLoaded("Thaumcraft")) {
			log.info("+++ - Found Thaumcraft!");

			Thaumcraft.Initialize();
		}


		if(Loader.isModLoaded("TConstruct")) {
			log.info("+++ - Found TConstruct!");

			TConstruct.Initialize();
		}

		if(Loader.isModLoaded("TSteelworks")) {
			log.info("+++ - Found TSteelworks!");

			TSteelworks.Initialize();
		}

		if(Loader.isModLoaded("MineFactoryReloaded")) {
			log.info("+++ - Found MineFactoryReloaded!");

			MineFactoryReloaded.Initialize();
		}
		if(Loader.isModLoaded("AWWayofTime")) {

			log.info("+++ - Found Blood Magic!");

			BloodMagic.Initialize();
		}

		if(Loader.isModLoaded("Metallurgy")) {

			log.info("+++ - Found Metallurgy!");
			Metallurgy.init();
		}

		if(Loader.isModLoaded("arsmagica2")) {

			log.info("+++ - Found Ars Magica!");
			ArsMagica.init();
		}

		if(Loader.isModLoaded("BigReactors")) {

			log.info("+++ - Found BigReactors!");
			BigReactors.init();
		}

		if(Loader.isModLoaded("Natura")) {
			log.info("+++ - Found Natura!");
			Natura.init();
		}

		if(Loader.isModLoaded("chisel")) {
			log.info("+++ - Found Chisel!");
			Chisel.init();
		}

		if(Loader.isModLoaded("Botania")) {
			log.info("+++ - Found Botania!");
			Botania.init();
		}

		if(Loader.isModLoaded("DraconicEvolution")) {
			log.info("+++ - Found DraconicEvolution");
			DraconicEvolution.init();
		}

		if(Loader.isModLoaded("FoodPlus")) {
			log.info("+++ - Found FoodPlus");
			FoodPlus.init();
		}

		if(Loader.isModLoaded("witchery")) {
			log.info("+++ - Found Witchery");
			Witchery.init();
		}


	}
}
