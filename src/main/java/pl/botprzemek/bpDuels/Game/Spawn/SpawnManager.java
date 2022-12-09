package pl.botprzemek.bpDuels.Game.Spawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SpawnManager {

    private List<Location> blockLocations = new ArrayList<>();

    public SpawnManager() {

        blockLocations.add(new Location(Bukkit.getWorld("world"), 0.5, 0.0, -0.5, 90, 0));
        blockLocations.add(new Location(Bukkit.getWorld("world"), 0.5, 0.0, 0.5, 90, 0));
        blockLocations.add(new Location(Bukkit.getWorld("world"), 0.5, 0.0, 1.5, 90, 0));

    }

    public void prepareSpawn(Player player, int iteration) {

        Location blockLocation = blockLocations.get(iteration);

        if (blockLocation.getBlock().getType().equals(Material.AIR)) {

            player.teleport(blockLocations.get(iteration));

            return;

        }

        int i = 1;

        for (Location validBlockLocation : blockLocations) {

            if (!validBlockLocation.getBlock().getType().equals(Material.AIR)) {

                player.teleport(blockLocations.get(iteration+i));

                return;

            }

        }

    }


}
