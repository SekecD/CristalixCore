package org.cristalixcore.cristalixone.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.cristalixcore.cristalixone.Utils.ChatUtils;


public class ChatListener implements Listener {




    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String message = event.getMessage();

        String formattedMessage = ChatUtils.formatChat(playerName, message);

        event.setCancelled(true);

        player.getServer().broadcastMessage(formattedMessage);
    }
}
