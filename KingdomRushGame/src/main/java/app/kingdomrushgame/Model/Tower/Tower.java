package app.kingdomrushgame.Model.Tower;
import lombok.*;

@Getter
@Setter
public abstract class Tower {
    private int power;
    private int damage;
    private double board;
    private int price;

    public Tower(int power, int damage, double board,int price) {
        this.power = power;
        this.damage = damage;
        this.board = board;
        this.price = price;
    }

}
