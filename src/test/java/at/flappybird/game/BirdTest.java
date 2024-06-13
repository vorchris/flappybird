package at.flappybird.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class BirdTest extends ApplicationTest {
    private Bird bird;

    @BeforeEach
    public void start(Stage stage) {
        bird = new Bird();
    }

    @Test
    public void testJump() {
        bird.jump();
        assertEquals(-Data.Settings.jumpPower, bird.getSpeed());
    }

    @Test
    public void testFall() {
        double initialSpeed = bird.getSpeed();
        bird.fall();
        assertEquals(initialSpeed + Data.Settings.gravity, bird.getSpeed());
    }

    @Test
    public void testMove() {
        double initialY = bird.getImageView().getY();
        bird.move();
        assertEquals(initialY + bird.getSpeed(), bird.getImageView().getY());
    }

    @Test
    public void testReset() {
        bird.jump();
        bird.reset();
        assertEquals(0, bird.getSpeed());
        assertEquals(250, bird.getImageView().getX());
        assertEquals(100, bird.getImageView().getY());
    }
}
