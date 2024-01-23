package org.cristalixcore.cristalixone.HubCommands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class gmc implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("p");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("gmc")) {
            if (args.length > 0 && args[0].equalsIgnoreCase("off")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fВаш игровой режим был изменен на &dSURVIVAL"));
            } else {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fВаш игровой режим был изменен на &cCREATIVE"));
            }
        }
        return true;
    }
}
