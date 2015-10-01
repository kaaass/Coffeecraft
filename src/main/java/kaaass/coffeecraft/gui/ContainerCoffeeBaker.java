package kaaass.coffeecraft.gui;

import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeBaker;
import kaaass.coffeecraft.tileentity.TileEntityCoffeeGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCoffeeBaker extends Container {
	private TileEntityCoffeeBaker tile;
	private int lastProgressTime = 0;
	private int lastTemperature = 0;

	public ContainerCoffeeBaker(InventoryPlayer inventory, TileEntityCoffeeBaker tileEntityCoffeeBaker) {
		this.tile = tileEntityCoffeeBaker;
		this.addSlotToContainer(new Slot(tileEntityCoffeeBaker, 0, 56, 23));
		this.addSlotToContainer(new Slot(tileEntityCoffeeBaker, 1, 56, 47));
		this.addSlotToContainer(new Slot(tileEntityCoffeeBaker, 2, 116, 35));
		int var3;
		for (var3 = 0; var3 < 3; ++var3) {
			for (int var4 = 0; var4 < 9; ++var4) {
				this.addSlotToContainer(new Slot(inventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3) {
			this.addSlotToContainer(new Slot(inventory, var3, 8 + var3 * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	@Override
	public void addCraftingToCrafters(ICrafting crafting) {
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.tile.progressTime);
		crafting.sendProgressBarUpdate(this, 1, this.tile.temperature);
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int index, int value) {
		if (index == 0) {
			this.tile.progressTime = value;
		}
		if (index == 1) {
			this.tile.temperature = value;
		}
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		Iterator var1 = this.crafters.iterator();
		while (var1.hasNext()) {
			ICrafting var2 = (ICrafting) var1.next();

			if (this.lastProgressTime != this.tile.progressTime) {
				var2.sendProgressBarUpdate(this, 0, this.tile.progressTime);
			}

			if (this.lastTemperature != this.tile.temperature) {
				var2.sendProgressBarUpdate(this, 1, this.tile.temperature);
			}
		}
		this.lastProgressTime = this.tile.progressTime;
		this.lastTemperature = this.tile.temperature;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack var3 = null;
		Slot var4 = (Slot) this.inventorySlots.get(par2);
		if (var4 != null && var4.getHasStack()) {
			ItemStack var5 = var4.getStack();
			var3 = var5.copy();
			if (par2 >= 0 && par2 <= 2) {
				if (!this.mergeItemStack(var5, 3, 30, false)) {
					return null;
				}
				var4.onSlotChange(var5, var3);
			} else if (par2 > 3 && par2 < 30) {
				if (!this.mergeItemStack(var5, 30, 39, false)) {
					return null;
				}
			} else if (par2 >= 30 && par2 < 39) {
				if (!this.mergeItemStack(var5, 3, 30, false)) {
					return null;
				}
			}
			if (var5.stackSize == 0) {
				var4.putStack((ItemStack) null);
			} else {
				var4.onSlotChanged();
			}
			if (var5.stackSize == var3.stackSize) {
				return null;
			}
			var4.onPickupFromSlot(par1EntityPlayer, var5);
		}
		return var3;
	}
}
