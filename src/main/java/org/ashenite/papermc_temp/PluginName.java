package org.ashenite.papermc_temp;

import org.ashenite.papermc_temp.Commands.SampleCommand;
import org.ashenite.papermc_temp.Listeners.SampleListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PluginName extends JavaPlugin {

	private static PluginName plugin;

	@Override
	public void onEnable() {
		plugin = this;

		// Register Commands
		Objects.requireNonNull(getCommand("sample")).setExecutor(new SampleCommand());

		// Register Listeners
		getServer().getPluginManager().registerEvents(new SampleListener(), this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public static PluginName getPlugin() {
		return plugin;
	}
}
