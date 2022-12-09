package pl.botprzemek.bpDuels.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.botprzemek.bpDuels.Game.GameManager;
import pl.botprzemek.bpDuels.Game.GameState;

public class ActivateCommand implements CommandExecutor {

    private GameManager gameManager;

    public ActivateCommand(GameManager gameManager) {

        this.gameManager = gameManager;

    }

    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {

        gameManager.setGameState(GameState.ACTIVE);

        return true;

    }
}
