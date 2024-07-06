package app.kingdomrushgame.View;

import app.kingdomrushgame.Controller.playerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Signup implements Initializable {

    @FXML
    private TextField name_field;

    @FXML
    private PasswordField pass_field;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void singup_act(ActionEvent event) {
        String userName = name_field.getText();
        System.out.println(userName);
        String password = pass_field.getText();
        System.out.println(password);
        String result = playerController.Signup(userName,password);
    }
}
