package algorithm.game.tictactoe;

import java.util.List;

public abstract class Players {
    private int score;
    List<Integer> steps;

    public Players(int score, List<Integer> steps) {
        this.score = score;
        this.steps = steps;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Integer> getSteps() {
        return steps;
    }

    public void setSteps(List<Integer> steps) {
        this.steps = steps;
    }
}
