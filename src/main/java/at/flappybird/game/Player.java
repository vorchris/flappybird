package at.flappybird.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class Player {
  private ImageView player;

  public Player() { player = new ImageView(Data.Images.bird); }

  public void handleInput(KeyEvent event) {
    if (event.getCode() == KeyCode.SPACE) {
      player.setY(player.getY() + Data.Settings.jumpPower);
    } else {
      Timeline timeline = new Timeline(
              new KeyFrame(Duration.millis(Data.Settings.delay), e -> {
                player.setY(player.getY() - Data.Settings.gravity);
              })
      );
      timeline.play();
    }
  }

  public ImageView getPlayer() {
    return player;
  }
}
