package app.kingdomrushgame.Model.Player;
import java.sql.ResultSet;
import java.util.*;

import app.kingdomrushgame.DataBase.sqlConnection;
import app.kingdomrushgame.Model.Spell.*;
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

    public boolean login(){
        String playerSql = String.format("SELECT playerId,playerLevel,playerDiamondNumber" +
                " From player WHERE playerName= '%s' AND playerPassword='%s'",this.name,this.password);
        String backpackSql = String.format("SELECT spell_id,spellCounter FROM player_spells" +
                " WHERE player_id=%s",this.id);
        sqlConnection sqlConnect = new sqlConnection();
        try{
            ResultSet resultSet = sqlConnect.ExecuteQuery(playerSql);
            if (resultSet.next()){
                this.id = resultSet.getInt(1);
                this.level = Integer.parseInt(resultSet.getString(2));
                this.diamondNumber = Integer.parseInt(resultSet.getString(3));
                ResultSet resultBackPack = sqlConnect.ExecuteQuery(backpackSql);
                while(resultBackPack.next()){
                    int spellId = resultBackPack.getInt(1);
                    int spellCounter = resultBackPack.getInt(2);
                    if (spellId ==1){
                        for (int i = 0; i < spellCounter; i++) {
                            this.backpack.add(new SpellHealth());
                        }
                    }
                    else if (spellId ==3){
                        for (int i = 0; i < spellCounter; i++) {
                            this.backpack.add(new SpellCoin());
                        }
                    }
                    else if (spellId ==4){
                        for (int i = 0; i < spellCounter; i++) {
                            this.backpack.add(new SpellFreeze());
                        }
                    }
                    else if (spellId ==5){
                        for (int i = 0; i < spellCounter; i++) {
                            this.backpack.add(new SpellLittleBoy());
                        }
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean buySpell(int player_id, Spell spell){
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
