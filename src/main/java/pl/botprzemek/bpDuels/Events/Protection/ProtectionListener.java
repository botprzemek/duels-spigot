package pl.botprzemek.bpDuels.Events.Protection;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import pl.botprzemek.bpDuels.Game.GameManager;
import pl.botprzemek.bpDuels.Game.GameState;

public class ProtectionListener implements Listener {

    private GameManager gameManager;

    public ProtectionListener(GameManager gameManager) {

        this.gameManager = gameManager;

    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {

        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();

        switch (event.getCause()) {

            case FALL:

                if (!gameManager.gameState.equals(GameState.ACTIVE)) event.setCancelled(true);

                if (gameManager.getLaunchPadManager().canNegateDamage(player)) return;

                event.setCancelled(true);

                gameManager.getLaunchPadManager().removeLaunchedPlayer(player);

                break;

            case ENTITY_ATTACK:

                if (!gameManager.gameState.equals(GameState.ACTIVE)) event.setCancelled(true);

                break;

            default:

                break;

        }

    }

}
