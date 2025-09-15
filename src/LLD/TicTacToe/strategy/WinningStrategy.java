package LLD.TicTacToe.strategy;

import LLD.TicTacToe.models.Board;
import LLD.TicTacToe.models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player);
}
