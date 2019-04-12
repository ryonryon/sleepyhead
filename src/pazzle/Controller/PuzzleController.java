package pazzle.Controller;

import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PuzzleController extends JFrame implements ActionListener {

    JButton[][] Button = new JButton[3][3];

    public PuzzleController() {

        setSize(350, 365);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setTitle("Puzzle Game");
        JPanel panel = new JPanel();
        int[] a = new int[8];
        for (int i = 0; i < 8; i++) {
            a[i] = (int) (Math.random() * 8 + 1);
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    i--;
                    break;
                }
            }
        }
        Dimension d = new Dimension(100, 100);
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 2)
                    Button[2][2] = new JButton(" ");
                else
                    Button[i][j] = new JButton(Integer.toString(a[k]));
                Button[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                Button[i][j].setSize(d);
                Button[i][j].setPreferredSize(d);
                panel.add(Button[i][j]);
                Button[i][j].addActionListener(this);
                k++;
            }
        }
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (e.getSource() == Button[i][j] && Button[i][j + 1].getText() == " ") {
                    String label = Button[i][j].getText();
                    Button[i][j + 1].setText(label);
                    Button[i][j].setText(" ");
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (e.getSource() == Button[i][j] && Button[i][j - 1].getText() == " ") {
                    String label = Button[i][j].getText();
                    Button[i][j - 1].setText(label);
                    Button[i][j].setText(" ");
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == Button[i][j] && Button[i + 1][j].getText() == " ") {
                    String label = Button[i][j].getText();
                    Button[i + 1][j].setText(label);
                    Button[i][j].setText(" ");
                }
            }
        }
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == Button[i][j] && Button[i - 1][j].getText() == " ") {
                    String label = Button[i][j].getText();
                    Button[i - 1][j].setText(label);
                    Button[i][j].setText(" ");
                }
            }
        }
        if (Button[0][0].getText().equals("1") && Button[0][1].getText().equals("2") &&
                Button[0][2].getText().equals("3") && Button[1][0].getText().equals("4") &&
                Button[1][1].getText().equals("5") && Button[1][2].getText().equals("6") &&
                Button[2][0].getText().equals("7") && Button[2][1].getText().equals("8"))
            JOptionPane.showMessageDialog(this, " you win!!!! ");


    }
}

