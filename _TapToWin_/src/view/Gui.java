package view;

import controller.Controller;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import util.observer.iObserver;

public class Gui extends JFrame implements ActionListener, iObserver {
    Controller controller;
    private GuiBrick[][] GuiBricks;
    int size;
    JPanel panelGame;
    JPanel panelLogin;
    JLabel statusMessageLabel;
    JLabel player;
    JTextField input;
    JButton startGame;
    JButton restartGame;

    public Gui(final Controller controller) {
        this.controller = controller;
        this.size = this.controller.getGame().getSize();
        this.GuiBricks = new GuiBrick[this.size][this.size];
        this.createpanelLogin();
        this.createGamePanel();
        this.restartGame = new JButton("Restart Game");
        this.restartGame.setVisible(false);
        this.restartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Gui.this.restartGame.setVisible(false);
                controller.restartGame();
            }
        });
        JPanel container = new JPanel();
        this.panelGame.setPreferredSize(new Dimension(450, 250));
        this.statusMessageLabel = new JLabel(this.controller.getStatusMessage());
        container.add(this.statusMessageLabel);
        container.add(this.panelLogin);
        container.add(this.restartGame);
        container.add(this.panelGame);
        this.setDefaultCloseOperation(3);
        this.setSize(500, 300);
        this.getContentPane().add(container);
        this.setVisible(true);
    }

    private void createpanelLogin() {
        this.player = new JLabel("Player");
        this.input = new JTextField();
        this.startGame = new JButton("Start Game");
        this.startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String player = Gui.this.input.getText().trim();
                Gui.this.controller.setPlayers(player);
                Gui.this.panelLogin.setVisible(false);
                Gui.this.panelGame.setVisible(true);
            }
        });
        this.panelLogin = new JPanel();
        this.panelLogin.setLayout(new GridLayout(2, 1));
        this.panelLogin.add(this.player);
        this.panelLogin.add(this.input);
        this.panelLogin.add(this.startGame);
    }

    public void createGamePanel() {
        this.panelGame = new JPanel();
        this.panelGame.setLayout(new GridLayout(this.size, this.size, 3, 3));

        for(int i = 0; i < this.size; ++i) {
            for(int j = 0; j < this.size; ++j) {
                this.GuiBricks[i][j] = new GuiBrick(this.controller.getGame().getBrick(i, j).getValue(), i, j);
                this.panelGame.add(this.GuiBricks[i][j]);
                this.GuiBricks[i][j].addActionListener(this);
            }
        }

        this.panelGame.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        GuiBrick button = (GuiBrick)e.getSource();
        int i = button.getI();
        int j = button.getJ();
        this.controller.play(i, j);
    }

    public void update() {
        this.statusMessageLabel.setText(this.controller.getStatusMessage());
        int i;
        int j;
        if (this.controller.userDidWin()) {
            this.restartGame.setVisible(true);

            for(i = 0; i < this.size; ++i) {
                for(j = 0; j < this.size; ++j) {
                    this.GuiBricks[i][j].setValue(this.controller.getGame().getBrick(i, j).getValue());
                    this.GuiBricks[i][j].setEnabled(false);
                }
            }
        } else {
            for(i = 0; i < this.size; ++i) {
                for(j = 0; j < this.size; ++j) {
                    this.GuiBricks[i][j].setValue(this.controller.getGame().getBrick(i, j).getValue());
                    if (this.controller.getGame().isDestroyed(i, j)) {
                        this.GuiBricks[i][j].setEnabled(false);
                    } else {
                        this.GuiBricks[i][j].setEnabled(true);
                    }
                }
            }
        }

    }
}
