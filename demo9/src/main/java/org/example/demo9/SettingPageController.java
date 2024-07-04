package org.example.demo9;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.example.demo9.controller.Controller;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingPageController implements Initializable {

    @FXML
    private StackPane close_btn;

    @FXML
    private Slider volume;

    @FXML
    void closePage(MouseEvent event) {
        Controller.getController().getStartPageRoot().getChildren().removeLast();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        MediaPlayer music=new MediaPlayer(new Media(""));
//        volume.setValue(music.getVolume()*100);
//        volume.valueProperty().addListener(new InvalidationListener() {
//            @Override
//            public void invalidated(Observable observable) {
//                music.setVolume(volume.getValue()/100);
//            }
//        });
    }
}
