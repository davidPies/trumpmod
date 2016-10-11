package trumpmod;

import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword {
}

public thepoll(String unlocalizedName, ToolMaterial material) {
    super(material);
    this.setUnlocalizedName(unlocalizedName);
    this.setCreativeTab(tabs.trumpmodtab);
}
//use baseball steel bat hitting sounds
//register texture aswell
//GameRegistry.registerItem(thepoll = new thepoll("thepoll", pollmat), "thepoll");
//public static ToolMaterial pollmat = EnumHelper.addToolMaterial("pollmat", 0, 256, 2.0F, 1.0F, 18);
