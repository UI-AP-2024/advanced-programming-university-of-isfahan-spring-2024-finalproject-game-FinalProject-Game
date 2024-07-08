package app.kingdomrushgame.Model.Player;
import java.util.*;

import app.kingdomrushgame.DataBase.sqlConnection;
import app.kingdomrushgame.Model.Spell.Spell;
import app.kingdomrushgame.Model.Spell.SpellCoin;
import javafx.scene.control.Alert;
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
        this.diamondNumber = 300; // todo at first
        this.backpack = new ArrayList<>();
    }

    public boolean signup(){
        String sql = String.format("INSERT INTO player (playerName,playerPassword,playerLevel,playerDiamondNumber) VALUES ('%s','%s',%s,%s) ",this.name,this.password,this.level,this.diamondNumber);
//        String sql = "INSERT INTO `player` (`player_id`, `player_name`, `player_password`, `player_level`, `player_diamond_number`) VALUES (NULL, 'ahmad', '1234', '1', '300')";
        sqlConnection sqlConnect = new sqlConnection();

        try {
            Boolean result = sqlConnect.ExecuteSql(sql);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void ShoppingSpell(){

    }
}
