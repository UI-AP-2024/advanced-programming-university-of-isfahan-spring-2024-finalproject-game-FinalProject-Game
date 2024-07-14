package app.kingdomrushgame.Controller;

import app.kingdomrushgame.Model.Map.gameMap;
import app.kingdomrushgame.Model.Raider.Point;
import app.kingdomrushgame.Model.Raider.Raider;
import app.kingdomrushgame.Model.Raider.RaiderArmor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class mapController {
    @Getter
    private static gameMap map;

    public static void startMap(){
        //// Towers Path //////
        List<Point>  towersPoint = new ArrayList<>();
        towersPoint.add(new Point(428,108));
        towersPoint.add(new Point(358,135));
        towersPoint.add(new Point(436,239));
        towersPoint.add(new Point(436,306));
        towersPoint.add(new Point(519,305));
        towersPoint.add(new Point(574,403));
        towersPoint.add(new Point(667,312));
        towersPoint.add(new Point(795,376));
        /////////////////////////////

        Point endPoint  = new Point(1190,330);

        ////// Heroes Path //////////
        List<List<Point>> heroesPath = new ArrayList<>();

        List<Point> heroPath = new ArrayList<>();
        heroPath.add(new Point(551,3));
        heroPath.add(new Point(515,190));
        heroPath.add(new Point(388,245));
        heroPath.add(new Point(390,375));
        heroPath.add(new Point(606,381));
        heroPath.add(new Point(713,405));
        heroPath.add(new Point(821,318));
        heroPath.add(endPoint);
        heroesPath.add(heroPath);
        /////////////////////////////



        ////// Raiders /////////////
        List<List<Raider>> attackWaves = new ArrayList<>();

        List<Raider> attackWave1 = new ArrayList<>();
        Raider raider1 = new RaiderArmor(heroPath);
        Raider raider2 = new RaiderArmor(heroPath);
        Raider raider3 = new RaiderArmor(heroPath);
        Raider raider4 = new RaiderArmor(heroPath);
        Raider raider5 = new RaiderArmor(heroPath);
        Raider raider6 = new RaiderArmor(heroPath);
        attackWave1.add(raider1);
        attackWave1.add(raider2);
        attackWave1.add(raider3);
        attackWave1.add(raider4);
        attackWave1.add(raider5);
        attackWave1.add(raider6);

        attackWaves.add(attackWave1);


        map = new gameMap(towersPoint, heroesPath, endPoint,attackWaves,400);
    }

}
