package app.kingdomrushgame.Controller;
import javafx.scene.media.*;
import lombok.Getter;
@Getter
public class musicController {

    private static musicController musicController;

    private Media media = new Media("file:///C:/Users/Saba/Desktop/kingdom%20rush%20tower%20images/01.%20Main%20Theme.mp3");
    private MediaPlayer mediaPlayer = new MediaPlayer(media);
    private musicController(){
    }

    public static musicController getMusicController() {
        if (musicController==null){
            musicController = new musicController();
        }
        return musicController;
    }

    public static void main(String[] args) {

    }


}
