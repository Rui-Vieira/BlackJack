package academy.mindswap;

public class Players {
    private  String playerName;
    private int points;

    public Players(String namePlayer) {
        this.playerName = namePlayer;
        points =0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPoints() {
        return points;
    }
    public void increasePoints(int points){this.points+=points;}
}

