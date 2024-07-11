package app.kingdomrushgame.Model.Map;


import app.kingdomrushgame.Model.Raider.Point;
import app.kingdomrushgame.Model.Raider.Raider;
import app.kingdomrushgame.Model.graph.AdjacencyMapGraph;
import lombok.Getter;

import java.util.List;

@Getter
public class Map {
    private final List<Point> towersPath;
    private final AdjacencyMapGraph<Point,Integer> herosPath;
    private final Point endPoint;
    private final List<List<Raider>> attackWaves;
    private final int coins;

    public Map(List<Point> towersLocation, AdjacencyMapGraph<Point,Integer> herosPath,
               Point endPoint, List<List<Raider>> attackWaves, int coins) {
        this.towersPath = towersLocation;
        this.herosPath = herosPath;
        this.endPoint = endPoint;
        this.attackWaves = attackWaves;
        this.coins = coins;
    }
}

