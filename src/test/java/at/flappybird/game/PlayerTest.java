package at.flappybird.game;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
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
    public void testIsJumpDelayOver() {
        player.setLastJumpTime(Instant.now().minusMillis(301));
        assertTrue(player.isJumpDelayOver());
    }

    @Test
    public void testApplyGravity() {
        double initialSpeed = player.getSpeed();
        player.applyGravity();
        assertTrue(player.getSpeed() > initialSpeed);
    }

    @Test
    void testRestart() {
        player.restart();
        assertEquals(0, player.getSpeed());
        assertEquals(Data.Settings.spawnPlayerX, player.getImageView().getX());
        assertEquals(Data.Settings.spawnPlayerY, player.getImageView().getY());
    }
}
