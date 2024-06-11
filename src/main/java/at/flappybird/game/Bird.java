package at.flappybird.game;

import javafx.fxml.FXML; import javafx.scene.image.ImageView; import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lombok.Getter;

public class Bird {
    @Getter @FXML private ImageView imageView;
    @Getter private double speed;

    public Bird() {
        speed = 0;
        imageView = new ImageView(Data.Images.bird);
        imageView.setX(250);
        imageView.setY(100);
    }

    public void handleInput(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.SPACE) {
            jump();
        }
    }

    public void jump() { speed = -Data.Settings.jumpPower; }

    public void fall() { speed += Data.Settings.gravity; }

    public void move() {
        fall();
        imageView.setY(imageView.getY() + speed);
    }

    public boolean outOfBounds() {
        return imageView.getY() < 0 || imageView.getY() > Data.Settings.height;
    }

    public boolean colliding(Pipe pipe) {
        return imageView.getBoundsInParent().intersects(pipe.getTop().getBoundsInParent()) ||
               imageView.getBoundsInParent().intersects(pipe.getBottom().getBoundsInParent());
    }

    public void reset() {
        speed = 0;
        imageView.setX(250);
        imageView.setY(100);
    }
}
