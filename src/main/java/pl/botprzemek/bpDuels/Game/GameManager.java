package pl.botprzemek.bpDuels.Game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import pl.botprzemek.bpDuels.BpDuels;
import pl.botprzemek.bpDuels.Config.ConfigManager;
import pl.botprzemek.bpDuels.Events.Block.BlockManager;
import pl.botprzemek.bpDuels.Events.LaunchPad.LaunchPadManager;
import pl.botprzemek.bpDuels.Events.Protection.ProtectionManager;
import pl.botprzemek.bpDuels.Game.Profile.ProfileManager;
import pl.botprzemek.bpDuels.Game.Spawn.SpawnManager;
import pl.botprzemek.bpDuels.Game.Team.TeamManager;

import java.util.Set;

public class GameManager {

    private BpDuels instance;

    private BlockManager blockManager;

    private LaunchPadManager launchPadManager;

    private ProtectionManager protectionManager;

    private TeamManager teamManager;

    private SpawnManager spawnManager;

    private ConfigManager configManager;

    private ProfileManager profileManager;

    public GameState gameState = GameState.LOBBY;

    public GameManager(BpDuels instance) {

        this.instance = instance;

        this.blockManager = new BlockManager();

        this.configManager = new ConfigManager(instance);

        configManager.loadConfigs();

        this.profileManager = new ProfileManager(this);

        profileManager.loadProfiles();

        this.launchPadManager = new LaunchPadManager();

        this.protectionManager = new ProtectionManager();

        this.spawnManager = new SpawnManager();

    }

    public void setGameState(GameState gameState) {

        this.gameState = gameState;

        switch(gameState) {

            case LOBBY:

                break;

            case STARTING:

                Bukkit.broadcastMessage("Starting...");

                if (this.teamManager == null) {

                    this.teamManager = new TeamManager();

                    Bukkit.broadcastMessage("Created team manager...");

                }

                Scoreboard scoreboard = teamManager.getScoreboard();

                if (scoreboard.getTeam("Team") != null) {

                    Team team = teamManager.getTeam("Team");

                    for (Player player : Bukkit.getOnlinePlayers()) {

                        String name = player.getDisplayName();

                        team.removeEntry(name);

                        team.addEntry(name);

                    }

                    Bukkit.broadcastMessage("Refreshed players...");

                    break;

                }

                Team team = teamManager.createTeam("Team");

                Bukkit.broadcastMessage("Created new team... " + team.getDisplayName());

                for (Player player : Bukkit.getOnlinePlayers()) {

                    team.addEntry(player.getDisplayName());

                    Bukkit.broadcastMessage("Added " + player.getDisplayName() + " to " + team.getDisplayName());

                }

                break;

            case ACTIVE:

                if (teamManager == null || teamManager.getTeam("Team") == null) {

                    Bukkit.broadcastMessage("Teams not created yet...");

                    break;

                }

                Team team1 = teamManager.getTeam("Team");

                Set<String> players = team1.getEntries();

                int iteration = 0;

                for (String playerName : players) {

                    Player player = Bukkit.getPlayer(playerName);

                    if (player != null && !(player.isOnline())) break;

                    player.sendMessage("Activated... " + playerName + " is in " + team1.getDisplayName());

                    spawnManager.prepareSpawn(player, iteration);

                    iteration++;

                }

                break;

            case DEATH_MATCH:

                break;

            case WON:

                break;

            case VOTING:

                break;

            case RESTARTING:

                break;

        }

    }

    public void cleanUp() {

        profileManager.saveProfiles();

        configManager.saveConfigs();

    }

    public BpDuels getInstanceManager() {

        return instance;

    }

    public BlockManager getBlockManager() {

        return blockManager;

    }

    public ConfigManager getConfigManager() {

        return configManager;

    }

    public LaunchPadManager getLaunchPadManager() {

        return launchPadManager;

    }

    public ProtectionManager getProtectionManager() {

        return protectionManager;

    }

    public TeamManager getTeamManager() {

        return teamManager;

    }

    public SpawnManager getSpawnManager() {

        return spawnManager;

    }

    public ProfileManager getProfileManager() {

        return profileManager;

    }

}
