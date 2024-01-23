package org.cristalixcore.cristalixone.Utils;

import org.bukkit.ChatColor;

public class ChatUtils {

    public static String formatChat(String playerName, String message) {
        return ChatColor.translateAlternateColorCodes('&', "&7" + playerName + " &7» &f" + message);
    }
}
