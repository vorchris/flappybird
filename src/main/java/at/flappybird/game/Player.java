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
  private ImageView imageView;;
  private double speed = 1;

  public Player() {
    imageView = new ImageView(Data.Images.bird);
  }

  public void handleInput(KeyEvent event) {
    if (event.getCode() == KeyCode.SPACE) {
      speed -= Data.Settings.jumpPower; //Change to speed = -Data.Settings.jumpPower for typical Flappybird Physics
    }
  }

  public void applyGravity() {
    speed += Data.Settings.gravity;
    imageView.setY(imageView.getY() + speed);
  }

  public ImageView getImageView() {
    return imageView;
  }
}
