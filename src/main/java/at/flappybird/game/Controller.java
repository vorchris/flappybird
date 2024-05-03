package at.flappybird.game;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends AnimationTimer implements Initializable{
    @FXML
    Pane pane;
    PipeMover pm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("loading...");
        pm = new PipeMover(1000, 500, 100);
        pane.getChildren().add(pm);
        this.start();
    }


    @Override
    public void handle(long l) {
        pm.movePipes(-1);
    }
}