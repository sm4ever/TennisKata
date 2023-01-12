package test;

import main.Player;
import main.TennisGame;
import main.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TennisGameTest {

    TennisGame tennisGame;
    Player player1;
    Player player2;

    @BeforeEach
    void setUp() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        tennisGame = new TennisGame(player1, player2);
    }

    @Test
    void getGameScoreTestDeuceZero() {
        assertEquals(tennisGame.getGameScore(), "Player 1 : Love, Player 2 : Love");
    }

    @Test
    void getGameScoreTestPlayer1IsLeading() {
        player1.setScore(3);
        player2.setScore(0);
        assertEquals(tennisGame.getGameScore(), "Player 1 : 40, Player 2 : Love");
    }

    @Test
    void getGameScoreTestPlayer1Wins() {
        player1.setScore(5);
        player2.setScore(3);
        assertEquals(tennisGame.getGameScore(), "Player " + player1.getName() +" "+ Constants.WINS);
    }

    @Test
    void getGameScoreTestPlayer2IsLeading() {
        player1.setScore(1);
        player2.setScore(3);
        assertEquals(tennisGame.getGameScore(), "Player 1 : 15, Player 2 : 40");
    }

    @Test
    void getGameScoreTestDeuce() {
        player1.setScore(3);
        player2.setScore(3);
        assertEquals(tennisGame.getGameScore(), Constants.DEUCE);
    }

    @Test
    void getGameScoreTestPlayer1Adv() {
        player1.setScore(4);
        player2.setScore(3);
        assertEquals(tennisGame.getGameScore(), Constants.ADVANTAGE + " " + player1.getName());
    }

    @Test
    void getGameScoreTestDeuceAfterAdv() {
        player1.setScore(4);
        player2.setScore(4);
        assertEquals(tennisGame.getGameScore(), Constants.DEUCE);
    }

    @Test
    void getGameScoreTestPlayer2Adv() {
        player1.setScore(4);
        player2.setScore(5);
        assertEquals(tennisGame.getGameScore(), Constants.ADVANTAGE + " " + player2.getName());
    }

    @Test
    void getGameScoreTestPlayer2Wins() {
        player1.setScore(4);
        player2.setScore(6);
        assertEquals(tennisGame.getGameScore(), "Player " + player2.getName() +" "+ Constants.WINS);
    }

    @Test
    void isDeuceTestFalse() {
        player1.setScore(1);
        player2.setScore(4);
        assertFalse(tennisGame.isDeuce());
    }

    @Test
    void isDeuceTestTrue() {
        player1.setScore(3);
        player2.setScore(3);
        assertTrue(tennisGame.isDeuce());
    }

    @Test
    void isAdvantagePlayer1() {
        player1.setScore(4);
        player2.setScore(3);
        assertEquals(tennisGame.hasAdvantage(), Constants.ADVANTAGE + " " +player1.getName());
    }

    @Test
    void isAdvantagePlayer2() {
        player1.setScore(4);
        player2.setScore(5);
        assertEquals(tennisGame.hasAdvantage(), Constants.ADVANTAGE + " " +player2.getName());
    }

    @Test
    void isAdvantageFalse() {
        player1.setScore(2);
        player2.setScore(2);
        assertNotEquals(tennisGame.hasAdvantage(), player1.getName());
        assertNotEquals(tennisGame.hasAdvantage(), player2.getName());
    }


}