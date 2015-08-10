package kaaass.coffeecraft.eventhandler;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import kaaass.coffeecraft.block.BlockCoffeeTreeFruit;
import kaaass.coffeecraft.block.BlockCoffeeTreeSapling;
import kaaass.coffeecraft.init.Blocks;

public class EventBonemeal {
	@SubscribeEvent
    public void onBonemeal(BonemealEvent event){
		EntityPlayer player = event.entityPlayer;
	    World world = event.world;
	    Random rand = world.rand;
	    Block block = event.block;
	    int posX = event.x;
	    int posY = event.y;
	    int posZ = event.z;
	    int metadata = world.getBlockMetadata(posX, posY, posZ);
	    if (block == Blocks.coffeeTreeFruitBlock){
			if (!world.isRemote){
				((BlockCoffeeTreeFruit)block).dropBlockAsItem(world, posX, posY, posZ);
			}
			event.setResult(Result.ALLOW);
		}
	    if (block == Blocks.coffeeTreeLeaveBlock){
	    	if (!world.isAirBlock(posX, posY - 1, posZ)){
				event.setResult(Result.DENY);
			}else if (!world.isRemote){
				if(rand.nextInt(22) == 0){
					world.setBlock(posX, posY - 1, posZ, Blocks.coffeeTreeFruitBlock);
					world.setBlockMetadataWithNotify(posX, posY - 1, posZ, 1 << 2 | rand.nextInt(4), 2);
				}
				event.setResult(Result.ALLOW);
			}
		}
	    if (block == Blocks.coffeeTreeSaplingBlock){
			if (!world.isRemote){
				if(rand.nextInt(14) == 0){
					((BlockCoffeeTreeSapling)Blocks.coffeeTreeSaplingBlock).treeGene(world, posX, posY, posZ, rand);
				}
			}
			event.setResult(Result.ALLOW);
		}
    }
}
