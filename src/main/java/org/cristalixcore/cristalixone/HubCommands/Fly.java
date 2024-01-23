package org.cristalixcore.cristalixone.HubCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Fly implements CommandExecutor {

    private String prefix = ChatColor.GRAY + "[" + ChatColor.RED + "!" + ChatColor.GRAY + "] " + ChatColor.WHITE;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;

        if (args.length == 0) {
            toggleFlight(player);
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("on")) {
                enableFlight(player);
            } else if (args[0].equalsIgnoreCase("off")) {
                disableFlight(player);
            } else {
                player.sendMessage(prefix + "Используй /fly on " + ChatColor.GRAY + "| " + ChatColor.WHITE + "/fly off");
            }
        } else {
            player.sendMessage(prefix + "Ошибка");
        }

        return true;
    }

    public void toggleFlight(Player player) {
        if (player.getAllowFlight()) {
            disableFlight(player);
        } else {
            enableFlight(player);
        }
    }
    public void enableFlight(Player player) {
        player.setAllowFlight(true);
        player.sendMessage(prefix + "Режим полета включен");
    }

    public void disableFlight(Player player) {
        player.setAllowFlight(false);
        player.setFlying(false);
        player.sendMessage(prefix + "Режим полета выключен!");
    }
}
