package app.kingdomrushgame.View;

import app.kingdomrushgame.Controller.musicController;
import app.kingdomrushgame.Controller.playerController;
import app.kingdomrushgame.HelloApplication;
import app.kingdomrushgame.Model.Player.Player;
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
    private ImageView volum_imgv;


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
        Image imaveVolume = new Image(String.valueOf(HelloApplication.class.getResource("images/volume.png")));
        Image imaveMute = new Image(String.valueOf(HelloApplication.class.getResource("images/mute.png")));
        if (mediaPlayer.isMute()) volum_imgv.setImage(imaveMute);
        else volum_imgv.setImage(imaveVolume);
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
        Player currentPlayer = playerController.getCurrentPlayer();
        Image level1 = new Image(String.valueOf(HelloApplication.class.getResource("images/1.png")));
        Image level2;
        if (currentPlayer.getLevel()>=2){
            level2 = new Image(String.valueOf(HelloApplication.class.getResource("images/2.png")));
        }
        else level2 = new Image(String.valueOf(HelloApplication.class.getResource("images/2B.png")));
        Image level3;
        if (currentPlayer.getLevel()>=3){
            level3 = new Image(String.valueOf(HelloApplication.class.getResource("images/3.png")));
        }
        else level3 = new Image(String.valueOf(HelloApplication.class.getResource("images/3B.png")));
        Image level4;
        if (currentPlayer.getLevel()>=4){
            level4 = new Image(String.valueOf(HelloApplication.class.getResource("images/4.png")));
        }
        else level4 = new Image(String.valueOf(HelloApplication.class.getResource("images/4B.png")));

        circle1.setFill(new ImagePattern(level1));
        circle2.setFill(new ImagePattern(level2));
        circle3.setFill(new ImagePattern(level3));
        circle4.setFill(new ImagePattern(level4));


        int diamond = playerController.getCurrentPlayer().getDiamondNumber();
        diamond_lbl.setText(String.valueOf(diamond));

    }
}
