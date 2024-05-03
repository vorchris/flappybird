package at.flappybird.game;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class PipeMover extends Group {
    int width, height, distBetweenPillars, amountOfPipes;
    ArrayList<Pipe> pipes = new ArrayList<>();
    public PipeMover(int width, int height, int distBetweenPillars) {
        this.width = width;
        this.height = height;
        this.distBetweenPillars = distBetweenPillars;

        amountOfPipes = width / (distBetweenPillars + 32) + 1;
        System.out.println(amountOfPipes);
        for(int i = 0; i < amountOfPipes; i++){
            Pipe p = new Pipe(height);
            p.setX(i * (distBetweenPillars + 32));
            pipes.add(p);
            this.getChildren().add(p);
        }
    }
    public void movePipes(int x){
        for(int i = 0; i < amountOfPipes; i++){
            Pipe p = pipes.get(i);
            p.setX(p.getX() + x);
            if(p.getX() < -32 || p.getX() > width){
                p.setX(width);
            }
        }
    }

    public boolean colliding(ImageView iw){
        return pipes.stream().anyMatch(x -> x.colliding(iw));
    }
}
