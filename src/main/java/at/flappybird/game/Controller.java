package at.flappybird.game;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends AnimationTimer implements Initializable{
    @FXML
    Pane pane;

    Player player = new Player();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("loading...");
        pane.getChildren().add(player.getImageView());
        player.getImageView().setX(100);
        player.getImageView().setY(100);
    }

    @Override
    public void handle(long l) {
        player.applyGravity(); // todo
    }

    public void keyPressed(KeyEvent keyEvent) {
        player.handleInput(keyEvent);
    }
}