package org.cristalixcore.cristalixone.Listeners;


import org.bukkit.World;

public class EntityListner {

    public static void disableMonsterSpawning(World world) {
        world.setMonsterSpawnLimit(0);
        world.setAnimalSpawnLimit(0);
    }


}
