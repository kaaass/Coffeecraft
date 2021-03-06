package kaaass.coffeecraft.gui;

import java.util.Iterator;

import kaaass.coffeecraft.tileentity.TileEntityExtractingMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerExtractingMachine extends Container {
	private TileEntityExtractingMachine tile;
	private int lastProgressTime = 0;

	public ContainerExtractingMachine(InventoryPlayer inventory, TileEntityExtractingMachine tile) {
		this.tile = tile;
		this.addSlotToContainer(new Slot(tile, 0, 37, 35));
		this.addSlotToContainer(new Slot(tile, 1, 59, 35));
		this.addSlotToContainer(new Slot(tile, 2, 119, 35));
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
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int index, int value) {
		if (index == 0) {
			this.tile.progressTime = value;
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
		}
		this.lastProgressTime = this.tile.progressTime;
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
