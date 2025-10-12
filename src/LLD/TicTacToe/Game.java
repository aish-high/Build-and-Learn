package LLD.TicTacToe;

import LLD.TicTacToe.exception.InvalidMoveException;
import LLD.TicTacToe.models.Board;
import LLD.TicTacToe.models.Player;
import LLD.TicTacToe.observer.GameSubject;
import LLD.TicTacToe.observer.ScoreBoard;
import LLD.TicTacToe.strategy.ColumnWinningStrategy;
import LLD.TicTacToe.enums.GameStatus;
import LLD.TicTacToe.strategy.RowWinningStrategy;
import LLD.TicTacToe.strategy.WinningStrategy;

import java.util.List;

public class Game extends GameSubject {

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final List<WinningStrategy> strategies;
    private final Board board;
    private GameStatus status;
    private final ScoreBoard scoreBoard;

    public Game(int n, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.board =  new Board(n);
        this.scoreBoard = ScoreBoard.getInstance();
        this.status = GameStatus.IN_PROGRESS;
        this.strategies = List.of(new ColumnWinningStrategy(),new RowWinningStrategy());
        addObserver(scoreBoard);
    }

    public GameStatus getStatus() {
        return status;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void playGame(int x, int y) {
        if (GameStatus.WIN.equals(status) || GameStatus.DRAW.equals(status)) {
            System.out.println("Invalid move, game already over");
            return;
        }
        try {
            board.makeMove(x, y, currentPlayer.getSymbol());
            board.printBoard();
        } catch (InvalidMoveException e){
            System.out.println(e.getMessage());
            return;
        }
        if (checkWinner()) {
            status = GameStatus.WIN;
            notifyObservers();
        }
        else if (board.isFull())
            status = GameStatus.DRAW;
        else
            switchPlayer();
    }

    public boolean checkWinner() {
         for(WinningStrategy strategy : strategies) {
             if (strategy.checkWinner(board,currentPlayer)) {
                 return true;
             }
        }
         return false;
    }

    public void switchPlayer(){
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    public void printScoreBoard(){
        scoreBoard.printScoreBoard();
    }
}
