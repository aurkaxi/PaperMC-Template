package org.ashenite.papermc_temp.Listeners;

import org.ashenite.papermc_temp.Inventories.SampleInventory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class SampleListener implements Listener {
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Inventory inventory = event.getClickedInventory();
		if (inventory == null || !(inventory.getHolder() instanceof SampleInventory)) {
			return;
		}
		event.setCancelled(true);
	}
}
