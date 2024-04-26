module at.flappybird.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.flappybird.game to javafx.fxml;
    exports at.flappybird.game;
}