package minesweeper.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MinesweeperController implements Initializable {
    @FXML
    public Button x0y0, x0y1, x0y2, x0y3, x0y4, x0y5, x0y6, x0y7, x0y8, x0y9;
    @FXML
    public Button x1y0, x1y1, x1y2, x1y3, x1y4, x1y5, x1y6, x1y7, x1y8, x1y9;
    @FXML
    public Button x2y0, x2y1, x2y2, x2y3, x2y4, x2y5, x2y6, x2y7, x2y8, x2y9;
    @FXML
    public Button x3y0, x3y1, x3y2, x3y3, x3y4, x3y5, x3y6, x3y7, x3y8, x3y9;
    @FXML
    public Button x4y0, x4y1, x4y2, x4y3, x4y4, x4y5, x4y6, x4y7, x4y8, x4y9;
    @FXML
    public Button x5y0, x5y1, x5y2, x5y3, x5y4, x5y5, x5y6, x5y7, x5y8, x5y9;
    @FXML
    public Button x6y0, x6y1, x6y2, x6y3, x6y4, x6y5, x6y6, x6y7, x6y8, x6y9;
    @FXML
    public Button x7y0, x7y1, x7y2, x7y3, x7y4, x7y5, x7y6, x7y7, x7y8, x7y9;
    @FXML
    public Button x8y0, x8y1, x8y2, x8y3, x8y4, x8y5, x8y6, x8y7, x8y8, x8y9;
    @FXML
    public Button x9y0, x9y1, x9y2, x9y3, x9y4, x9y5, x9y6, x9y7, x9y8, x9y9;
    @FXML
    public Button resetButton, flagButton;

    private int PANEL_SIZE = 10;
    private Minesweeper minesweeper;
    private Button[][] grid;

    private boolean isFlagOn = false;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.minesweeper = new Minesweeper(PANEL_SIZE, PANEL_SIZE);

        this.grid = new Button[][]{
                {x0y0, x0y1, x0y2, x0y3, x0y4, x0y5, x0y6, x0y7, x0y8, x0y9},
                {x1y0, x1y1, x1y2, x1y3, x1y4, x1y5, x1y6, x1y7, x1y8, x1y9},
                {x2y0, x2y1, x2y2, x2y3, x2y4, x2y5, x2y6, x2y7, x2y8, x2y9},
                {x3y0, x3y1, x3y2, x3y3, x3y4, x3y5, x3y6, x3y7, x3y8, x3y9},
                {x4y0, x4y1, x4y2, x4y3, x4y4, x4y5, x4y6, x4y7, x4y8, x4y9},
                {x5y0, x5y1, x5y2, x5y3, x5y4, x5y5, x5y6, x5y7, x5y8, x5y9},
                {x6y0, x6y1, x6y2, x6y3, x6y4, x6y5, x6y6, x6y7, x6y8, x6y9},
                {x7y0, x7y1, x7y2, x7y3, x7y4, x7y5, x7y6, x7y7, x7y8, x7y9},
                {x8y0, x8y1, x8y2, x8y3, x8y4, x8y5, x8y6, x8y7, x8y8, x8y9},
                {x9y0, x9y1, x9y2, x9y3, x9y4, x9y5, x9y6, x9y7, x9y8, x9y9},
        };
    }


    public void clicked(ActionEvent actionEvent) {

        String buttonId = ((Button) actionEvent.getSource()).getId();
        int XPosition = Integer.parseInt(buttonId.substring(1,2));
        int YPosition = Integer.parseInt(buttonId.substring(3,4));

        if (isFlagOn) {
            minesweeper.putFlag(XPosition, YPosition);
        } else {
            this.minesweeper.openPanel(XPosition, YPosition);
            this.minesweeper.isCompletion();
        }

        refreshScreen();
    }


    private void refreshScreen() {
        for (int i = 0; i <= 9; i++) {

            for(int j = 0; j <= 9; j++) {

                BoxValueStatus.BoxStatus status = this.minesweeper.panel.get(new Coordinate(i, j)).getBoxStatus();
                BoxValueStatus.BoxValue value = this.minesweeper.panel.get(new Coordinate(i, j)).getBoxValue();
                setButton(grid[i][j], status, value);
            }
        }
    }

    private void setButton(Button button, BoxValueStatus.BoxStatus boxStatus, BoxValueStatus.BoxValue boxValue) {

        switch (boxStatus) {
            case Opened:
                setValue(button, boxValue);
                button.setStyle("-fx-background-color: #d6d6d6");
                break;
            case flagged:
                setImage(button,"./View/img/flag.png");
                break;
            case Close:
                button.setText("");
                setImage(button,"");
                button.setStyle("-fx-background-color: #dadada");
                break;
        }
    }

    private void setValue(Button button, BoxValueStatus.BoxValue boxValue) {

        switch (boxValue) {
            case Number_1:
                button.setText("1");
                break;
            case Number_2:
                button.setText("2");
                break;
            case Number_3:
                button.setText("3");
                break;
            case Number_4:
                button.setText("4");
                break;
            case Number_5:
                button.setText("5");
                break;
            case Number_6:
                button.setText("6");
                break;
            case Number_7:
                button.setText("7");
                break;
            case Number_8:
                button.setText("8");
                break;
            case Bomb:
                button.setStyle("-fx-background-color: #d6d6d6");
                setImage(button, "./View/img/mine.png");
                setImage(resetButton, "./View/img/booo.png");
                break;
            case Blank:
                button.setStyle("-fx-background-color: #d6d6d6");
                break;
        }
    }

    private void setImage(Button button, String filePath) {

        Image image = new Image(getClass().getResourceAsStream(filePath));
        button.setGraphic(new ImageView(image));

    }

    // when the flag button clicked
    public void flagOn() {

        minesweeper.toggleButtonType();
        isFlagOn = !isFlagOn;

        if (isFlagOn) {
            flagButton.setStyle("-fx-background-color: #d6d6d6");
        } else {
            flagButton.setStyle("-fx-border-color: #dadada;");
        }
    }

    // when the face button clicked
    public void resetGame() {

        minesweeper.restartMinesweeper(PANEL_SIZE, PANEL_SIZE);
        setImage(resetButton, "./View/img/smiley.png");
        refreshScreen();

    }
}
