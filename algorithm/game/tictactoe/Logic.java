package algorithm.game.tictactoe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logic {
    private int move = 0;
    private final int totalStep = 9;
    private Map<Integer, Players> players = new HashMap<>();

    public Logic() {
        players.put(0, new PlayerA(0, new ArrayList<>()));
        players.put(1, new PlayerB(0, new ArrayList<>()));
    }

    public void move(int coordinate) {
        while (move < totalStep) {
            int player = move % 2;

            for (Field f : Field.values()) {
                if (
                        players.get(player).getSteps().contains(f.getX())
                                && players.get(player).getSteps().contains(f.getY())
                                && players.get(player).getSteps().contains(f.getZ())
                ) {
                    System.out.printf(
                            "The winner is %s score is %s ",
                            players.get(player).getClass().getName(), players.get(player).getScore()
                    );
                }
            }
            move++;
        }
    }

    private boolean validate(String ask) {
        try {
            int convertAskToInt = Integer.parseInt(ask);
            if (convertAskToInt < 1 || convertAskToInt > totalStep) {
                throw new IllegalArgumentException("A number should be by 1 ... " + totalStep);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Cannot to convert the string into int, please try again" + e.getMessage());
        }
        return true;
    }

    public void countMove() {
        move++;
    }

    private boolean checkMove(int coordinate) {
        return true;
    }

    public void clean() {

    }
}