package LLD.TicTacToe.models;

import LLD.TicTacToe.enums.Symbol;

public class Cell {
    private Symbol symbol;

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
