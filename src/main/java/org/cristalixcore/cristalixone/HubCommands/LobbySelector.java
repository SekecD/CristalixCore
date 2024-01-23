package org.cristalixcore.cristalixone.HubCommands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;


public class LobbySelector implements CommandExecutor {

    private Location targetLocation;
    private final JavaPlugin plugin;

    public LobbySelector(JavaPlugin plugin) {
        this.plugin = plugin;
        loadLocation();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only for players");
            return true;
        }

        Player player = (Player) sender;
        targetLocation = player.getLocation();
        saveLocation();
        player.sendMessage("+");

        return true;
    }


    private void saveLocation() {
        FileConfiguration config = plugin.getConfig();

        if (targetLocation != null) {
            config.set("spawnLocation.world", targetLocation.getWorld().getName());
            config.set("spawnLocation.x", targetLocation.getX());
            config.set("spawnLocation.y", targetLocation.getY());
            config.set("spawnLocation.z", targetLocation.getZ());
            config.set("spawnLocation.yaw", targetLocation.getYaw());
            config.set("spawnLocation.pitch", targetLocation.getPitch());

            plugin.saveConfig();

        }
    }

    public void loadLocation() {
        FileConfiguration config = plugin.getConfig();

        if (config.contains("spawnlocation")) {
            String worldName = config.getString("spawnLocation.world");
            double x = config.getDouble("spawnLocation.x");
            double y = config.getDouble("spawnLocation.y");
            double z = config.getDouble("spawnLocation.z");
            float yaw = (float) config.getDouble("spawnLocation.yaw");
            float pitch = (float) config.getDouble("spawnLocation.pitch");

            targetLocation = new Location(Bukkit.getWorld(worldName), x, y, z, yaw, pitch);
        }
    }

    public Location getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(Location location) {
        this.targetLocation = location;
    }
}