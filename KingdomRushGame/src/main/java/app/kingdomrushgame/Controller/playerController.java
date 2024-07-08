package app.kingdomrushgame.Controller;

import app.kingdomrushgame.Model.Player.Player;
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

}
