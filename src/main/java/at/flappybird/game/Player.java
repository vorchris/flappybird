package at.flappybird.game;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lombok.Getter;

public class Player {
    @Getter @FXML private ImageView imageView;

    @Getter private double speed = 1;

    public Player() {
        imageView = new ImageView(Data.Images.bird);
        imageView.setX(Data.Settings.spawnPlayerX);
        imageView.setY(Data.Settings.spawnPlayerY);
    }

    public void handleInput(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            speed -=
                Data.Settings
                    .jumpPower; // Change to speed = -Data.Settings.jumpPower
                                // for typical Flappybird Physics
        }
    }

    public void applyGravity() {
        speed += Data.Settings.gravity;
        imageView.setY(imageView.getY() + speed);
    }

    public void restart() {
        speed = 2;
        imageView.setY(100);
    }
}
