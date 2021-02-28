
package models;

public class Game {
    private Brick[][] bricks;
    private int size = 4;
    private Player player;

    public Game() {
        this.bricks = new Brick[this.size][this.size];

        for(int i = 0; i < this.size; ++i) {
            for(int j = 0; j < this.size; ++j) {
                this.bricks[i][j] = new Brick("");
            }
        }

        this.player = new Player("", "");
    }

    public int getSize() {
        return this.size;
    }

    public boolean isDestroyed(int i, int j) {
        return this.bricks[i][j].IsNotDestroyed();
    }

    public Brick getBrick(int i, int j) {
        return this.bricks[i][j];
    }

    public String toString() {
        String var10000 = this.printGame(false);
        return var10000 + "Game Infos\n" + this.printGame(true);
    }

    public String printGame(boolean isInformation) {
        String result = " ___ ___ ___ ___  \n";

        for(int i = 0; i < this.size; ++i) {
            for(int j = 0; j < this.size; ++j) {
                result = result + "|" + (isInformation ? i + "," + j : this.bricks[i][j].toString());
            }

            result = result + "|\n ___ ___ ___ ___ \n";
        }

        return result;
    }

    public Brick[][] getBricks() {
        return this.bricks;
    }

    public void setBrick(int i, int j, String symbol) {
        this.bricks[i][j].setValue(symbol);
    }

    public void restartGame() {
        this.bricks = new Brick[this.size][this.size];

        for(int i = 0; i < this.size; ++i) {
            for(int j = 0; j < this.size; ++j) {
                this.bricks[i][j] = new Brick("");
            }
        }

        this.player = new Player("", "");
    }
}
