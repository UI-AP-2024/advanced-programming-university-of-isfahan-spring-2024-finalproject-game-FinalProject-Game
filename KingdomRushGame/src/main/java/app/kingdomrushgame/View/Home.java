package app.kingdomrushgame.View;

import app.kingdomrushgame.Controller.musicController;
import app.kingdomrushgame.Controller.playerController;
import app.kingdomrushgame.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    private Circle circle1;
    @FXML
    private Circle circle2;
    @FXML
    private Circle circle3;
    @FXML
    private Circle circle4;
    @FXML
    private Label diamond_lbl;
    @FXML
    private ImageView shopping_img;
    @FXML
    private ImageView setting_img;

    @FXML
    private VBox setting_vbox;


    @FXML
    void shopping_act(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("fxmls/shopping.fxml"));
        HelloApplication.getMainStage().setScene(new Scene(fxml.load()));
    }

    @FXML
    void setting_act(MouseEvent event) {
        setting_vbox.setVisible(!setting_vbox.isVisible());
    }

    @FXML
    void volume_act(MouseEvent event) {
        MediaPlayer mediaPlayer = musicController.getMusicController().getMediaPlayer();
        mediaPlayer.setMute(!mediaPlayer.isMute());
    }
    @FXML
    void circle1_act(MouseEvent event) {

    }

    @FXML
    void circle2_act(MouseEvent event) {

    }

    @FXML
    void circle3_act(MouseEvent event) {

    }

    @FXML
    void circle4_act(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int diamond = playerController.getCurrentPlayer().getDiamondNumber();
        diamond_lbl.setText(String.valueOf(diamond));

    }
}
