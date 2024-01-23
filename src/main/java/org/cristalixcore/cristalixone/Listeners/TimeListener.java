package org.cristalixcore.cristalixone.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.cristalixcore.cristalixone.CristalixOne;


public class TimeListener implements Listener {

    private final CristalixOne plugin;


    public TimeListener(CristalixOne plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);

        fixTimeOnWorldLoad();

    }

    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {
        World world = event.getWorld();
        event.getWorld().setTime(6000);
        world.setStorm(false);
        world.setThundering(false);

    }

    private void fixTimeOnWorldLoad() {
        for (World world : plugin.getServer().getWorlds()) {
            world.setTime(6000);
        }
    }
}
