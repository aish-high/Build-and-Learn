package LLD.TicTacToe.observer;

import LLD.TicTacToe.Game;
import LLD.TicTacToe.enums.GameStatus;

import java.util.HashMap;
import java.util.Map;

public class ScoreBoard implements GameObserver {

    private static ScoreBoard scoreBoard;
    private final HashMap<String,Integer> scores = new HashMap<>();

    private ScoreBoard() {
    }

    public static ScoreBoard getInstance(){
        if (scoreBoard==null)
            scoreBoard = new ScoreBoard();
        return scoreBoard;
    }

    @Override
    public void update(Game game) {
        if (game.getStatus().equals(GameStatus.WIN)) {
            String winner = game.getCurrentPlayer().getName();
            scores.put(winner, scores.getOrDefault(winner,0)+1);
            System.out.printf("[Scoreboard] %s wins! Their new score is %d.%n",
                    winner, scores.get(winner));
        }
    }

    public void printScoreBoard(){
        System.out.println("Scoreboard");
        System.out.println("-------------");
        for(Map.Entry<String,Integer> entry: scores.entrySet()) {
            System.out.println("Player: " + entry.getKey() + "\nScore: " + entry.getValue());
        }
    }
}
