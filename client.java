package trumpmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class client extends sharedproxy{

	@EventHandler
    public void pre(FMLPreInitializationEvent e){
		super.pre(e);
    }
	@EventHandler
    public void init(FMLInitializationEvent e){
		super.init(e);
    }
	public void registerRenderers() {
		//problem binding texture
		//RenderingRegistry.registerEntityRenderingHandler(trump.class, new RenderLiving(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 1.0F){
		//protected ResourceLocation getEntityTexture(Entity entity){
			//return new ResourceLocation("trumpmod:texures/entity/steve.png");
			
		//}
		//});
	}
}