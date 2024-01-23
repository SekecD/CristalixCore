package org.cristalixcore.cristalixone.HubCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class gamemodeCancel implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("p");
            return true;
        }

        Player player = (Player) sender;

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fИспользуйте /gmc"));
        return true;
    }
}
