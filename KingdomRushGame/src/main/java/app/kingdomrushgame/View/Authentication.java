package app.kingdomrushgame.View;

import app.kingdomrushgame.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Authentication implements Initializable {



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void login_act(ActionEvent event) throws IOException {
        Stage mainStage = HelloApplication.getMainStage();
        mainStage.setTitle("Login");
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("fxmls/login.fxml"));
        mainStage.setScene(new Scene(fxml.load()));
    }

    @FXML
    void signup_act(ActionEvent event) throws IOException {
        Stage mainStage = HelloApplication.getMainStage();
        mainStage.setTitle("Signup");
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("fxmls/signup.fxml"));
        mainStage.setScene(new Scene(fxml.load()));
    }
}
