package sample.Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class setAlarmScreenController {
    @FXML
    public void quitTheApp(ActionEvent actionEvent) {
        Platform.exit();
    }
}

