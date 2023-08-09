package org.ashenite.papermc_temp;

import org.ashenite.papermc_temp.Commands.ReloadConfig;
import org.ashenite.papermc_temp.Commands.SampleCommand;
import org.ashenite.papermc_temp.Listeners.SampleListener;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class PluginName extends JavaPlugin {

	// For getting the plugin instance from other classes
	private static PluginName plugin;

	private FileConfiguration customConfig;

	@Override
	public void onEnable() {
		plugin = this;
		createCustomConfig();

		// Register Commands
		Objects.requireNonNull(getCommand("sample")).setExecutor(new SampleCommand());
		Objects.requireNonNull(getCommand("reloadconf")).setExecutor(new ReloadConfig());

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

	public FileConfiguration getCustomConfig() {
		return this.customConfig;
	}

	private void createCustomConfig() {
		// Custom Config
		File configFile = new File(getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			boolean res = configFile.getParentFile().mkdirs();
			if (!res) {
				getLogger().warning("Could not create config.yml directory!");
			}
			saveResource("config.yml", false);
		}
		customConfig = new YamlConfiguration();
		try {
			customConfig.load(configFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void reloadConf() {
		File configFile = new File(getDataFolder(), "config.yml");
		customConfig = new YamlConfiguration();
		try {
			customConfig.load(configFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		System.out.println("Reloaded " + this.getName() + "'s Configurations!");
	}
}
