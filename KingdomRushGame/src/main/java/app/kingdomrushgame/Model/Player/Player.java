package app.kingdomrushgame.Model.Player;
import java.util.*;
import app.kingdomrushgame.Model.Spell.Spell;
import app.kingdomrushgame.Model.Spell.SpellCoin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private int id;
    private String name;
    private String password;
    private int level;
    private int diamondNumber;
    private ArrayList<Spell> backpack;

    public Player(String name,String password) {
        this.name = name;
        this.password = password;
        this.level = 1;
        this.diamondNumber = 50; // todo at first
        this.backpack = new ArrayList<Spell>();
    }

    public boolean signup(Player player){

        return true;
    }
    public void ShoppingSpell(){

    }
}
