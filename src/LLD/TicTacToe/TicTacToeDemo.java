package LLD.TicTacToe;

import LLD.TicTacToe.models.Player;
import LLD.TicTacToe.enums.Symbol;

public class TicTacToeDemo {

    public static void main(String[] args) {

        Player player1 = new Player("aish", Symbol.X);
        Player player2 = new Player("unni", Symbol.O);

        Game game = new Game(3, player1,player2);

        game.playGame(0,1);
        game.playGame(1,1);
        game.playGame(0,0);
        game.playGame(1,2);
        game.playGame(0,0);
        game.playGame(0,2);
        game.playGame(1,2);
        game.printScoreBoard();

        Game game2 = new Game(3,player1,player2);
        game2.playGame(0,0);
        game2.playGame(1,0);
        game2.playGame(2,0);
        game2.playGame(0,2);
        game2.playGame(0,1);
        game2.playGame(1,1);
        game2.playGame(2,1);
        game2.playGame(1,2);
        game2.playGame(2,2);
        game2.printScoreBoard();
    }
}
