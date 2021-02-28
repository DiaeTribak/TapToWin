package controller;

import models.Game;
import models.MESSAGES;
import models.Player;
import util.observer.observable;

public class Controller extends observable {
    Game game;
    Player[] player;
    boolean myTurn;
    String statusMessage;

    public Controller(Game game) {
        this.game = game;
        this.player = new Player[1];
        this.myTurn = true;
        this.statusMessage = "Welcome to Tap and win, can you give your name please";
    }

    public boolean arePlayersHere() {
        return this.player[0] != null;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getGameString() {
        return this.game.toString();
    }

    public void setPlayers(String name1) {
        this.player[0] = new Player(name1, "50$");
        this.statusMessage = MESSAGES.PLAYER_SET(name1);
        this.notifyObservers();
    }

    public boolean play(int i, int j) {
        if (this.game.isDestroyed(i, j)) {
            this.statusMessage = "brick is already taped";
        } else {
            this.game.setBrick(i, j, this.player[0].getValue());
            this.statusMessage = MESSAGES.playMessage(this.player[0].getName());
        }

        this.notifyObservers();
        if (this.userDidWin()) {
            this.statusMessage = "you won 800$ congratulations!!!";
            this.notifyObservers();
            return true;
        } else {
            return false;
        }
    }

    public boolean userDidWin() {
        return this.Win();
    }

    public boolean Win() {
        boolean win = false;
        boolean checkGame = this.game.getBricks()[0][0].IsNotDestroyed() && this.game.getBricks()[0][0].getValue() == this.game.getBricks()[0][1].getValue() && this.game.getBricks()[0][1].getValue() == this.game.getBricks()[0][2].getValue() && this.game.getBricks()[0][2].getValue() == this.game.getBricks()[0][3].getValue() && this.game.getBricks()[1][0].getValue() == this.game.getBricks()[1][1].getValue() && this.game.getBricks()[1][1].getValue() == this.game.getBricks()[1][2].getValue() && this.game.getBricks()[1][2].getValue() == this.game.getBricks()[1][3].getValue() && this.game.getBricks()[2][0].getValue() == this.game.getBricks()[2][1].getValue() && this.game.getBricks()[2][1].getValue() == this.game.getBricks()[2][2].getValue() && this.game.getBricks()[2][2].getValue() == this.game.getBricks()[2][3].getValue() && this.game.getBricks()[3][0].getValue() == this.game.getBricks()[3][1].getValue() && this.game.getBricks()[3][1].getValue() == this.game.getBricks()[3][2].getValue() && this.game.getBricks()[3][2].getValue() == this.game.getBricks()[3][3].getValue();
        win = win || checkGame;
        return win;
    }

    public void restartGame() {
        this.game.restartGame();
        this.myTurn = true;
        this.statusMessage = "The Game has been restarted";
        this.notifyObservers();
    }
}
