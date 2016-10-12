package trumpmod;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.model.ModelZombieVillager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerVillagerArmor;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.ZombieType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class rendertrump extends RenderBiped<trump>
{ 
	private static final ResourceLocation ZOMBIE_TEXTURES = new ResourceLocation(trumpmod.MODID + ":textures/entity/trump.png");
    private final ModelBiped defaultModel;
    private final List<LayerRenderer<trump>> villagerLayers;
    private final List<LayerRenderer<trump>> defaultLayers;

    public rendertrump(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelBiped(), 0.5F, 1.0F);
        LayerRenderer<?> layerrenderer = (LayerRenderer)this.layerRenderers.get(0);
        this.defaultModel = this.modelBipedMain;
        this.addLayer(new LayerHeldItem(this));
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this)
        {
            protected void initArmor()
            {
                this.modelLeggings = new ModelBiped(0.5F);
                this.modelArmor = new ModelBiped(1.0F);
            }
        };
        this.addLayer(layerbipedarmor);
        this.defaultLayers = Lists.newArrayList(this.layerRenderers);

        if (layerrenderer instanceof LayerCustomHead)
        {
            this.removeLayer(layerrenderer);
            this.addLayer(new LayerCustomHead(this.defaultModel.bipedHead));
        }

        this.removeLayer(layerbipedarmor);
        this.addLayer(new LayerVillagerArmor(this));
        this.villagerLayers = Lists.newArrayList(this.layerRenderers);
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(trump entitylivingbaseIn, float partialTickTime)
    {

        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(trump entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.swapArmor(entity);
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(trump entity)
    {
            return ZOMBIE_TEXTURES;
    }

    private void swapArmor(trump entity)
    {
        if (entity.isVillager())
        {
            this.mainModel = this.defaultModel;
            this.layerRenderers = this.villagerLayers;
        }
        else
        {
            this.mainModel = this.defaultModel;
            this.layerRenderers = this.defaultLayers;
        }

        this.modelBipedMain = (ModelBiped)this.mainModel;
    }
}