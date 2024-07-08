package app.kingdomrushgame.View;

import app.kingdomrushgame.Controller.playerController;
import app.kingdomrushgame.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

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
    void shopping_act(MouseEvent event) {

    }

    @FXML
    void setting_act(MouseEvent event) {

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
