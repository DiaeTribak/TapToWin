
import controller.Controller;
import java.util.Scanner;
import models.Game;
import view.Gui;
import view.Tui;

public class TapToWin {
    public TapToWin() {
    }

    public static void main(String[] args) {
        Game game = new Game();
        Controller controller = new Controller(game);
        Tui tui = new Tui(controller);
        Gui gui = new Gui(controller);
        controller.addObserver(tui);
        controller.addObserver(gui);
        tui.printGame();
        Scanner scanner = new Scanner(System.in);

        String input;
        for(boolean isOver = false; !isOver; isOver = tui.processInput(input)) {
            input = scanner.next();
        }

    }
}