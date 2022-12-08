package pl.botprzemek.bpDuels.Events.Block;

import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import pl.botprzemek.bpDuels.Game.GameManager;

public class BlockListener implements Listener {

    private GameManager gameManager;

    public BlockListener(GameManager gameManager) {

        this.gameManager = gameManager;

    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {

        Block block = event.getBlock();

        Player player = event.getPlayer();

        if (!player.getGameMode().equals(GameMode.SURVIVAL)) return;

        if (gameManager.getBlockManager().canBreak(block)) event.setCancelled(true);

    }

}
