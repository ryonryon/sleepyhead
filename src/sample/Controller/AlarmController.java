package sample.Controller;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AlarmController {
    private MediaPlayer mediaPlayer;

    public void playAlarm()
    {
       // System.err.println(getClass().getResource("/Users/monashamsolebad/sleepyhead/res/alarm.mp3").toString());
        Media media = new Media(new File("src/res/alarm.mp3").toURI().toASCIIString());
        this.mediaPlayer = new MediaPlayer(media);
        this.mediaPlayer.play();
    }

    public void stopAlarm()
    {
        this.mediaPlayer.stop();
    }
}
