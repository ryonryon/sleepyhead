package sample.Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class FirstScreenController implements Initializable, OnCompleteSettingAlarm {
    @FXML
    private Label timeLabel;
    @FXML
    private Button setAlarmButton;

    private Timer timer;
    private boolean timerOn = false;
    private boolean alarmPlayed = false;

    private MediaPlayer mediaPlayer;


    @Override
    public void onComplete(int totalTime) {

        setAlarmButton.setDisable(true);

        TimerTask task = new TimerTask() {
            int hours = 0;
            int minutes = 0;
            int seconds = 0;
            private int alarm_time = totalTime;


            @Override
            public void run() {

                if (0 < alarm_time) {
                    alarm_time--;
                } else {
                    if (timerOn) {
                        mediaPlayer.play();
                        alarmPlayed = true;
                        Platform.runLater(() -> {
                            openGameSelector();
                        });


                    }
                    timerOn = false;
                    cancel();
                }

                hours = alarm_time / 3600;
                minutes = (alarm_time % 3600) / 60;
                seconds = (alarm_time % 3600) % 60;


                Platform.runLater(() -> {
                    String tl;
                    tl = hours + " : " + minutes + " : " + seconds;
                    timeLabel.setText(tl);
                });
            }
        };

        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(task, 0, 1000);
        this.timerOn = true;

    }

    @FXML
    public void setAlarmClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/setAlarmScreen.fxml"));
            Parent parent = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
            SetAlarmScreenController setAlarmScreenController = loader.getController();
            setAlarmScreenController.delegate = this;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void quitTheApp(ActionEvent actionEvent) {
        Platform.exit();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Media media = new Media(new File("src/res/alarm.mp3").toURI().toASCIIString());
        mediaPlayer = new MediaPlayer(media);
    }

    public void openGameSelector() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/gameSelector.fxml"));
            Parent parent = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

