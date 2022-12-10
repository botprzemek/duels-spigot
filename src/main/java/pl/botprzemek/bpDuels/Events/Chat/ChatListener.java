package pl.botprzemek.bpDuels.Events.Chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import pl.botprzemek.bpDuels.Game.GameManager;
import pl.botprzemek.bpDuels.Game.Profile.Profile;
import pl.botprzemek.bpDuels.Game.Profile.ProfileManager;

public class ChatListener implements Listener {

    private GameManager gameManager;

    private ProfileManager profileManager;

    public ChatListener(GameManager gameManager) {

        this.gameManager = gameManager;

        this.profileManager = gameManager.getProfileManager();

    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {

        String originalMessage = event.getMessage();

        Player player = event.getPlayer();

        Profile profile = profileManager.getProfile(player);

        String prefix;

        if (profile.getClasss() == null) prefix = "[Classless] " + player.getDisplayName() + " >> ";

        else prefix = "[" + profile.getClasss().getClassName() + "] " + player.getDisplayName() + " >> ";

        event.setFormat(prefix + originalMessage);

    }
}
