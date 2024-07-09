package app.kingdomrushgame.Controller;

import app.kingdomrushgame.Model.Player.Player;
import app.kingdomrushgame.Model.Spell.Spell;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class playerController {
    @Getter
    private static Player currentPlayer;
    public static boolean Signup(String userName,String password){
        currentPlayer = new Player(userName,password);
        return currentPlayer.signup();
    }

    public static boolean Login(String userName,String password){
        currentPlayer = new Player(userName,password);
        return currentPlayer.login();
    }

    public static boolean buySpell(Spell spell){
        if (currentPlayer.getDiamondNumber()>=spell.getPrice()){
            boolean result = currentPlayer.buySpell(currentPlayer.getId(), spell);
            if (result) currentPlayer.setDiamondNumber(currentPlayer.getDiamondNumber()- spell.getPrice());
            return result;
        }
        else return false;
    }

}
