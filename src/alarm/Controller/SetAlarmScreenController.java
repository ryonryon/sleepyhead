package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class SetAlarmScreenController implements Initializable {
    public OnCompleteSettingAlarm delegate;

    @FXML
    public void quitForm(ActionEvent actionEvent) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private TextField hoursField;

    @FXML
    private TextField minutesField;

    @FXML
    private TextField secondsField;

    @FXML
    private Button quitButton;
    private boolean timerValidation = true;

    @FXML
    private void setAlarm(ActionEvent event) {

        this.timerValidation = true;

        String hoursString = this.hoursField.getText();
        String minutesString = this.minutesField.getText();
        String secondsString = this.secondsField.getText();

        if (hoursString.equals("")) {
            hoursString = "0";
        }

        if (minutesString.equals("")) {
            minutesString = "0";
        }

        if (secondsString.equals("")) {
            secondsString = "0";
        }

        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        try {
            hours = Integer.parseInt(hoursString);
            minutes = Integer.parseInt(minutesString);
            seconds = Integer.parseInt(secondsString);
        } catch (Exception ex) {
            this.timerValidation = false;
            this.showWarning("Please enter a number only for the times!", "Invalid input received");
        }

        int totalTime = seconds + (minutes * 60) + (hours * 3600);

        if (totalTime == 0) {
            this.timerValidation = false;
            this.showWarning("Please set a time for the alarm before starting!", "Time not found!");
        }

        if (this.timerValidation) {
            delegate.onComplete(totalTime);

            Stage stage = (Stage) quitButton.getScene().getWindow();
            stage.close();
            // pass the data set -> first screen
        }
    }

    public void showWarning(String message, String title) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * When you have to initialize your data.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}




