package org.ashenite.papermc_temp.Commands;

import org.ashenite.papermc_temp.PluginName;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadConfig implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		PluginName.getPlugin().reloadConf();
		return true;
	}
}
