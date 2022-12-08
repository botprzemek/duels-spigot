package pl.botprzemek.bpDuels.Events.Block;

import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import pl.botprzemek.bpDuels.Game.GameManager;
import pl.botprzemek.bpDuels.Game.GameState;

public class BlockListener implements Listener {

    private GameManager gameManager;

    public BlockListener(GameManager gameManager) {

        this.gameManager = gameManager;

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Block block = event.getBlock();

        Player player = event.getPlayer();

        if (!player.getGameMode().equals(GameMode.SURVIVAL)) return;

        if (!gameManager.gameState.equals(GameState.ACTIVE)) event.setCancelled(true);

        if (gameManager.getBlockManager().canBreak(block)) event.setCancelled(true);

    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        Player player = event.getPlayer();

        if (!player.getGameMode().equals(GameMode.SURVIVAL)) return;

        if (!gameManager.gameState.equals(GameState.ACTIVE)) event.setCancelled(true);

    }

}
