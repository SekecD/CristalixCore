package org.cristalixcore.cristalixone.HubCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Helps implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("cmd")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &f/core stats - посмотреть общую статистику"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &f/core sync - проверить синхронизацию"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &f/core api - посмотреть, подключена ли API"));
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fCristalixCore + &bAPI &f2.1"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fВерсия CC + API: &cNone"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fКоманды: /core cmd"));
        }
        return true;
    }
}