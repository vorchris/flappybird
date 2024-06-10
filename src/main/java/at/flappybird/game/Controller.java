package at.flappybird.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Controller extends AnimationTimer implements Initializable {
    @FXML Pane pane;
    @FXML Label scoreLabel;

    @FXML Label gameOverLable;
    @FXML Button restartButton;
    @FXML Button quitButton;

    Player player = new Player();
    PipeMover pm = new PipeMover(1000, 500, 700);
    boolean dead = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("loading...");
        pane.getChildren().add(player.getImageView());
        pane.getChildren().add(pm);
        gameOverLable.setVisible(false);
        restartButton.setVisible(false);
        quitButton.setVisible(false);
        gameOverLable.toFront();
        restartButton.toFront();
        quitButton.toFront();
        this.start();
    }

    @Override
    public void handle(long l) {
        if (!dead) {
            pm.movePipes();
            player.applyGravity();
            scoreLabel.setText("Score: " + pm.getScore());
            if (pm.colliding(player.getImageView())) {
                dead = true;
                gameOverLable.setVisible(true);
                restartButton.setVisible(true);
                quitButton.setVisible(true);
            }
        }
    }

    public void quit() { System.exit(0); }

    public void restart() {
        player.restart();
        pm.restart();
        dead = false;

        gameOverLable.setVisible(false);
        restartButton.setVisible(false);
        quitButton.setVisible(false);
    }

    public void keyPressed(KeyEvent keyEvent) { player.handleInput(keyEvent); }
}
