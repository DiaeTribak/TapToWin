package models;

public class MESSAGES {
    public static final String WIN = "you won 800$ congratulations!!!";
    public static final String GAME_RESTARTED = "The Game has been restarted";
    public static final String WelcomeMessage = "Welcome to Tap and win, can you give your name please";
    public static final String brickIsTaped = "brick is already taped";

    public MESSAGES() {
    }

    public static String PLAYER_SET(String name1) {
        return "Thank you for setting your name, now " + name1 + ", may play, to play click on a brick";
    }

    public static String playMessage(String name) {
        return name + " you won 50$, congratulations.Continue winning";
    }
}
