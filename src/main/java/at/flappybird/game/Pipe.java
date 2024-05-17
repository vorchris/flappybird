package at.flappybird.game;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

public class Pipe extends Group {
    @Getter
    int x;
    int amount;
    int height;

    ArrayList<ImageView> allImages = new ArrayList<>();
    public Pipe(int height) {
        this.amount = height / 32 + 1;
        this.height = height;

        int opening = getRandomGap();
        for(int i = 0; i < amount; i++) {
            if(i != opening && i != opening + 1){
                ImageView iw = new ImageView(Data.Images.pipeBody);
                allImages.add(iw);
                iw.setFitHeight(32);
                iw.setFitWidth(32);
                iw.setX(0);
                iw.setY(i * 32);
                this.getChildren().add(iw);
            }
        }
        ImageView top = new ImageView(Data.Images.pipeTop);
        ImageView bottom = new ImageView(Data.Images.pipeTop);

        allImages.add(top);
        allImages.add(bottom);

        top.setX(0);
        bottom.setX(0);

        top.setFitHeight(32);
        top.setFitWidth(32);
        top.setScaleY(-1);

        bottom.setFitHeight(32);
        bottom.setFitWidth(32);

        top.setY((opening - 1) * 32);
        bottom.setY((opening + 2) * 32);
        this.getChildren().addAll(top, bottom);
    }
    private int getRandomGap(){
        Random rand = new Random();
        return rand.nextInt(3,amount-1);
    }
    public void setX(int x){
        this.x = x;
        allImages.forEach(a -> a.setX(x));
    }

    public boolean colliding(ImageView iw){
        Bounds b1 = iw.getBoundsInParent();
        for(ImageView imageView : allImages){
            Bounds b2 = imageView.getBoundsInParent();
            if(b1.intersects(b2)){
                return true;
            }
        }
        return false;
    }
}
