package org.example.demo9;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.example.demo9.controller.Controller;
import org.example.demo9.controller.PlayerController;
import org.example.demo9.model.Map;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LosePageController implements Initializable {

    @FXML
    private Label collectedGems;
    private static long gems=0;
    private static Map map;
    @FXML
    void exit(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(Main.class.getResource("GamePage.fxml"));
        Main.getStage().setScene(new Scene(loader.load(),840,460));
    }

    @FXML
    void replay(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(Main.class.getResource("GamePage.fxml"));
        Main.getStage().setScene(new Scene(loader.load(),840,460));
        MapController.setMap(map);
        MapController.setMapNum(MapController.getMapNum());
        MapController.setImage(map.getImage());
        FXMLLoader l=new FXMLLoader(Main.class.getResource("Map.fxml"));
        Main.getStage().setScene(new Scene(l.load(),840,460));
    }

    @FXML
    void shop(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(Main.class.getResource("GamePage.fxml"));
        Main.getStage().setScene(new Scene(loader.load(),840,460));
        FXMLLoader l=new FXMLLoader(Main.class.getResource("ShopPage.fxml"));
        Controller.getController().getGamePage().getChildren().addLast(l.load());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MapController.setLose(true);
        collectedGems.setText(String.valueOf(gems));
        try {
            PlayerController.getPlayerController().updateGems(gems);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
        }
    }

    public static long getGems() {
        return gems;
    }

    public static void setGems(long gems) {
        LosePageController.gems = gems;
    }

    public static Map getMap() {
        return map;
    }

    public static void setMap(Map map) {
        LosePageController.map = map;
    }
}
