package at.flappybird.game;

import java.util.ArrayList;
import java.util.stream.IntStream;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PipeMover extends Group {
    int width, height, distBetweenPillars, amountOfPipes;
    ArrayList<Pipe> pipes = new ArrayList<>();
    int score = 0;

    public PipeMover(int width, int height, int distBetweenPillars) {
        this.width = width;
        this.height = height;
        this.distBetweenPillars = distBetweenPillars;
        initPipes();
    }

    private void initPipes() {
        amountOfPipes =
            IntStream.iterate(width, w -> w - distBetweenPillars - 32)
                .takeWhile(w -> w > 0)
                .map(w -> 1)
                .sum();
        IntStream.range(0, amountOfPipes).forEach(this::addPipeAtIndex);
    }

    private void addPipeAtIndex(int index) {
        Pipe p = new Pipe(height);
        p.setX(calculateInitialPipeX(index));
        pipes.add(p);
        this.getChildren().add(p);
    }

    private int calculateInitialPipeX(int index) {
        return width + (index * (distBetweenPillars + 32));
    }

    public void movePipes() { pipes.forEach(this::updatePipePosition); }

    private void updatePipePosition(Pipe p) {
        p.setX(p.getX() - at.flappybird.game.Data.Settings.pipeSpeed);
        if (p.getX() < -32) {
            rearrangePipe(p);
        }
    }

    private void rearrangePipe(Pipe p) {
        this.getChildren().remove(p);
        pipes.remove(p);
        createAndAddNewPipe();
    }

    private void createAndAddNewPipe() {
        Pipe newPipe = new Pipe(height);
        newPipe.setX(width);
        pipes.add(newPipe);
        this.getChildren().add(newPipe);
        score++;
    }

    public boolean colliding(ImageView iw) {
        return pipes.stream().anyMatch(p -> p.colliding(iw));
    }

    public void restart() {
        pipes.forEach(p -> {
            this.getChildren().remove(p);
            p.delete();
        });
        score = 0;
        pipes.clear();
        initPipes();
    }
}
