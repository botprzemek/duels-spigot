package pl.botprzemek.bpDuels.Commands;

import pl.botprzemek.bpDuels.BpDuels;
import pl.botprzemek.bpDuels.Game.GameManager;

public class CommandsManager {

    public CommandsManager(BpDuels instance, GameManager gameManager){

        instance.getCommand("start").setExecutor(new StartCommand(gameManager));

        instance.getCommand("active").setExecutor(new ActiveCommand(gameManager));

    }

}
