package app.kingdomrushgame.View;

import app.kingdomrushgame.Controller.mapController;
import app.kingdomrushgame.Controller.towerController;
import app.kingdomrushgame.HelloApplication;
import app.kingdomrushgame.Model.Map.gameMap;
import app.kingdomrushgame.Model.Raider.Point;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Game implements Initializable {
    public AnchorPane anchorGame;
    private List<ImageView> towers = new ArrayList<>();
    private ImageView popup = new ImageView();
    private ImageView chosenTower = new ImageView();

    @FXML
    private Label coinCounter_lbl;
    private int coin;

    @FXML
    private Label heartCounter_lbl;

    @FXML
    private Label waveCounter_lbl;
    private int waveCounter = 0;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameMap map = mapController.getMap();

        coinCounter_lbl.setText(String.valueOf(map.getCoins()));
        coin = map.getCoins();
        waveCounter_lbl.setText(waveCounter + " / " + String.valueOf(map.getAttackWaves().size()));

        for (Point point : map.getTowersPath()) {
            Image imageArcher = new Image(String.valueOf(HelloApplication.class.getResource("images/towers/Archer.png")));
            Image imageArcher2 = new Image(String.valueOf(HelloApplication.class.getResource("images/towers/Archer2.png")));
            Image imageWizard = new Image(String.valueOf(HelloApplication.class.getResource("images/towers/Wizard.png")));
            Image imageWizard2 = new Image(String.valueOf(HelloApplication.class.getResource("images/towers/Wizard2.png")));
            Image imageArtillery = new Image(String.valueOf(HelloApplication.class.getResource("images/towers/Artillery.png")));
            Image imageArtillery2 = new Image(String.valueOf(HelloApplication.class.getResource("images/towers/Artillery2.png")));
            Image imageEarth = new Image(String.valueOf(HelloApplication.class.getResource("images/sp2.png")));
            ImageView imageView = new ImageView();
            imageView.setImage(imageEarth);
            imageView.setFitHeight(70);
            imageView.setFitWidth(75);
            imageView.setLayoutX(point.getX() - 8);
            imageView.setLayoutY(point.getY());
            imageView.setOnMouseClicked(e -> {
                if (imageView.getImage() == imageEarth) {
                    if (anchorGame.getChildren().contains(popup)) {
                        anchorGame.getChildren().remove(popup);
                        chosenTower.setVisible(true);
                    }
                    chosenTower = imageView;
                    imageView.setVisible(false);
                    popup = new ImageView(new Image(String.valueOf(HelloApplication.class.getResource("images/popUp.png"))));
                    popup.setLayoutX(imageView.getLayoutX() - 18);
                    popup.setLayoutY(imageView.getLayoutY() - 17);
                    popup.setFitWidth(105);
                    popup.setFitHeight(105);
                    popup.setOnMouseClicked(e2 -> {

//                        System.out.println(e2.getX()+" "+e2.getY());
                        if (e2.getX() <= 35 && e2.getY() <= 35) {
                            int res = towerController.makeTower("Archer", coin);
                            if (res != -1) {
                                coin = res;
                                coinCounter_lbl.setText(String.valueOf(coin));
                                imageView.setImage(imageArcher);
                                imageView.setVisible(true);
                                anchorGame.getChildren().remove(popup);
                            }
                        } else if (e2.getX() <= 35 && e2.getY() >= 70) {
                            int res = towerController.makeTower("Wizard", coin);
                            if (res != -1) {
                                coin = res;
                                coinCounter_lbl.setText(String.valueOf(coin));
                                imageView.setImage(imageWizard);
                                imageView.setVisible(true);
                                anchorGame.getChildren().remove(popup);
                            }
                        } else if (e2.getX() >= 70 && e2.getY() >= 70) {
                            int res = towerController.makeTower("Artillery", coin);
                            if (res != -1) {
                                coin = res;
                                coinCounter_lbl.setText(String.valueOf(coin));
                                imageView.setImage(imageArtillery);
                                imageView.setVisible(true);
                                anchorGame.getChildren().remove(popup);
                            }
                        }
                        e2.consume();
                    });
                    anchorGame.getChildren().add(popup);
                    e.consume();

                } else {
                    if (anchorGame.getChildren().contains(popup)) {
                        anchorGame.getChildren().remove(popup);
                        chosenTower.setVisible(true);
                    }

                    popup.setImage(new Image(String.valueOf(HelloApplication.class.getResource("images/upgrade.png"))));
                    popup.setLayoutX(imageView.getLayoutX() - 18);
                    popup.setLayoutY(imageView.getLayoutY() - 17);
                    chosenTower = imageView;
                    imageView.setVisible(false);
                    popup.setOnMouseClicked(e3 -> {
                        if (e3.getX() >= 35 && e3.getX() <= 70 && e3.getY() <= 35) {
                            int res = towerController.upgrade(coin);
                            if (res != -1) {
                                coin = res;
                                coinCounter_lbl.setText(String.valueOf(coin));
                                if (imageView.getImage() == imageArcher) {
                                    imageView.setImage(imageArcher2);
                                } else if (imageView.getImage() == imageWizard) {
                                    imageView.setImage(imageWizard2);
                                } else if (imageView.getImage() == imageArtillery) {
                                    imageView.setImage(imageArtillery2);
                                }
                                imageView.setVisible(true);
                                anchorGame.getChildren().remove(popup);
                            }
                        }
                        e3.consume();
                    });
                    anchorGame.getChildren().add(popup);


                }
                e.consume();
            });
            towers.add(imageView);
            anchorGame.getChildren().add(imageView);
        }
    }


    public void click(MouseEvent mouseEvent) {
        if (anchorGame.getChildren().contains(popup)) {
            chosenTower.setVisible(true);
            anchorGame.getChildren().remove(popup);
        }
        System.out.println(mouseEvent.getX() + " " + mouseEvent.getY());
    }
}
