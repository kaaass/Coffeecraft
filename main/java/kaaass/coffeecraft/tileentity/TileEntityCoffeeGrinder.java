package kaaass.coffeecraft.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import kaaass.coffeecraft.init.Crafting;
import kaaass.coffeecraft.init.Items;
import kaaass.coffeecraft.item.ItemCoffeeBean;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityCoffeeGrinder extends TileEntity implements IInventory {
	private ItemStack stack[] = new ItemStack[3];
	public int progressTime = 0;

	@Override
	public void updateEntity() {
		super.updateEntity();
		World world = this.worldObj;
		if (!world.isRemote) {
			ItemStack inputItem = getStackInSlot(0);
			ItemStack spice = getStackInSlot(1);
			ItemStack outputItem = getStackInSlot(2);
			// progress
			if (inputItem != null && world.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
				if (outputItem == null) {
					if((inputItem.getItem() == Items.coffeeBean && inputItem.getItemDamage() == 3) || (inputItem.getItem() == Item.getItemFromBlock(Block.getBlockById(35)) && inputItem.getItemDamage() != 15)){
						this.progressTime++;
					}
					if (this.progressTime == 600) {
						this.progressTime = 0;
						if(inputItem.getItem() == Items.coffeeBean && inputItem.getItemDamage() == 3){
							if(inputItem.stackSize >= 3){
								if(inputItem.stackSize == 3){
									inputItem = null;
								}else{
									inputItem.stackSize -= 3;
								}
								outputItem = new ItemStack(Items.coffeePowder, 1);
							}else{
								outputItem = new ItemStack(Items.mixedPowder, inputItem.stackSize);
								inputItem = null;
							}
						}else if(inputItem.getItem() == Item.getItemFromBlock(Block.getBlockById(35)) && inputItem.getItemDamage() == 0){
							if(inputItem.stackSize >= 5){
								if(inputItem.stackSize == 5){
									inputItem = null;
								}else{
									inputItem.stackSize -= 5;
								}
								outputItem = new ItemStack(Item.getItemById(287), 3 + world.rand.nextInt(8));
							}else{
								outputItem = new ItemStack(Items.mixedPowder, inputItem.stackSize);
								inputItem = null;
							}
						}else if(inputItem.getItem() == Item.getItemFromBlock(Block.getBlockById(35)) && inputItem.getItemDamage() == 3){
							if(inputItem.stackSize >= 3){
								if(inputItem.stackSize == 3){
									inputItem = null;
								}else{
									inputItem.stackSize -= 3;
								}
								outputItem = new ItemStack(Items.cocoaPowder, 2);
							}else{
								outputItem = new ItemStack(Items.mixedPowder, inputItem.stackSize);
								inputItem = null;
							}
						}else if(inputItem.getItem() == Item.getItemFromBlock(Block.getBlockById(35)) && inputItem.getItemDamage() != 15){
							if(inputItem.stackSize >= 2){
								if(inputItem.stackSize == 2){
									inputItem = null;
								}else{
									inputItem.stackSize -= 2;
								}
								outputItem = new ItemStack(Item.getItemById(351), 3 + world.rand.nextInt(13), 15 - inputItem.getItemDamage());
							}else{
								outputItem = new ItemStack(Items.mixedPowder, inputItem.stackSize);
								inputItem = null;
							}
						}
					}
				} else {
					if(allowProgress(inputItem, outputItem)){
						this.progressTime++;
					}
					if (this.progressTime == 600) {
						this.progressTime = 0;
						if(inputItem.getItem() == Items.coffeeBean && inputItem.getItemDamage() == 3){
							if(inputItem.stackSize >= 3){
								if(inputItem.stackSize == 3){
									inputItem = null;
								}else{
									inputItem.stackSize -= 3;
								}
								outputItem.stackSize++;
							}
						}else if(inputItem.getItem() == Item.getItemFromBlock(Block.getBlockById(35)) && inputItem.getItemDamage() == 0){
							if(inputItem.stackSize >= 5){
								if(inputItem.stackSize == 5){
									inputItem = null;
								}else{
									inputItem.stackSize -= 5;
								}
								outputItem.stackSize += 3 + world.rand.nextInt(8);
							}
						}else if(inputItem.getItem() == Item.getItemFromBlock(Block.getBlockById(35)) && inputItem.getItemDamage() == 3){
							if(inputItem.stackSize >= 3){
								if(inputItem.stackSize == 3){
									inputItem = null;
								}else{
									inputItem.stackSize -= 3;
								}
								outputItem.stackSize += 2;
							}
						}else if(inputItem.getItem() == Item.getItemFromBlock(Block.getBlockById(35)) && inputItem.getItemDamage() != 15){
							if(inputItem.stackSize >= 2){
								if(inputItem.stackSize == 2){
									inputItem = null;
								}else{
									inputItem.stackSize -= 2;
								}
								outputItem.stackSize += 3 + world.rand.nextInt(13);
							}
						}
					}
				}
				setInventorySlotContents(0, inputItem);
				setInventorySlotContents(2, outputItem);
			} else {
				this.progressTime = 0;
			}
		}
	}
	
	private boolean allowProgress(ItemStack input, ItemStack output){
		if(input.getItem() == Items.coffeeBean && input.getItemDamage() == 3){
			return output.getItem() == Items.coffeePowder;
		}else if(input.getItem() == Item.getItemFromBlock(Block.getBlockById(35)) && input.getItemDamage() == 0){
			return output.getItem() == Item.getItemById(287);
		}else if(input.getItem() == Item.getItemFromBlock(Block.getBlockById(35)) && input.getItemDamage() == 3){
			return output.getItem() == Items.cocoaPowder;
		}else if(input.getItem() == Item.getItemFromBlock(Block.getBlockById(35)) && input.getItemDamage() != 15){
			return output.getItem() == Item.getItemById(351) && input.getItemDamage() + output.getItemDamage() == 15;
		}else{
			return false;
		}
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		return null;
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return false;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return false;
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.stack[par1] != null) {
			ItemStack var3;
			if (this.stack[par1].stackSize <= par2) {
				var3 = this.stack[par1];
				this.stack[par1] = null;
				return var3;
			} else {
				var3 = this.stack[par1].splitStack(par2);
				if (this.stack[par1].stackSize == 0) {
					this.stack[par1] = null;
				}
				return var3;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return stack[var1];
	}

	@Override
	public int getSizeInventory() {
		return stack.length;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		stack[var1] = var2;
	}

	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList var2 = par1NBTTagCompound.getTagList("Items", 10);
		this.stack = new ItemStack[this.getSizeInventory()];
		for (int var3 = 0; var3 < var2.tagCount(); ++var3) {
			NBTTagCompound var4 = (NBTTagCompound) var2.getCompoundTagAt(var3);
			byte var5 = var4.getByte("Slot");
			if (var5 >= 0 && var5 < this.stack.length) {
				this.stack[var5] = ItemStack.loadItemStackFromNBT(var4);
			}
		}
		this.progressTime = par1NBTTagCompound.getShort("progressTime");
	}

	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("progressTime", (short) this.progressTime);
		NBTTagList var2 = new NBTTagList();
		for (int var3 = 0; var3 < this.stack.length; ++var3) {
			if (this.stack[var3] != null) {
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("Slot", (byte) var3);
				this.stack[var3].writeToNBT(var4);
				var2.appendTag(var4);
			}
		}
		par1NBTTagCompound.setTag("Items", var2);
	}

	public static int getItemTem(ItemStack stack) {
		if (stack == null) {
			return 0;
		} else {
			Item item = stack.getItem();
			if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
				Block block = Block.getBlockFromItem(item);
				if (block == Blocks.wooden_slab) {
					return 1;
				}

				if (block.getMaterial() == Material.wood) {
					return 5;
				}

				if (block == Blocks.coal_block) {
					return 500;
				}
				
				if (block == Blocks.ice) {
					return -100;
				}
			}
			if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD"))
				return 2;
			if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD"))
				return 2;
			if (item instanceof ItemHoe && ((ItemHoe) item).getToolMaterialName().equals("WOOD"))
				return 2;
			if (item == Item.getItemById(280))
				return 1;
			if (item == Item.getItemById(263))
				return 100;
			if (item == Item.getItemById(327))
				return 1500;
			if (item == Item.getItemFromBlock(Blocks.sapling))
				return 1;
			if (item == Item.getItemById(369))
				return 150;
			return (int)Math.floor(GameRegistry.getFuelValue(stack) / 16.0F);
		}
	}
}
