package app.kingdomrushgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxml= new FXMLLoader(HelloApplication.class.getResource("fxmls/Authentication.fxml"));
        stage.setScene(new Scene(fxml.load(),1100,550));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}