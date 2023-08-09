package org.ashenite.papermc_temp.Commands;

import org.ashenite.papermc_temp.Inventories.SampleInventory;
import org.ashenite.papermc_temp.PluginName;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SampleCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return true;
		}
		Player player = (Player) sender;
		PluginName myPlugin = PluginName.getPlugin();
		SampleInventory myInventory = new SampleInventory(myPlugin);
		player.openInventory(myInventory.getInventory());
		
		return true;
	}
}
