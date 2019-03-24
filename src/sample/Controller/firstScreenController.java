package sample.Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.Main;

public class firstScreenController {
    @FXML
    public void setAlarmClicked(ActionEvent actionEvent) {
        new Main().changeView("setAlarmScreen.fxml");
    }

    @FXML
    public void quitTheApp(ActionEvent actionEvent) {
        Platform.exit();
    }
}

