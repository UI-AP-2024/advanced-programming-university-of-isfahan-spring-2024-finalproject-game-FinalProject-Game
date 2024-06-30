module app.kingdomrushgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.kingdomrushgame to javafx.fxml;
    exports app.kingdomrushgame;
}