package pl.botprzemek.bpDuels.Commands;

import pl.botprzemek.bpDuels.BpDuels;
import pl.botprzemek.bpDuels.Game.GameManager;

public class CommandsManager {

    public CommandsManager(BpDuels instance, GameManager gameManager){

        instance.getCommand("start").setExecutor(new StartCommand(gameManager));

        instance.getCommand("activate").setExecutor(new ActivateCommand(gameManager));

        instance.getCommand("class").setExecutor(new ClassCommand(gameManager));

        instance.getCommand("getclass").setExecutor(new GetClassCommand(gameManager));

    }

}
