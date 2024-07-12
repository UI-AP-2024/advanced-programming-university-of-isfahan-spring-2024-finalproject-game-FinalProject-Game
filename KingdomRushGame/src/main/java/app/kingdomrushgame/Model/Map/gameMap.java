package app.kingdomrushgame.Model.Map;


import app.kingdomrushgame.Model.Raider.Point;
import app.kingdomrushgame.Model.Raider.Raider;
import app.kingdomrushgame.Model.graph.AdjacencyMapGraph;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@Setter
public class gameMap {
    private final List<Point> towersPath;
    private final AdjacencyMapGraph<Point,Integer> herosPath;
    private final Point endPoint;
    private final List<List<Raider>> attackWaves;
    private final int coins;



}

