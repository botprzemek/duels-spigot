package pl.botprzemek.bpDuels.Game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import pl.botprzemek.bpDuels.BpDuels;
import pl.botprzemek.bpDuels.Events.Block.BlockManager;
import pl.botprzemek.bpDuels.Events.LaunchPad.LaunchPadManager;
import pl.botprzemek.bpDuels.Game.Team.TeamManager;

public class GameManager {

    private BpDuels instance;

    private BlockManager blockManager;

    private LaunchPadManager launchPadManager;

    private TeamManager teamManager;

    public GameState gameState = GameState.LOBBY;

    public GameManager(BpDuels instance) {

        this.instance = instance;

        this.blockManager = new BlockManager();

        this.launchPadManager = new LaunchPadManager();

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

                teamManager.createTeam("Team");

                Bukkit.broadcastMessage("Created new team...");

                for (Player player : Bukkit.getOnlinePlayers()) {

                    teamManager.getTeam("Team").addEntry(player.getDisplayName());

                }

                break;

            case ACTIVE:

                if (teamManager == null || teamManager.getTeam("Team") == null) {

                    Bukkit.broadcastMessage("Teams not created yet...");

                    break;

                }

                Team team = teamManager.getTeam("Team");

                for (String playerName : team.getEntries()) {

                    Player player = Bukkit.getPlayer(playerName);

                    if (player != null && !(player.isOnline())) break;

                    player.sendMessage("Activated... " + playerName + " is in " + team.getDisplayName());

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

        return;

    }

    public GameManager getGameManager() {

        return this;

    }

    public BlockManager getBlockManager() {

        return blockManager;

    }

    public LaunchPadManager getLaunchPadManager() {

        return launchPadManager;

    }

    public TeamManager getTeamManager() {

        return teamManager;

    }

}
