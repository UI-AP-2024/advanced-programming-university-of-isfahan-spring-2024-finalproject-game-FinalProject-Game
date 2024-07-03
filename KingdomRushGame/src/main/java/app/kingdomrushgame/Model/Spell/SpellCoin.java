package app.kingdomrushgame.Model.Spell;
import java.lang.*;
import java.util.*;

public class SpellCoin implements Spell{
    private int price;

    public SpellCoin(int price){
        this.price = price;
    }
    @Override
    public int getPrice() {
        return 0;
    }
    @Override
    public void drop() {

    }
}
