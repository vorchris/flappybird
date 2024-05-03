package at.flappybird.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class Player {
  @FXML
  private ImageView imageView;

  public Player() {
    imageView = new ImageView(Data.Images.bird);
  }

  public void handleInput(KeyEvent event) {
    if (event.getCode() == KeyCode.SPACE) {
      Timeline timeline = new Timeline(
              new KeyFrame(Duration.millis(Data.Settings.delay), e -> {
                imageView.setY(imageView.getY() - Data.Settings.jumpPower);
              })
      );
      timeline.play();
    }
  }

  public void applyGravity() {
    imageView.setY(imageView.getY() + Data.Settings.gravity);
  }

  public ImageView getImageView() {
    return imageView;
  }
}
