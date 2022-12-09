package pl.botprzemek.bpDuels.Events.JoinQuit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.botprzemek.bpDuels.Game.GameManager;
import pl.botprzemek.bpDuels.Game.Profile.Profile;
import pl.botprzemek.bpDuels.Game.Profile.ProfileManager;

public class JoinQuitListener implements Listener {

    private GameManager gameManager;

    private ProfileManager profileManager;

    public JoinQuitListener(GameManager gameManager) {

        this.gameManager = gameManager;

        this.profileManager = gameManager.getProfileManager();

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        Profile profile = profileManager.getProfile(player);

        if (profile == null) profile = profileManager.createProfile(player);

        if (profile.getClasss() == null) player.sendMessage("You have not selected class");

        player.sendMessage("Your class is " + profile.getClasss().getClassName());

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();

        Profile profile = profileManager.getProfile(player);

    }

}
