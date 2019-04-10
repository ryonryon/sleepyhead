package alarm.Controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GameSelectorController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void playSudoku() {
        String filePath = "../../sudoku/View/sudokuScreen.fxml";
        openGameScreen(filePath);
    }

    public void playMinesweeper() {
        String filePath = "../../minesweeper/View/MinesweeperScreen.fxml";
        openGameScreen(filePath);
    }

    public void playPuzzle() {
//        String filePath = "../../pazzle/View/PuzzleScreen.fxml";
//        openGameScreen(filePath);
    }

    public void openGameScreen(String filePath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(filePath));
            Parent parent = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
