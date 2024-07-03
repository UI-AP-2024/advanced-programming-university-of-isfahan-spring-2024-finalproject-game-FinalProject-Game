package app.kingdomrushgame.Model.Raider;
import java.util.*;
import java.lang.*;

import lombok.*;
@Getter
@Setter
public abstract class Raider {
    private int health;
    private int speed;
    private int loot;
    private List<Point> pathBreak;
    private List<String> imagePaths;

    public abstract void move();
}
