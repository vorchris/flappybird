# Flappy Bird Game Documentation

## Package: `at.flappybird.game`

This package contains the main classes for a Flappy Bird.

### `Application` Class

- **Extends:** `javafx.application.Application`
- **Description:** Initializes the primary stage and sets up the game scene.
- **Methods:**
    - `start(Stage stage)`: Loads the FXML layout, sets up the scene, and displays the stage. Handles key events to control the game.
    - `main(String[] args)`: Entry point of the application which launches the JavaFX application.

### `Controller` Class

- **Extends:** `AnimationTimer`
- **Implements:** `Initializable`
- **FXML Components:** `Pane pane`, `Label scoreLabel`, `Label gameOverLabel`, `Button restartButton`, `Button quitButton`
- **Description:** Controls the game logic, animation, and UI updates.
- **Methods:**
    - `initialize(URL url, ResourceBundle resourceBundle)`: Initializes the game components and starts the game timer.
    - `handle(long now)`: Game loop that updates player movements, checks collisions, and updates the score.
    - `displayDead()`: Shows game over screen.
    - `quit()`: Exits the application.
    - `restart()`: Resets the game to its initial state.
    - `keyPressed(KeyEvent keyEvent)`: Handles player input.

### `Data` Class

- **Description:** Holds game settings and image resources.
- **Nested Classes:**
    - `Images`: Contains paths to image files.
    - `Settings`: Contains game settings like gravity, jump power, etc.

### `Pipe` Class

- **Extends:** `Group`
- **Fields:** `int x, amount, height`
- **Description:** Represents a single pipe in the game, capable of checking collisions.
- **Methods:**
    - `Pipe(int height)`: Constructor that initializes the pipe with a given height.
    - `colliding(ImageView iw)`: Checks collision with the player.
    - `setX(int x)`: Updates the x position of the pipe.
    - `delete()`: Removes pipe images from the view.

### `PipeMover` Class

- **Extends:** `Group`
- **Fields:** `int width, height, distBetweenPillars, amountOfPipes`
- **Description:** Manages all pipes and their movement.
- **Methods:**
    - `initPipes()`: Initializes the pipes based on the game's width.
    - `movePipes()`: Moves the pipes and checks for off-screen pipes to recycle them.
    - `colliding(ImageView iw)`: Checks if any pipe is colliding with the player.
    - `restart()`: Resets all pipes to the initial state.

### `Player` Class

- **Fields:** `ImageView imageView`
- **Description:** Represents the player's character.
- **Methods:**
    - `handleInput(KeyEvent event)`: Handles player input to control jumping.
    - `applyGravity()`: Applies gravity to the player, causing it to fall.
    - `restart()`: Resets the player's position and speed.
    - `getImageView()`: Returns the player's image view.
