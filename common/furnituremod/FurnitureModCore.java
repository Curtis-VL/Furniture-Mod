package furnituremod;

import java.io.File;
import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;
import furnituremod.core.CommandFurnitureMod;
import furnituremod.core.CreativeTabFurnitureMod;
import furnituremod.core.FurnitureModConfiguration;
import furnituremod.core.lib.*;
import furnituremod.core.proxy.CoreProxy;

@Mod(name = "VoxelLoop Furniture Mod", version = Reference.VERSION_NUMBER, useMetadata = false, modid = Reference.MOD_ID, acceptedMinecraftVersions = "[1.6,1.7)", dependencies = Reference.DEPENDENCIES)
@NetworkMod(clientSideRequired = true, 
			serverSideRequired = false)

public class FurnitureModCore {
@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)

    public static CoreProxy proxy;
    public static CreativeTabs tabFurnitureMod = new CreativeTabFurnitureMod(Reference.MOD_ID);
	public static FurnitureModConfiguration mainConfiguration;
	public static final Logger ufLog = Logger.getLogger("FurnitureMod");
	
@Instance("FurnitureMod|Core")
	public static FurnitureModCore instance;


//////////////////////Blocks and Items//////////////////////

/*
 * IMPORT CRAPPY
 * BLOCKS AND ITEMS
 * HERE
 */
public static Block blockTest;
public static Item itemTest;

//////////////////////////////////////////////////////////////////////////////////////EVENT HANDLERS//////////////////////////////////////////////////////////////////////////////////////


////////////////Pre-Initialise////////////////
@EventHandler
public void loadConfiguration(FMLPreInitializationEvent event) {


	ufLog.setParent(FMLLog.getLogger());
	ufLog.info("Loading VoxelLoop FurnitureMod " + Reference.VERSION_NUMBER);
	ufLog.info("Searching For Configuration File");
	ufLog.info("Configuration Found, Loading");
	ufLog.info("Loading Blocks");
	ufLog.info("Loading Items");
	ufLog.info("Loading Completed");       	
	ufLog.info("Copyright (c) VoxelLoop, 2013");
	ufLog.info("http://www.fm.voxelloop.co.uk/");
	
	mainConfiguration = new FurnitureModConfiguration(new File(event.getModConfigurationDirectory(), "furnituremod/main.conf"));
	try {
		mainConfiguration.load();
		
		Property updateCheck = FurnitureModCore.mainConfiguration.get(Configuration.CATEGORY_GENERAL, "update.check", true);
		updateCheck.comment = "set to true for version check on startup";
		if (updateCheck.getBoolean(true)) {
			furnituremod.core.Version.check();
		}
} finally {
	if (mainConfiguration.hasChanged()) {
		mainConfiguration.save();{
		}
	}
}
}


////////////////Initialise////////////////
@EventHandler
public void Init(FMLInitializationEvent event) {
	//furnituremod.core.utils.Localization.addLocalization("/lang/furnituremod/", universalfurniture.core.DefaultProps.DEFAULT_LANGUAGE);

	itemTest = new furnituremod.core.items.itemTest(30077).setUnlocalizedName("itemtest");
	LanguageRegistry.addName(itemTest, "Test Item");

	
	/*blockTest = new furnituremod.core.blocks.blockTest(3348, Material.).setUnlocalizedName("blocktest");
	GameRegistry.registerBlock(blockTest, Reference.MOD_ID + blockTest.getUnlocalizedName().substring(5));
	LanguageRegistry.addName(blockTest, "Test Block");*/
	  
}



////////////////Post-Initialise////////////////
@EventHandler
public void PostInit(FMLPostInitializationEvent event) {

}



////////////////Server-Initialise////////////////
@EventHandler
public void serverStarting(FMLServerStartingEvent event) {

	event.registerServerCommand(new CommandFurnitureMod());

} 


}