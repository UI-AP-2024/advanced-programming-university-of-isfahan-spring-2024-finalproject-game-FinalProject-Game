package app.kingdomrushgame.Controller;

import app.kingdomrushgame.Model.Map.gameMap;
import app.kingdomrushgame.Model.Tower.ArcherTower;
import app.kingdomrushgame.Model.Tower.ArtilleryTower;
import app.kingdomrushgame.Model.Tower.Tower;
import app.kingdomrushgame.Model.Tower.WizardTower;

public class towerController {
    private static Tower tower;

    public static int makeTower(String towerType, Integer coin) {
        if (towerType.equals("Archer")) {
            tower = new ArcherTower();
        } else if (towerType.equals("Wizard")) {
            tower = new WizardTower();
        } else if (towerType.equals("Artillery")) {
            tower = new ArtilleryTower();
        }
        if (coin >= tower.getPrice()) {
            coin -= tower.getPrice();
            return coin;
        }
        return -1;
    }

    public static int upgrade(int coin){
        if (coin>=110){
            coin-=110;
            return coin;
        }
        return -1;
    }
}
