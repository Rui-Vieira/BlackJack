package academy.mindswap;

public class BlackJack {
    private static final int MAX_POINTS = 21;
    private static boolean isGameOver;

    public static int getMaxPoints() {
        return MAX_POINTS;
    }

    public static int drawCard(){
        return (int) (Math.random() * (13-1+1)+1);
    }
    public static void printWinner(Players player) {
        System.out.printf("%s Won the game",player.getPlayerName());
    }

    public static void startGame(Players player, Players player2) {
        while (! isGameOver) {
            if(!turns(player)) {
                printWinner(player2);
                return;

            }
            if(!turns(player2)) {
                printWinner(player);
                return;
            }
            Players winner = winner(player,player2);

            if (winner != null){
                printWinner(winner);
                return;
            }
        }



    }

    private static Players winner( Players player,Players player2) {
        if(player.getPoints() == MAX_POINTS && player2.getPoints()== MAX_POINTS) {
            System.out.println("Draw!!!");
         return player2;
        }
        return player.getPoints() == MAX_POINTS ? player: player2.getPoints() == MAX_POINTS ? player2 : null;
    }

    public static boolean turns (Players player){
        int cardPoints = drawCard();
        player.increasePoints(cardPoints);
        System.out.printf("Player: %s draw %d and has %d points now !\n",player.getPlayerName(),cardPoints,player.getPoints());

        if( isBurst((player))) {
            System.out.printf("Player :%s get burst!!\n", player.getPlayerName());
            isGameOver=true;
            return false;
        }
        return true;
    }

    public static boolean isBurst(Players player) {
        ;
        return player.getPoints()> MAX_POINTS;}
    }

