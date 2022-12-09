package pl.botprzemek.bpDuels.Events.LaunchPad;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class LaunchPadManager {

    private Set<Block> launchPads = new HashSet<>();

    private Set<Player> launchedPlayers = new HashSet<>();

    public LaunchPadManager() {

        Location loc = new Location(Bukkit.getWorld("world"), 25.0, 62.0, -14.0);

        launchPads.add(loc.getBlock());

    }

    public boolean canLaunch(Block block) {

        return launchPads.contains(block);

    }

    public void addLaunchedPlayer(Player player) {

        launchedPlayers.add(player);

    }

    public void removeLaunchedPlayer(Player player) {

        launchedPlayers.remove(player);

    }

    public boolean canNegateDamage(Player player) {

        return !launchedPlayers.contains(player);

    }

}
