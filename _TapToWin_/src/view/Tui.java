package view;

import controller.Controller;
import util.observer.iObserver;

public class Tui implements iObserver {
    Controller controller;

    public Tui(Controller controller) {
        this.controller = controller;
    }

    public void printGame() {
        System.out.println(this.controller.getGameString());
        System.out.println(this.controller.getStatusMessage());
    }

    public void update() {
        this.printGame();
    }

    public boolean processInput(String input) {
        String[] values;
        if (!this.controller.arePlayersHere()) {
            values = input.split("-");
            this.controller.setPlayers(values[0]);
            return false;
        } else {
            values = input.split("");
            return this.controller.play(Integer.parseInt(values[0]), Integer.parseInt(values[0]));
        }
    }
}
