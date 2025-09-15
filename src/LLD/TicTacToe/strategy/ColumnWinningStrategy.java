package LLD.TicTacToe.strategy;

import LLD.TicTacToe.models.Board;
import LLD.TicTacToe.models.Player;

public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Player player) {
        int columnWin = 0;
        for (int i=0; i< board.getSize(); i++) {
            for (int j=0; j< board.getSize(); j++) {
                if (player.getSymbol().equals(board.getGrid()[j][i].getSymbol()))
                    columnWin++;
            }
            if (columnWin==3) return true;
            columnWin=0;
        }
        return false;
    }
}
