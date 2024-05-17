package at.flappybird.game;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
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
    private void initPipes(){
        amountOfPipes = width / (distBetweenPillars + 32) + 1;
        System.out.println(amountOfPipes);
        for(int i = 0; i < amountOfPipes; i++){
            Pipe p = new Pipe(height);
            p.setX(width + (i * (distBetweenPillars + 32)));
            pipes.add(p);
            this.getChildren().add(p);
        }
    }
    public void movePipes(){
        for(int i = 0; i < amountOfPipes; i++){
            Pipe p = pipes.get(i);
            p.setX(p.getX() - at.flappybird.game.Data.Settings.pipeSpeed);
            if(p.getX() < -32){
                p.setX(width);
                score++;
                System.out.println(score);
            }
        }
    }

    public boolean colliding(ImageView iw){
        return pipes.stream().anyMatch(x -> x.colliding(iw));
    }
    public void restart(){
        pipes.forEach(Pipe::delete);
        pipes.clear();
        initPipes();
    }
}
