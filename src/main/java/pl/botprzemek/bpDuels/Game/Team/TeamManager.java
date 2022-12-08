package pl.botprzemek.bpDuels.Game.Team;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TeamManager {

    private Scoreboard scoreboard;

    public TeamManager() {

        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

    }

    public Scoreboard getScoreboard() {

        return scoreboard;

    }

    public Team createTeam(String name) {

        return scoreboard.registerNewTeam(name);

    }

    public Team getTeam(String name) {

        return scoreboard.getTeam(name);

    }

}
