package org.cristalixcore.cristalixone;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.cristalixcore.cristalixone.Configs.PlayerDataConfig;
import org.cristalixcore.cristalixone.HubCommands.*;
import org.cristalixcore.cristalixone.Listeners.*;


public final class CristalixOne extends JavaPlugin implements Listener {
    private LobbySelector lobbySelector;

    private PlayerDataConfig playerDataConfig;

    private TimeListener timeListener;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("CristalixCore");

        playerDataConfig = new PlayerDataConfig(this);

        timeListener = new TimeListener(this);

        lobbySelector = new LobbySelector(this);


        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
        getServer().getPluginManager().registerEvents(new SelectorListener(lobbySelector, playerDataConfig), this);

        getCommand("fly").setExecutor(new Fly());
        getCommand("lobbyselector").setExecutor(lobbySelector);
        getCommand("gamemode").setExecutor(new gamemodeCancel());
        getCommand("gmc").setExecutor(new gmc());
        getCommand("core").setExecutor(new Helps());


        reloadConfig();
        disableMonsterSpawning();
    }

    public void disableMonsterSpawning(){
        for (World world : getServer().getWorlds()) {
            EntityListner.disableMonsterSpawning(world);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        Player player = event.getPlayer();
        player.setFallDistance(0);

        player.setFoodLevel(20);
        player.setSaturation(20);

        player.setGameMode(GameMode.ADVENTURE);

        if (playerDataConfig.isFirstTimeJoin(player)) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fДобро пожаловать"));
            playerDataConfig.savePlayerFirstJoin(player);
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fС возвращением на сервер!"));
        }

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }


    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            event.setCancelled(true);
        }
    }


    public void onDisable() {
        for (Player player : getServer().getOnlinePlayers()) {
        }

    }
}