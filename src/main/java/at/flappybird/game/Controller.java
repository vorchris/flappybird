package at.flappybird.game;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class Controller extends AnimationTimer implements Initializable {
    @FXML Pane pane;
    @FXML Label scoreLabel;
    @FXML Label gameOverLable;
    @FXML Button restartButton;
    @FXML Button quitButton;
    @FXML Image bgImage = new Image(Data.Images.background);
    @FXML
    BackgroundImage backgroundImage =
        new BackgroundImage(bgImage, null, BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    @FXML ImageView base = new ImageView(Data.Images.base);

    Bird bird = new Bird();
    boolean dead = false;
    ArrayList<Pipe> pipes = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pane.setBackground(new Background(backgroundImage));
        pane.getChildren().add(bird.getImageView());

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
            bird.move();

            if (bird.outOfBounds()) {
                dead = true;
            }
            for (Pipe pipe : pipes) {
                if (bird.colliding(pipe)) {
                    dead = true;
                }
            }
        } else if (dead) {
            gameOverLable.setVisible(true);
            restartButton.setVisible(true);
            quitButton.setVisible(true);
        }
    }

    public void quit() { System.exit(0); }

    public void restart() {
        dead = false;

        gameOverLable.setVisible(false);
        restartButton.setVisible(false);
        quitButton.setVisible(false);

        bird.reset();
    }

    public void keyPressed(KeyEvent keyEvent) { bird.handleInput(keyEvent); }
}
