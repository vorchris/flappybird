package at.flappybird.game;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import lombok.Getter;

public class Bird {
    @Getter @FXML private ImageView imageView;
    @Getter private double speed;
    @Getter private boolean hitboxOn = true;

    public Bird() {
        speed = 0;
        imageView = new ImageView(Data.Images.bird);
        imageView.setX(250);
        imageView.setY(100);
    }

    public void handleInput(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.SPACE) {
            jump();
        } else if (keyEvent.getCode() == KeyCode.SHIFT) {
            hitboxOn = !hitboxOn;
        }
    }

    public void jump() {
        Media sound = new Media(new File(Data.Sounds.flap).toURI().toString());
        MediaPlayer flapPlayer = new MediaPlayer(sound);
        flapPlayer.play();
        speed = -Data.Settings.jumpPower;
    }

    public void fall() { speed += Data.Settings.gravity; }

    public void move() {
        fall();
        imageView.setY(imageView.getY() + speed);
    }

    public boolean passed(int x) { return imageView.getX() > x; }

    public boolean outOfBounds() {
        return (imageView.getY() < 0 || imageView.getY() > Data.Settings.height) && hitboxOn;
    }

    public boolean colliding(Pipe pipe) {
        return (imageView.getBoundsInParent().intersects(
                   pipe.getTop().getBoundsInParent()) ||
            imageView.getBoundsInParent().intersects(
                pipe.getBottom().getBoundsInParent())) && !hitboxOn;
    }

    public void reset() {
        speed = 0;
        imageView.setX(250);
        imageView.setY(100);
    }
}
