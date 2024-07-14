package app.kingdomrushgame.Model.Raider;
import java.util.*;
import java.lang.*;

import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import lombok.*;
@Getter
@Setter
public abstract class Raider {
    private int health;
    private int speed;
    private int loot;
    private List<Point> pathBreak;
    private ImageView walkGif;
    private PathTransition pathTransition;

    public Raider(int health, int speed, int loot, List<Point> pathBreak) {
        this.health = health;
        this.speed = speed;
        this.loot = loot;
        this.pathBreak = pathBreak;
        this.walkGif = new ImageView();
        this.pathTransition = new PathTransition();
        Path path = new Path();
        path.getElements().add(new MoveTo(this.getPathBreak().getFirst().getX(), this.getPathBreak().getFirst().getY()));
        for (int i = 1; i < this.getPathBreak().size(); i++) {
            path.getElements().add(new LineTo(this.getPathBreak().get(i).getX(), this.getPathBreak().get(i).getY()));
        }
        pathTransition.setDuration(Duration.seconds(20));
        pathTransition.setPath(path);
        pathTransition.setCycleCount(1);
    }

}
