package app.kingdomrushgame.Controller;

import app.kingdomrushgame.Model.Player.Player;

public class playerController {
    public static String Signup(String userName,String password){
        Player player = new Player(userName,password);
        player.signup();
        return "kir";
    }
}
