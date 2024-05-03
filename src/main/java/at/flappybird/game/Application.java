package at.flappybird.game;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader =
        new FXMLLoader(Application.class.getResource("hello-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 1000, 500);
    stage.setTitle("Flappybird");
    stage.setScene(scene);
    stage.show();

    Controller cont = fxmlLoader.getController();
    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
      @Override
      public void handle(javafx.scene.input.KeyEvent keyEvent) {
        cont.keyPressed(keyEvent);
      }
    });
  }

  public static void main(String[] args) { launch(); }
}
