package pl.botprzemek.bpDuels.Events;

import pl.botprzemek.bpDuels.BpDuels;
import pl.botprzemek.bpDuels.Events.Block.BlockListener;
import pl.botprzemek.bpDuels.Events.JoinQuit.JoinQuitListener;
import pl.botprzemek.bpDuels.Events.LaunchPad.LaunchPadListener;
import pl.botprzemek.bpDuels.Events.Protection.HungerListener;
import pl.botprzemek.bpDuels.Events.Protection.ProtectionListener;
import pl.botprzemek.bpDuels.Game.GameManager;

public class EventsManager {

    public EventsManager(BpDuels instance, GameManager gameManager) {

        instance.getServer().getPluginManager().registerEvents(new BlockListener(gameManager), instance);

        instance.getServer().getPluginManager().registerEvents(new LaunchPadListener(gameManager), instance);

        instance.getServer().getPluginManager().registerEvents(new ProtectionListener(gameManager), instance);

        instance.getServer().getPluginManager().registerEvents(new HungerListener(gameManager), instance);

        instance.getServer().getPluginManager().registerEvents(new JoinQuitListener(gameManager), instance);

    }

}
