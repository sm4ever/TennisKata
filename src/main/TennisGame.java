package main;

import main.utils.Constants;

public class TennisGame {
    Player player1;
    Player player2;

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getGameScore() {
        if (getWinner() != null) return "Player " + getWinner().getName() +" " + Constants.WINS;
        if (isDeuce()) return Constants.DEUCE;
        if (!hasAdvantage().isEmpty()) return hasAdvantage();
        else return player1.getName() + " : " + getPointScore(player1) + ", " + player2.getName() + " : " +
                getPointScore(player2);
    }


    public Player getWinner() {
        if ((player1.getScore() > 3 && player1.getScore() >= player2.getScore() + 2))
            return player1;
        if ((player2.getScore() > 3 && player2.getScore() >= player1.getScore() + 2))
            return player2;
        return null;
    }

    public boolean isDeuce() {
        return player1.getScore() == player2.getScore() && player1.getScore() > 2;
    }

    public String hasAdvantage() {
        if ((player1.getScore() >= 3 && (player1.getScore() - player2.getScore() == 1)))
            return Constants.ADVANTAGE + " " + player1.getName();
        if ((player2.getScore() >= 3 && player2.getScore() - player1.getScore() == 1))
            return Constants.ADVANTAGE + " " + player2.getName();
        else return "";
    }

    public String getPointScore(Player player) {
        int score = player.getScore();
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> "ERROR";
        };
    }
}
