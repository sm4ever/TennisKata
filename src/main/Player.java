package main;

public class Player {
    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
