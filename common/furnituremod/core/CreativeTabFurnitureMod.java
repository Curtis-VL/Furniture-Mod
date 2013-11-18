package furnituremod.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;



public class CreativeTabFurnitureMod extends CreativeTabs {


		public static CreativeTabs tabUniversalFurniture;

		public CreativeTabFurnitureMod(String label) {
			super(label);
		}

		@Override
	    public ItemStack getIconItemStack() {
			return new ItemStack(Item.bed);
		}
		
		@Override
	    public String getTranslatedTabLabel() {
			return "VoxelLoop Furniture Mod";
		}
	}


