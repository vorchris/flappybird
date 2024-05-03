package at.flappybird.game;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Pipe extends Group {
    int amount;
    int height;
    int width;
    public Pipe(int amount, int height, int width) {
        this.amount = amount;
        this.height = height;
        this.width = width;

        ImageView top = new ImageView(Data.Images.pipeTop);
        ImageView bottom = new ImageView(Data.Images.pipeTop);


    }
    private int getRandomGap(){
        Random rand = new Random();
        return rand.nextInt(2,amount);
    }
}
