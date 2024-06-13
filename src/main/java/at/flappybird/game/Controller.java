package at.flappybird.game;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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

    Bird bird = new Bird();
    boolean dead = false;
    Pipe pipes[] = new Pipe[3];
    int score = 0;
    double pipeSpeed = Data.Settings.pipeSpeed;
    Media themeSong = new Media(new File(Data.Sounds.themeSong).toURI().toString());
    MediaPlayer themeSongPlayer = new MediaPlayer(themeSong);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        themeSongPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        pane.setBackground(new Background(backgroundImage));

        gameOverLable.toFront();
        restartButton.toFront();
        quitButton.toFront();

        init();

        this.start();
    }

    @Override
    public void handle(long l) {
        themeSongPlayer.play();

        if (!dead) {
            bird.move();
            movePipes();

            for (Pipe pipe : pipes) {
                if (bird.passed(pipe.getX()) && !pipe.isPassed()) {
                    pipe.setPassed(true);
                    score++;
                    scoreLabel.setText("Score: " + score);
                    Media point = new Media(new File(Data.Sounds.point).toURI().toString());
                    MediaPlayer pointPlayer = new MediaPlayer(point);
                    pointPlayer.play();
                }
                if (bird.colliding(pipe)) {
                    dead = true;
                    Media die = new Media(new File(Data.Sounds.die).toURI().toString());
                    MediaPlayer diePlayer = new MediaPlayer(die);
                    diePlayer.play();
                }
            }

            if (bird.outOfBounds()) {
                dead = true;
                Media die = new Media(new File(Data.Sounds.die).toURI().toString());
                MediaPlayer diePlayer = new MediaPlayer(die);
                diePlayer.play();
            }
        } else if (dead) {
            pane.getChildren().remove(bird.getImageView());
            pane.getChildren().remove(pipes[0].getTop());
            pane.getChildren().remove(pipes[0].getBottom());
            pane.getChildren().remove(pipes[1].getTop());
            pane.getChildren().remove(pipes[1].getBottom());
            pane.getChildren().remove(pipes[2].getTop());
            pane.getChildren().remove(pipes[2].getBottom());
            gameOverLable.setVisible(true);
            restartButton.setVisible(true);
            quitButton.setVisible(true);
        }
    }

    public void keyPressed(KeyEvent keyEvent) { bird.handleInput(keyEvent); }

    public void quit() { System.exit(0); }

    public void init() {
        dead = false;
        score = 0;
        pipeSpeed = Data.Settings.pipeSpeed;
        scoreLabel.setText("Score: " + score);

        pane.getChildren().add(bird.getImageView());
        for (int i = 0; i < 3; i++) {
            pipes[i] = new Pipe(1000 + i * Data.Settings.width / 3);
            pane.getChildren().add(pipes[i].getTop());
            pane.getChildren().add(pipes[i].getBottom());
        }

        gameOverLable.setVisible(false);
        restartButton.setVisible(false);
        quitButton.setVisible(false);

        bird.reset();
    }

    public void movePipes() {
        for (Pipe pipe : pipes) {
            pipe.move(pipeSpeed);
            if (pipe.getX() < 0) {
                pipe.setX(Data.Settings.width);
                pipe.init();
            }
            pipeSpeed = pipeSpeed * 1.0001;
        }
    }
}
