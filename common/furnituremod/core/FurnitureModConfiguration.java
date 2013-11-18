	package furnituremod.core;

	import java.io.File;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import furnituremod.FurnitureModCore;
import furnituremod.core.lib.Reference;

	public class FurnitureModConfiguration extends Configuration {


		public FurnitureModConfiguration(File file) {
			super(file);
		}

							public void save() 
							{
							Property versionProp = get(CATEGORY_GENERAL, "version", Reference.VERSION_NUMBER);
							versionProp.set(Reference.VERSION_NUMBER);
			
	//Items
							@SuppressWarnings("unused")
							Property itemCoolPackId = FurnitureModCore.mainConfiguration.getItem("coolpack.id", furnituremod.core.DefaultProps.BASIC_ITEM_ID);						
							
	//Blocks						
							@SuppressWarnings("unused")
							Property blockBasicHedgeId = FurnitureModCore.mainConfiguration.getBlock("basichedge.id", furnituremod.core.DefaultProps.BASIC_BLOCK_ID);
				
							
							
							super.save();
							}

	}