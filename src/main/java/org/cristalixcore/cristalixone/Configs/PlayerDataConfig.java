package org.cristalixcore.cristalixone.Configs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.cristalixcore.cristalixone.CristalixOne;

import java.io.File;
import java.io.IOException;

public class PlayerDataConfig {
    private CristalixOne plugin;
    private File configFile;
    private FileConfiguration config;

    public PlayerDataConfig(CristalixOne plugin) {
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "playerData.yml");
        this.config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void savePlayerFirstJoin(Player player) {
        config.set(player.getUniqueId().toString() + ".firstjoin", true);
        saveConfig();
    }

    public boolean isFirstTimeJoin(Player player) {
        return !config.getBoolean(player.getUniqueId().toString() + ".firstjoin", false);
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
