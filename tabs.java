package trumpmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class tabs extends Item{
	public static final CreativeTabs trumpmodtab = new CreativeTabs("trumpmodtab") {
	    @Override public Item getTabIconItem() {
	        return trumpmod.trumphair2;
	    }
	};
}
