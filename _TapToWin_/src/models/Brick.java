
package models;

public class Brick {
    private String value;

    public Brick(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean IsNotDestroyed() {
        return !this.value.equals("");
    }

    public String toString() {
        return this.IsNotDestroyed() ? this.value : "___";
    }
}
