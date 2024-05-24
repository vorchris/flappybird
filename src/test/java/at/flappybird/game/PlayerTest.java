package at.flappybird.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class PlayerTest extends ApplicationTest {
    private Player player;

    @Override
    public void start(Stage stage) {
        player = new Player();
    }

    @Test
    public void testHandleInput() {
        KeyEvent keyEvent =
            new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.SPACE, false,
                         false, false, false);
        double initialSpeed = player.getSpeed();
        player.handleInput(keyEvent);
        assertEquals(initialSpeed - Data.Settings.jumpPower, player.getSpeed());
    }

    @Test
    public void testApplyGravity() {
        double initialSpeed = player.getSpeed();
        double initialY = player.getImageView().getY();
        player.applyGravity();
        assertEquals(initialSpeed + Data.Settings.gravity, player.getSpeed());
        assertEquals(initialY + initialSpeed + Data.Settings.gravity,
                     player.getImageView().getY());
    }

    @Test
    void testRestart() {
        player.restart();
        assertEquals(2, player.getSpeed());
        assertEquals(100, player.getImageView().getY());
    }
}
