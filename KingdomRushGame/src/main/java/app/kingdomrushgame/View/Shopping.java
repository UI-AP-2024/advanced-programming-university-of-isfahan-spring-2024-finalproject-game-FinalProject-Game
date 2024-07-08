package app.kingdomrushgame.View;

import app.kingdomrushgame.Controller.playerController;
import app.kingdomrushgame.Model.Player.Player;
import app.kingdomrushgame.Model.Spell.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

@Getter
@Setter
public class Shopping implements Initializable {
    private Spell chosenSpell;

    @FXML
    private ImageView buy_imgv;

    @FXML
    private Label coinCounter_lbl;

    @FXML
    private ImageView coin_imgv;

    @FXML
    private Label dimandCounter_lbl;

    @FXML
    private Label freezeCounter_lbl;

    @FXML
    private ImageView freeze_imgv;

    @FXML
    private Label healthCounter_lbl;

    @FXML
    private ImageView health_imgv;

    @FXML
    private Label littleBoyCounter_lbl;

    @FXML
    private ImageView littleBoy_imgv;

    @FXML
    private ImageView tick_imgv;

    @FXML
    void buy_act(MouseEvent event) {
        boolean result = playerController.buySpell(chosenSpell);
        if (result){

            dimandCounter_lbl.setText(String.valueOf(Integer.parseInt(dimandCounter_lbl.getText())- chosenSpell.getPrice()));

            if (chosenSpell instanceof SpellCoin){
                coinCounter_lbl.setText(String.valueOf(Integer.parseInt(coinCounter_lbl.getText())+1));
            }
            else if (chosenSpell instanceof SpellFreeze){
                freezeCounter_lbl.setText(String.valueOf(Integer.parseInt(freezeCounter_lbl.getText())+1));
            }
            else if (chosenSpell instanceof SpellHealth){
                healthCounter_lbl.setText(String.valueOf(Integer.parseInt(healthCounter_lbl.getText())+1));
            }
            else if (chosenSpell instanceof SpellLittleBoy){
                littleBoyCounter_lbl.setText(String.valueOf(Integer.parseInt(littleBoyCounter_lbl.getText())+1));
            }
        }

    }

    @FXML
    void coin_act(MouseEvent event) {
        chosenSpell = new SpellCoin();
    }

    @FXML
    void freeze_act(MouseEvent event) {
        chosenSpell = new SpellFreeze();
    }

    @FXML
    void health_act(MouseEvent event) {
        chosenSpell = new SpellHealth();
    }

    @FXML
    void littleBoy_act(MouseEvent event) {
        chosenSpell = new SpellLittleBoy();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Player player = playerController.getCurrentPlayer();
        dimandCounter_lbl.setText(String.valueOf(player.getDiamondNumber()));
        for (Spell spell : player.getBackpack()){
            if (spell instanceof SpellCoin){
                coinCounter_lbl.setText(String.valueOf(Integer.parseInt(coinCounter_lbl.getText())+1));
            }
            else if (spell instanceof SpellFreeze){
                freezeCounter_lbl.setText(String.valueOf(Integer.parseInt(freezeCounter_lbl.getText())+1));
            }
            else if (spell instanceof SpellHealth){
                healthCounter_lbl.setText(String.valueOf(Integer.parseInt(healthCounter_lbl.getText())+1));
            }
            else if (spell instanceof SpellLittleBoy){
                littleBoyCounter_lbl.setText(String.valueOf(Integer.parseInt(littleBoyCounter_lbl.getText())+1));
            }
        }
    }


}
