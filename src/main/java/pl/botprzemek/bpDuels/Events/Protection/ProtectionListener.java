package pl.botprzemek.bpDuels.Events.Protection;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;
import pl.botprzemek.bpDuels.Game.GameManager;
import pl.botprzemek.bpDuels.Game.GameState;

public class ProtectionListener implements Listener {

    private GameManager gameManager;

    public ProtectionListener(GameManager gameManager) {

        this.gameManager = gameManager;

    }

    @EventHandler
    public void onPlayerFall(EntityDamageEvent event) {

        if (!(event.getEntity() instanceof Player player)) return;

        if (gameManager.getProtectionManager().canNegateDamage(event.getCause())) event.setCancelled(true);

        if (!gameManager.gameState.equals(GameState.ACTIVE)) event.setCancelled(true);

        if (gameManager.getLaunchPadManager().canNegateDamage(player)) return;

        event.setCancelled(true);

        gameManager.getLaunchPadManager().removeLaunchedPlayer(player);

    }

    @EventHandler
    public void onPlayerArrowHit(ProjectileHitEvent event) {

        if (event.getHitEntity() instanceof Player) event.setCancelled(true);

        Player player = (Player) event.getHitEntity();

        player.setVelocity(new Vector(0, 5, 0));

    }

}
