package at.flappybird.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player = new Player();

    @Test
    void testRestart() {
        player.restart();
        assertEquals(100, player.getImageView().getY());
    }
}
