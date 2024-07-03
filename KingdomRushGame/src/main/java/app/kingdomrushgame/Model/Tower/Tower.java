package app.kingdomrushgame.Model.Tower;
import lombok.*;

@Getter
@Setter
public abstract class Tower {
    private int power;
    private int damage;
    private double board;
    private String imagePath;

    public Tower(int power, int damage, double board, String imagePath) {
        this.power = power;
        this.damage = damage;
        this.board = board;
        this.imagePath = imagePath;
    }

    public abstract void defending();
    public abstract void upgrade();
    public abstract void spoilage();
}
