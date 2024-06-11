package at.flappybird.game;

import static org.junit.jupiter.api.Assertions.*;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class PipeMoverTest extends ApplicationTest {
    private PipeMover pipeMover;

    // @Override
    // public void start(Stage stage) {
    //     pipeMover = new PipeMover(1000, 500, 500);
    // }
    //
    // @Test
    // void testInitPipes() {
    //     assertEquals(2, pipeMover.getPipes().size());
    // }
    //
    // @Test
    // void testRestart() {
    //     pipeMover.restart();
    //     assertEquals(0, pipeMover.getScore());
    //     assertEquals(2, pipeMover.getPipes().size());
    // }
}
