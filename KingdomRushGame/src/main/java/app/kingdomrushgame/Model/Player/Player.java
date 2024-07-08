package app.kingdomrushgame.Model.Player;
import java.sql.ResultSet;
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
        this.diamondNumber = 5000; // todo at first
        this.backpack = new ArrayList<>();
    }

    public boolean signup(){
        String insertSql = String.format("INSERT INTO player (playerName,playerPassword,playerLevel,playerDiamondNumber) VALUES ('%s','%s',%s,%s) ",this.name,this.password,this.level,this.diamondNumber);
        String foundIdSql = String.format("SELECT playerId FROM player WHERE playerName = '%s' ",this.name);
        sqlConnection sqlConnect = new sqlConnection();

        try {
            Boolean result = sqlConnect.ExecuteSql(insertSql);
            System.out.println(result);
            if (result){
                ResultSet resultSet = sqlConnect.ExecuteQuery(foundIdSql);
                if (resultSet.next()){
                    this.id = Integer.parseInt(resultSet.getString(1));
                    System.out.println(this.id);
                }
            }
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean buySpell(int player_id, Spell spell){
        String insertSql = String.format("INSERT INTO player_spells (player_id,spell_id,spellCounter) VALUES (%s,%s,%s)" +
                "ON DUPLICATE KEY UPDATE spellCounter=spellCounter+1",player_id,spell.getId(),1);
        String decreaseSql = String.format("UPDATE player SET playerDiamondNumber = playerDiamondNumber- %s WHERE playerId=%s",spell.getPrice(),player_id);
        sqlConnection sqlConnect = new sqlConnection();
        try {
            Boolean result = sqlConnect.ExecuteSql(insertSql);
            if (result) result = sqlConnect.ExecuteSql(decreaseSql);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
