package org.cristalixcore.cristalixone.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.cristalixcore.cristalixone.Configs.PlayerDataConfig;
import org.cristalixcore.cristalixone.HubCommands.LobbySelector;

import java.io.File;

public class SelectorListener implements Listener {

    private LobbySelector lobbySelector;
    private PlayerDataConfig playerDataConfig;

    public SelectorListener(LobbySelector lobbySelector, PlayerDataConfig playerDataConfig) {
        this.lobbySelector = lobbySelector;
        this.playerDataConfig = playerDataConfig;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (lobbySelector != null) {
            restoreLocation(player);
            Location targetLocation = lobbySelector.getTargetLocation();

            if (targetLocation != null) {
                player.teleport(targetLocation);
            }
        }
    }

    private void restoreLocation(Player player) {
        if (lobbySelector != null) {
            File configFile = new File(Bukkit.getServer().getPluginManager().getPlugin("cristalixOne").getDataFolder(), "config.yml");
            FileConfiguration config = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(configFile);

            if (config.contains("spawnLocation")) {
                String worldName = config.getString("spawnLocation.world");
                double x = config.getDouble("spawnLocation.x");
                double y = config.getDouble("spawnLocation.y");
                double z = config.getDouble("spawnLocation.z");
                float yaw = (float) config.getDouble("spawnLocation.yaw");
                float pitch = (float) config.getDouble("spawnLocation.pitch");

                Location location = new Location(Bukkit.getWorld(worldName), x, y, z, yaw, pitch);
                lobbySelector.setTargetLocation(location);
            }
        }
    }
}