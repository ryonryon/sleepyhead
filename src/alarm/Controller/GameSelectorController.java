package alarm.Controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pazzle.Controller.PuzzleController;

import java.net.URL;
import java.util.ResourceBundle;

public class GameSelectorController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void playSudoku() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../sudoku/View/sudokuScreen.fxml"));
            Parent parent = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void playPuzzle() {
        try {
            new PuzzleController();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
