module app.kingdomrushgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;


    opens app.kingdomrushgame to javafx.fxml;
    opens app.kingdomrushgame.View to javafx.fxml;
    exports app.kingdomrushgame;
    exports app.kingdomrushgame.View;
}