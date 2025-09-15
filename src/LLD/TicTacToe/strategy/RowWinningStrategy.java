package LLD.TicTacToe.strategy;

import LLD.TicTacToe.models.Board;
import LLD.TicTacToe.models.Player;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Player player) {
        int rowWin = 0;
        for (int i=0; i< board.getSize(); i++) {
            for (int j=0; j< board.getSize(); j++) {
                if (player.getSymbol().equals(board.getGrid()[i][j].getSymbol()))
                    rowWin++;
            }
            if (rowWin==3) return true;
            rowWin=0;
        }
        return false;
    }
}
