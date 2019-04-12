package alarm.Controller;

import alarm.IMediaPlayerController;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import pazzle.Controller.PuzzleController;
import sudoku.Controller.SudokuController;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.ResourceBundle;

public class GameSelectorController implements Initializable, IMediaPlayerController {
    private MediaPlayer mediaPlayer;
    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

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

    public void playPuzzle2() {
        String filePath = "../../pazzle/View/PuzzleScreen.fxml";
        openGameScreen(filePath);
    }

    public void playPuzzle() {
        try {
            new PuzzleController();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void openGameScreen(String filePath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(filePath));
            Parent parent = loader.load();

            IMediaPlayerController controller = loader.getController();
            controller.setMediaPlayer(this.mediaPlayer);

            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
