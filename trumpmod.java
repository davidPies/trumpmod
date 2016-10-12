package trumpmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = trumpmod.MODID, version = trumpmod.VERSION)
public class trumpmod
{
    public static final String MODID = "trumpmod";
    public static final String VERSION = "1.0";
    
    	//public static wheatcannon1 wheatcannon1;
    	public static Item trumphair2;
    	public static Item money;
    	public static Item snatcher;
    	public static Item spring;
    	public static Item handle;
    	public static Item grabber;
    	public static ArmorMaterial trumphair = EnumHelper.addArmorMaterial("trumphair", "trumpmod:trumphair", 10, new int[]{2, 0, 0, 2}, 15, SoundEvents.BLOCK_CLOTH_HIT, 0.0F);
    	
    	@SidedProxy(clientSide="trumpmod.client", serverSide="trumpmod.server")
    public static sharedproxy proxy;
    
    @EventHandler
    public void pre(FMLPreInitializationEvent e){
    	proxy.registerRenderers();
    	//trumphair = new hair("trumphair", hairt, 0, EntityEquipmentSlot.HEAD);
    	//GameRegistry.registerItem(trumphair, "trumphair");
    	EntityRegistry.registerModEntity(trump.class, "trump", 0, MODID, 64, 5, true);
    	EntityRegistry.registerEgg(trump.class, 0, 1000);
    	
    	EntityRegistry.registerModEntity(dealer.class, "dealer", 0, MODID, 64, 5, true);
    	EntityRegistry.registerEgg(dealer.class, 0, 150);
    	 }
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
    	RenderingRegistry.registerEntityRenderingHandler(trump.class, new RenderBiped(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 1.0F){
    		protected ResourceLocation getEntityTexture(Entity entity){
    			return new ResourceLocation("trumpmod", "textures/entity/trump2.png"); 
    			
    		}});
    	RenderingRegistry.registerEntityRenderingHandler(dealer.class, new RenderBiped(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 1.0F){
    		protected ResourceLocation getEntityTexture(Entity entity){
    			return new ResourceLocation("trumpmod", "textures/entity/dealer2.png"); 
    			
    		}});
    	//EntityRegistry.registerModEntity(trump.class, "trump", 0, MODID, 15, 5, true);
    	//EntityRegistry.registerEgg(trump.class, 0, 1000);
    	GameRegistry.registerItem(trumphair2 = new trumphar("trumpmod:trumphair", "trumphair", trumphair, 0, EntityEquipmentSlot.HEAD), "trumphair");
    	GameRegistry.registerItem(money = new money(4, 1, false), "money");
    	GameRegistry.registerItem(snatcher = new snatcher(), "snatcher");
    	GameRegistry.registerItem(spring = new spring(), "spring");
    	GameRegistry.registerItem(handle = new handle(), "handle");
    	GameRegistry.registerItem(grabber = new grabber(), "grabber");
    	GameRegistry.addRecipe(new ItemStack(trumpmod.snatcher), new Object[] {"x  ", " z ", "  y", 'x', trumpmod.grabber, 'z', trumpmod.spring, 'y', trumpmod.handle});
    	GameRegistry.addRecipe(new ItemStack(trumpmod.spring, 4), new Object[] {"x  ", " x ", "  x", 'x', Items.STRING});
    	GameRegistry.addRecipe(new ItemStack(trumpmod.handle, 4), new Object[] {"xx", "xx", 'x', Items.STICK});
    	GameRegistry.addRecipe(new ItemStack(trumpmod.grabber, 4), new Object[] {" x", "xx", 'x', Items.STICK});
    	//RenderingRegistry.registerEntityRenderingHandler(trump.class, new RenderBiped(null, new ModelBiped(), 1));
    	//RenderingRegistry.registerEntityRenderingHandler(entitywheat.class, new renderwheat(new RenderManager(null, null)){
    		//protected ResourceLocation getEntityTexture(Entity par1Entity){
    		//return new ResourceLocation("wheatcore:wheatthin.png");
    		//} 
    	//}//);
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(trumphair2, 0, new ModelResourceLocation(MODID + ":" + trumphair2.getUnlocalizedName().substring(5), "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(money, 0, new ModelResourceLocation(MODID + ":" + money.getUnlocalizedName().substring(5), "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(snatcher, 0, new ModelResourceLocation(MODID + ":" + snatcher.getUnlocalizedName().substring(5), "inventory"));
      	 
    	//RenderingRegistry.registerEntityRenderingHandler(entityw.class, new rendersnow(new RenderManager(null, null), 0.0F));
    	//GameRegistry.registerItem(stuff2.cage1(null), "cage1");
        //System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
}