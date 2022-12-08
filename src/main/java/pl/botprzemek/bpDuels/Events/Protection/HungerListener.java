package pl.botprzemek.bpDuels.Events.Protection;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import pl.botprzemek.bpDuels.Game.GameManager;

public class HungerListener implements Listener {

    private GameManager gameManager;

    public HungerListener(GameManager gameManager) {

        this.gameManager = gameManager;

    }

    @EventHandler
    public void onHungerChange(FoodLevelChangeEvent event) {

        event.setCancelled(true);

    }

}
