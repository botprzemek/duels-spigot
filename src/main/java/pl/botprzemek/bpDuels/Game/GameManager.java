package pl.botprzemek.bpDuels.Game;

import org.bukkit.Bukkit;
import pl.botprzemek.bpDuels.Events.Block.BlockManager;
import pl.botprzemek.bpDuels.BpDuels;
import pl.botprzemek.bpDuels.Events.LaunchPad.LaunchPadManager;

public class GameManager {

    private BpDuels instance;

    private BlockManager blockManager;

    private LaunchPadManager launchPadManager;

    public GameState gameState = GameState.LOBBY;

    public GameManager(BpDuels instance) {

        this.instance = instance;

        this.blockManager = new BlockManager();

        this.launchPadManager = new LaunchPadManager();

    }

    public void setGameState(GameState gameState) {

        this.gameState = gameState;

        switch(gameState) {

            case LOBBY:
                break;

            case STARTING:
                Bukkit.broadcastMessage("Starting...");
                break;

            case ACTIVE:
                break;

            case DEATH_MATCH:
                break;

            case WON:
                break;

            case VOTING:
                break;

            case RESTARTING:
                break;

        }

    }

    public void cleanUp() {

        return;

    }

    public GameManager getGameManager() {

        return this;

    }

    public BlockManager getBlockManager() {

        return blockManager;

    }

    public LaunchPadManager getLaunchPadManager() {

        return launchPadManager;

    }

}
