
package view;

import javax.swing.JButton;

public class GuiBrick extends JButton {
    String value;
    int i;
    int j;

    public GuiBrick(String value, int i, int j) {
        this.i = i;
        this.j = j;
        this.setText(value);
    }

    public void setValue(String value) {
        this.setText(value);
    }

    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }
}
