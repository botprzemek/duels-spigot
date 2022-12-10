package pl.botprzemek.bpDuels.Game.Profile;

import org.bukkit.entity.Player;
import pl.botprzemek.bpDuels.BpDuels;
import pl.botprzemek.bpDuels.Config.ProfileConfig;
import pl.botprzemek.bpDuels.Game.Class.Classs;
import pl.botprzemek.bpDuels.Game.GameManager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileManager {

    private GameManager gameManager;

    private BpDuels instance;

    private ProfileConfig profileConfig;

    private Map<UUID, Profile> profiles = new HashMap<>();

    public ProfileManager(GameManager gameManager) {

        this.gameManager = gameManager;

        this.instance = gameManager.getInstanceManager();

        this.profileConfig = gameManager.getConfigManager().getProfileConfig();

    }

    public Profile createProfile(Player player) {

        Profile profile = new Profile(null);

        UUID playerUUID = player.getUniqueId();

        profiles.put(playerUUID, profile);

        for (UUID playerUUID1 : profiles.keySet()) {

            instance.getLogger().info(playerUUID1.toString());

        }

        return profile;

    }

    public void loadProfiles() {

        for (String name : profileConfig.getSection("")) {

            UUID playerUUID = UUID.fromString(name);

            Classs classs = profileConfig.getClass(playerUUID);

            Profile profile = new Profile(classs);

            profiles.put(playerUUID, profile);

        }

    }

    public void saveProfiles() {

        for (UUID playerUUID : profiles.keySet()) {

            Profile profile = profiles.get(playerUUID);

            instance.getLogger().info(profiles.get(playerUUID).toString() + ", " + profile.getClasss().getClassName());

            profileConfig.setClass(playerUUID, profile.getClasss());

        }

    }

    public Profile getProfile(Player player) {

        UUID playerUUID = player.getUniqueId();

        return profiles.get(playerUUID);

    }

}
