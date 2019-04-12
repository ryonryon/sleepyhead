package pazzle.Controller;

import alarm.IMediaPlayerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class PuzzleScreenController implements Initializable, IMediaPlayerController {

    @FXML
    public Button x0y0, x0y1, x0y2;
    @FXML
    public Button x1y0, x1y1, x1y2;
    @FXML
    public Button x2y0, x2y1, x2y2;

    private Button[][] grid;
    private MediaPlayer mediaPlayer;

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        newGame();
    }

    public void newGame() {

        grid = new Button[][]{
                {x0y0, x0y1, x0y2},
                {x1y0, x1y1, x1y2},
                {x2y0, x2y1, x2y2}
        };

        int[] a = new int[8];
        int k = 0;

        for (int i = 0; i < 8; i++) {
            a[i] = (int) (Math.random() * 8 + 1);
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 2) {
                    grid[i][j].setText("");
                    grid[i][j].setStyle("-fx-background-color: #F5E8D5");
                }
                else {
                    grid[i][j].setText(Integer.toString(a[k]));
                    grid[i][j].setStyle("-fx-background-color: #FFFFFF");
                }
                k++;
            }
        }
    }

    public void actionPerformed(ActionEvent actionEvent){

        String buttonId = ((Button) actionEvent.getSource()).getId();
        int i = Integer.parseInt(buttonId.substring(1, 2));
        int j = Integer.parseInt(buttonId.substring(3, 4));

        if ((j + 1) <= 2 && grid[i][j + 1].getText() == "") {
            String label = grid[i][j].getText();
            grid[i][j + 1].setText(label);
            grid[i][j].setText("");
        }
        else if ((j - 1) >= 0 && grid[i][j - 1].getText() == "") {
            String label = grid[i][j].getText();
            grid[i][j - 1].setText(label);
            grid[i][j].setText("");
        }
        else if ((i + 1) <= 2 && grid[i + 1][j].getText() == "") {
            String label = grid[i][j].getText();
            grid[i + 1][j].setText(label);
            grid[i][j].setText("");
        }
        else if ((i - 1) >= 0 && grid[i - 1][j].getText() == "") {
            String label = grid[i][j].getText();
            grid[i - 1][j].setText(label);
            grid[i][j].setText("");
        }

        refreshScreen();
        checkPanel();
    }

    private void refreshScreen() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].getText() == "") {
                    grid[i][j].setStyle("-fx-background-color: #F5E8D5");
                } else
                    grid[i][j].setStyle("-fx-background-color: #FFFFFF");
            }
        }
    }

    private void checkPanel () {
        if (grid[0][0].getText().equals("1") && grid[0][1].getText().equals("2") &&
                grid[0][2].getText().equals("3") && grid[1][0].getText().equals("4") &&
                grid[1][1].getText().equals("5") && grid[1][2].getText().equals("6") &&
                grid[2][0].getText().equals("7") && grid[2][1].getText().equals("8")) {

            // todo: stop the alarm
            System.out.println("You Win");
            mediaPlayer.stop();
            Stage stage = (Stage) x0y0.getScene().getWindow();
            stage.close();
        }


    }


}
