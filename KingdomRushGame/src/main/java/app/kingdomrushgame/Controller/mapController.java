package app.kingdomrushgame.Controller;

import app.kingdomrushgame.Model.Map.gameMap;
import app.kingdomrushgame.Model.Raider.Point;
import app.kingdomrushgame.Model.Raider.Raider;
import app.kingdomrushgame.Model.graph.AdjacencyMapGraph;
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
        /////////////////////////

        Point endPoint  = new Point(1190,330);

        AdjacencyMapGraph<Point,Integer> adjacencyMapGraph = new AdjacencyMapGraph<>(true);

        List<List<Raider>> attackWaves = new ArrayList<>();

        map = new gameMap(towersPoint, adjacencyMapGraph, endPoint,attackWaves,400);
    }

}
