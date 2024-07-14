package app.kingdomrushgame.View;

import app.kingdomrushgame.Controller.playerController;
import app.kingdomrushgame.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    private TextField name_field;

    @FXML
    private PasswordField pass_field;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    public void login_act(ActionEvent actionEvent) throws IOException {
        String userName = name_field.getText();
        System.out.println(userName);
        String password = pass_field.getText();
        System.out.println(password);
        boolean result = playerController.Login(userName,password);
        if (result){
            FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("fxmls/home.fxml"));
            Scene scene = new Scene(fxml.load());
            HelloApplication.getMainStage().setScene(scene);
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("there is wrong. maybe the user not found!");
            alert.showAndWait();
        }
    }
}
