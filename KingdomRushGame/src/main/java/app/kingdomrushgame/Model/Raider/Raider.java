package app.kingdomrushgame.Model.Raider;
import java.util.*;
import java.lang.*;

import javafx.scene.image.Image;
import lombok.*;
@Getter
@Setter
public abstract class Raider {
    private int health;
    private int speed;
    private int loot;
    private List<Point> pathBreak;
    private List<Image> imagePaths;

    public abstract void move();
}
