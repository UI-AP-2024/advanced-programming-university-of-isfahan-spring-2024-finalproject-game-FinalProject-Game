module app.kingdomrushgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;



    opens app.kingdomrushgame to javafx.fxml;
    exports app.kingdomrushgame;
}