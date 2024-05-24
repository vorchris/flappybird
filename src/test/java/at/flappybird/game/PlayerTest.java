package at.flappybird.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.scene.image.ImageView;
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
    void restart() {
        player.restart();
        assertEquals(2, player.getSpeed());
        assertEquals(100, player.getImageView().getY());
    }
}
