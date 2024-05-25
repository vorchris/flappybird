package at.flappybird.game;

import java.time.Duration;
import java.time.Instant;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lombok.Getter;
import lombok.Setter;

public class Player {
    @Getter @FXML private ImageView imageView;
    @Getter @Setter private Instant lastJumpTime;
    @Getter private double speed;
    private Instant lastUpdateTime = Instant.now();

    public Player() {
        speed = 0;
        lastJumpTime = Instant.now();
        imageView = new ImageView(Data.Images.bird);
        imageView.setX(Data.Settings.spawnPlayerX);
        imageView.setY(Data.Settings.spawnPlayerY);
    }

    public void handleInput(KeyEvent event) {
        if (KeyCode.SPACE.equals(event.getCode())) {
            if (event.getEventType() == KeyEvent.KEY_PRESSED &&
                isJumpDelayOver()) {
                lastJumpTime = Instant.now();
                System.out.println("jump!");
                speed -= Data.Settings.jumpPower;
            }
        }
    }

    public boolean isJumpDelayOver() {
        Duration durationSinceLastJump =
            Duration.between(lastJumpTime, Instant.now());
        return durationSinceLastJump.toMillis() >= 300;
    }

    public void applyGravity() {
        double deltaTime =
            Duration.between(lastUpdateTime, Instant.now()).toMillis() / 1000.0;
        lastUpdateTime = Instant.now();
        speed += Data.Settings.gravity * deltaTime;
        imageView.setY(imageView.getY() + speed * deltaTime);
    }

    public void restart() {
        speed = 0;
        lastJumpTime = Instant.now();
        imageView.setX(Data.Settings.spawnPlayerX);
        imageView.setY(Data.Settings.spawnPlayerY);
    }
}
