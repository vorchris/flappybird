module at.flappybird.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens at.flappybird.game to javafx.fxml;
    exports at.flappybird.game;
}
