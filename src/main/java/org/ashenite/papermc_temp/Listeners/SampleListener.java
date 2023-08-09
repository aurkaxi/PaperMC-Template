package org.ashenite.papermc_temp.Listeners;

import org.ashenite.papermc_temp.Inventories.SampleInventory;
import org.ashenite.papermc_temp.PluginName;
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
		
		String msg = PluginName.getPlugin().getCustomConfig().getString("sample_message");
		if (msg == null) {
			msg = "Sample Message";
		}
		event.getWhoClicked().sendMessage(msg);
	}
}
