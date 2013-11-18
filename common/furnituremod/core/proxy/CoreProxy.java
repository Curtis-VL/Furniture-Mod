package furnituremod.core.proxy;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.SidedProxy;

public class CoreProxy {

	
	@SidedProxy(clientSide = furnituremod.core.lib.Reference.CLIENT_PROXY_CLASS, serverSide = furnituremod.core.lib.Reference.SERVER_PROXY_CLASS)
	public static CoreProxy proxy;
	
	public String getMinecraftVersion() {
		return Loader.instance().getMinecraftModContainer().getVersion();
}

	/* LOCALIZATION */
	public void addName(Object obj, String s) {
	}
	public void addLocalization(String s1, String string) {
	}
	public String getItemDisplayName(ItemStack newStack) {
		return "";
	}
	public String getCurrentLanguage() {
	return null;
	}

	

}