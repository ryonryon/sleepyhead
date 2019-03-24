package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.stage = primaryStage;
        changeView("firstScreen.fxml");
        Main.stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void changeView(String fxml) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(fxml))));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
