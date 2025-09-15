package LLD.TicTacToe.observer;

import LLD.TicTacToe.Game;
import java.util.ArrayList;
import java.util.List;

public abstract class GameSubject {
    private final List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver e) {
        observers.add(e);
    }

    public void removeObserver(GameObserver e) {
        observers.remove(e);
    }

    public void notifyObservers() {
        for (GameObserver observer: observers)
            observer.update((Game) this);
    }
}
