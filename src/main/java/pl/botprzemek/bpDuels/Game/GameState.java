package pl.botprzemek.bpDuels.Game;

public enum GameState {

    LOBBY(0),
    VOTING(0),
    STARTING(0),
    ACTIVE(0),
    DEATH_MATCH(0),
    WON(0),
    RESTARTING(0);

    private int time;

    GameState(int time) {

        this.time = time;

    }

    public int getTime() {

        return time;

    }

}
