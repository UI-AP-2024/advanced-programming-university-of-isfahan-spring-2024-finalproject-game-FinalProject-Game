package app.kingdomrushgame.Model.Raider;

import app.kingdomrushgame.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class RaiderArmor extends Raider{

    public RaiderArmor(List<Point> pathBreak){
        super(50,5,30,pathBreak);
        ImageView walkGif = new ImageView();
        walkGif.setImage(new Image(String.valueOf(HelloApplication.class.getResource("images/raiders/Armor.gif"))));
        super.setWalkGif(walkGif);

    }
}
