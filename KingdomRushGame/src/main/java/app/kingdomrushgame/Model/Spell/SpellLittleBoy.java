package app.kingdomrushgame.Model.Spell;
import java.lang.*;
import java.util.*;
public class SpellLittleBoy implements Spell{
    private final int price= 800;
    private int id=5;

    @Override
    public int getId() {
        return id;
    }
    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void drop() {

    }
}
