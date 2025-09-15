package LLD.TicTacToe.models;

import LLD.TicTacToe.enums.Symbol;
import LLD.TicTacToe.exception.InvalidMoveException;

public class Board {

    private final Cell[][] grid;
    private final int size;

    public Board(int n){
        this.size = n;
        this.grid = new Cell[n][n];
        for(int i = 0; i< n; i++)
            for(int j = 0; j< n; j++) {
                grid[i][j] = new Cell();
                grid[i][j].setSymbol(Symbol.EMPTY);
            }
    }

    public int getSize() {
        return size;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void printBoard(){
        System.out.println("----------");
        for (int i=0; i<size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(grid[i][j].getSymbol() + " ");
            System.out.println();
        }
        System.out.println("-----------");
    }

    public void makeMove(int x, int y, Symbol s){
        if(!Symbol.EMPTY.equals(grid[x][y].getSymbol())) {
            throw new InvalidMoveException("Invalid move, Cell not empty");
        }
        grid[x][y].setSymbol(s);
    }

    public boolean isFull() {
        for (int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                if (Symbol.EMPTY.equals(grid[i][j].getSymbol()))
                    return false;
        return true;
    }
}
