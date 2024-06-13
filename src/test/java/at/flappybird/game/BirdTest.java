package at.flappybird.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class BirdTest extends ApplicationTest {
    Bird bird;

    @BeforeEach
    void setUp() {
        bird = new Bird();
    }

    @Test
    void jump() {
        bird.jump();
        assertEquals(-Data.Settings.jumpPower, bird.getSpeed());
    }

    @Test
    void fall() {
        double initialSpeed = bird.getSpeed();
        bird.fall();
        assertEquals(initialSpeed + Data.Settings.gravity, bird.getSpeed());
    }

    @Test
    void outOfBounds() {
        bird.getImageView().setY(-10);
        assertTrue(bird.outOfBounds());
        bird.getImageView().setY(Data.Settings.height + 10);
        assertTrue(bird.outOfBounds());
    }

    @Test
    void reset() {
        bird.reset();
        assertEquals(0, bird.getSpeed());
        assertEquals(250, bird.getImageView().getX());
        assertEquals(100, bird.getImageView().getY());
    }
}
