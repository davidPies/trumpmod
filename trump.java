package trumpmod;

import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class trump extends EntityCow
{
	private static final Set<Item> ITEMS = Sets.newHashSet(new Item[] {trumpmod.money, Items.GOLD_NUGGET, Items.GOLD_INGOT});

    public trump(World worldIn)
    {
        super(worldIn);
        this.setSize(0.9F, 1.4F);
    }

    public static void func_189790_b(DataFixer p_189790_0_)
    {
        EntityLiving.func_189752_a(p_189790_0_, "trump");
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        //this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, trumpmod.money, false));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, false, ITEMS));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    protected SoundEvent getHurtSound()
    {
        return SoundEvents.ENTITY_COW_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_COW_DEATH;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableList.ENTITIES_COW;
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack)
    {
        if (stack != null && stack.getItem() == trumpmod.snatcher && !player.capabilities.isCreativeMode && !this.isChild())
        {
            player.playSound(SoundEvents.BLOCK_CLOTH_HIT, 1.0F, 1.0F);

            if (--stack.stackSize == 0)
            {
                player.setHeldItem(hand, new ItemStack(trumpmod.money, 3));
               
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(trumpmod.money)))
            {
                player.dropItem(new ItemStack(trumpmod.money), false);
            }

            return true;
        }
        else
        {
            return super.processInteract(player, hand, stack);
        }
    }

    public trump createChild(EntityAgeable ageable)
    {
        return new trump(this.worldObj);
    }

    public float getEyeHeight()
    {
        return this.isChild() ? this.height : 1.3F;
    }

	public boolean isVillager() {
		return false;
	}
    
}