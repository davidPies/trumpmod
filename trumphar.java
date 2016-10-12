package trumpmod;

import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class trumphar extends ItemArmor{
	public String textureName;

	public trumphar(String textureName, String unlocalizedName, ArmorMaterial material, int index, EntityEquipmentSlot type) {
	    super(material, 0, type);
	    this.textureName = textureName;
	    this.setUnlocalizedName(unlocalizedName);
	    
	    this.setCreativeTab(tabs.trumpmodtab);
	}
}
