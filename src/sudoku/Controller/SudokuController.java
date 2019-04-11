package sudoku.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SudokuController implements Initializable {

    @FXML
    public TextField x1y1, x1y2, x1y3, x1y4, x1y5, x1y6, x1y7, x1y8, x1y9;
    @FXML
    public TextField x2y1, x2y2, x2y3, x2y4, x2y5, x2y6, x2y7, x2y8, x2y9;
    @FXML
    public TextField x3y1, x3y2, x3y3, x3y4, x3y5, x3y6, x3y7, x3y8, x3y9;
    @FXML
    public TextField x4y1, x4y2, x4y3, x4y4, x4y5, x4y6, x4y7, x4y8, x4y9;
    @FXML
    public TextField x5y1, x5y2, x5y3, x5y4, x5y5, x5y6, x5y7, x5y8, x5y9;
    @FXML
    public TextField x6y1, x6y2, x6y3, x6y4, x6y5, x6y6, x6y7, x6y8, x6y9;
    @FXML
    public TextField x7y1, x7y2, x7y3, x7y4, x7y5, x7y6, x7y7, x7y8, x7y9;
    @FXML
    public TextField x8y1, x8y2, x8y3, x8y4, x8y5, x8y6, x8y7, x8y8, x8y9;
    @FXML
    public TextField x9y1, x9y2, x9y3, x9y4, x9y5, x9y6, x9y7, x9y8, x9y9;

    private SudokuField sudokuField;
    private TextField[][] grid;
    private int selectedGridX;
    private int selectedGridY;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.sudokuField = new SudokuField();

        this.grid = new TextField [][]{
            {x1y1, x1y2, x1y3, x1y4, x1y5, x1y6, x1y7, x1y8, x1y9},
            {x2y1, x2y2, x2y3, x2y4, x2y5, x2y6, x2y7, x2y8, x2y9},
            {x3y1, x3y2, x3y3, x3y4, x3y5, x3y6, x3y7, x3y8, x3y9},
            {x4y1, x4y2, x4y3, x4y4, x4y5, x4y6, x4y7, x4y8, x4y9},
            {x5y1, x5y2, x5y3, x5y4, x5y5, x5y6, x5y7, x5y8, x5y9},
            {x6y1, x6y2, x6y3, x6y4, x6y5, x6y6, x6y7, x6y8, x6y9},
            {x7y1, x7y2, x7y3, x7y4, x7y5, x7y6, x7y7, x7y8, x7y9},
            {x8y1, x8y2, x8y3, x8y4, x8y5, x8y6, x8y7, x8y8, x8y9},
            {x9y1, x9y2, x9y3, x9y4, x9y5, x9y6, x9y7, x9y8, x9y9},
        };

        connectPanel();
    }

    @FXML
    public void newGame() {

        this.sudokuField.setTemplate();

        connectPanel();
    }

    private void connectPanel() {

        for (Coordinate coordinate : this.sudokuField.getSudokuField()) {

            int x_id = coordinate.getxCoordinate() - 1;
            int y_id = coordinate.getyCoordinate() - 1;
            int value = coordinate.getValue();

            if (value != 0) {

                this.grid[x_id][y_id].setText(String.valueOf(value));
                this.grid[x_id][y_id].setEditable(false);
                this.grid[x_id][y_id].setStyle("-fx-background-color: lightgray;");
            } else {
                this.grid[x_id][y_id].setText("");
            }
        }
    }

    @FXML
    public void checkAnswers() {

        ArrayList<String> errorList = sudokuField.isCompletion();

        if (!errorList.isEmpty()) {
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setHeaderText(null);
            dialog.setTitle("Something wrong");
            dialog.setContentText("Please check your answers \n" + errorList.toString());
            dialog.showAndWait();
        } else {
            // TODO display the "clear" and stop the alarm
        }
    }

    @FXML
    public void gridSelected(MouseEvent mouseEvent) {

        String id = ((Control)mouseEvent.getSource()).getId();
        selectedGridX = (Integer.parseInt(id.substring(1,2))) - 1;
        selectedGridY = (Integer.parseInt(id.substring(3,4))) - 1;
    }

    @FXML
    public void numberButtonClicked(ActionEvent actionEvent) {

        String clickedNumber = ((Button) actionEvent.getSource()).getText();

        if (grid[selectedGridX][selectedGridY].isEditable()) {
            grid[selectedGridX][selectedGridY].setText(clickedNumber);
        }

        sudokuField.setNumber(selectedGridX, selectedGridY, Integer.parseInt(clickedNumber));
    }
}
