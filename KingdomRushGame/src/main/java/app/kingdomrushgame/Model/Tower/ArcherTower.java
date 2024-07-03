package app.kingdomrushgame.Model.Tower;
import lombok.*;

import java.lang.*;


@Getter
@Setter
public class ArcherTower extends Tower{
    private String path;
    public ArcherTower(){
        super(5,6,7, "null");
        this.path=null;
    }
    @Override
    public void defending() {

    }
    @Override
    public void upgrade() {

    }
    @Override
    public void spoilage() {

    }
}
