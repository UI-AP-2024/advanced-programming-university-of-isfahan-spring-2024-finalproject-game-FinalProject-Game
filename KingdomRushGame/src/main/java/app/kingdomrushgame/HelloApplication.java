package app.kingdomrushgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;

public class HelloApplication extends Application {
    @Getter
    private static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxml= new FXMLLoader(HelloApplication.class.getResource("fxmls/Authentication.fxml"));
        stage.setScene(new Scene(fxml.load()));
        stage.setTitle("Kingdom Rush Tower");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}