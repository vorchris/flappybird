package at.flappybird.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class PipeTest extends ApplicationTest {
    Pipe pipe;

    @BeforeEach
    void setUp() {
        pipe = new Pipe(500);
    }

    @Test
    void randomGap() {
        pipe.randomGap();
        assertTrue(pipe.getTop().getY() < Data.Settings.maxHeight);
        assertTrue(pipe.getTop().getY() > Data.Settings.minHeight -
                          pipe.getTop().getImage().getHeight());
    }

    @Test
    void move() {
        double initialX = pipe.getX();
        pipe.move(10);
        assertEquals(initialX - 10, pipe.getX());
        assertEquals(initialX - 10, pipe.getTop().getX());
        assertEquals(initialX - 10, pipe.getBottom().getX());
    }

    @Test
    void testInit() {
        pipe.init();
        assertFalse(pipe.isPassed());
        assertTrue(pipe.getTop().getY() < Data.Settings.maxHeight);
        assertTrue(pipe.getTop().getY() > Data.Settings.minHeight -
                          pipe.getTop().getImage().getHeight());
    }
}
