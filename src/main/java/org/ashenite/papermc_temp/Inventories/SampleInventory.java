package org.ashenite.papermc_temp.Inventories;

import org.ashenite.papermc_temp.PluginName;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class SampleInventory implements InventoryHolder {
	private final Inventory inventory;

	public SampleInventory(PluginName plugin) {
		this.inventory = plugin.getServer().createInventory(this, 9, net.kyori.adventure.text.Component.text("Sample Inventory"));
	}

	@Override
	public @NotNull Inventory getInventory() {
		return this.inventory;
	}
}
