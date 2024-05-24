package at.flappybird.game;

import static org.junit.jupiter.api.Assertions.*;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player = new Player();

    // 
    // void testHandleInput() {
    //     KeyEvent spaceKeyEvent =
    //         new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.SPACE, false,
    //                      false, false, false);
    //     double initialSpeed = player.getSpeed();
    //     player.handleInput(spaceKeyEvent);
    //     double updatedSpeed = player.getSpeed();
    //     assertEquals(initialSpeed - Data.Settings.jumpPower, updatedSpeed);
    // }
    //
    // @Test
    // void testApplyGravity() {
    //     double initialY = player.getImageView().getY();
    //     player.applyGravity();
    //     double updatedY = player.getImageView().getY();
    //     assertNotEquals(initialY, updatedY);
    // }

    @Test
    void testRestart() {
        player.restart();
        assertEquals(1, player.getSpeed());
        assertEquals(100, player.getImageView().getY());
    }
}
