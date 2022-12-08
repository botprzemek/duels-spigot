package pl.botprzemek.bpDuels.Events.LaunchPad;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;
import pl.botprzemek.bpDuels.Game.GameManager;

public class LaunchPadListener implements Listener {

    private GameManager gameManager;

    public LaunchPadListener(GameManager gameManager) {

        this.gameManager = gameManager;

    }

    @EventHandler
    public void onPlayerStep(PlayerMoveEvent event) {

        Location location = event.getPlayer().getLocation();

        location.setY(location.getY()-1);

        Block block = location.getBlock();

        if (!gameManager.getLaunchPadManager().canLaunch(block)) return;

        Player player = event.getPlayer();

        gameManager.getLaunchPadManager().addLaunchedPlayer(player);

        Vector vector = new Vector(0.0, 1.0, 0.0);

        player.setVelocity(vector);

    }

}
