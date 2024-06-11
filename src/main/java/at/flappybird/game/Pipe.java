package at.flappybird.game;

import java.util.Random;
import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;

public class Pipe {
    @Getter @Setter private int x;
    @Getter private ImageView top = new ImageView(Data.Images.pipe);
    @Getter private ImageView bottom = new ImageView(Data.Images.pipe);
    @Getter @Setter private boolean passed;
    private static Random random = new Random();

    public Pipe(int x) {
        this.x = x;
        passed = false;
        randomGap();
    }

    public void randomGap() {
        int height =
            Data.Settings.minHeight +
            random.nextInt(Data.Settings.maxHeight - Data.Settings.minHeight);
        top.setY(height - top.getImage().getHeight());
        top.setScaleY(-1);
        bottom.setY(height + Data.Settings.gap);
    }

    public boolean colliding(ImageView bird) {
        return bird.getBoundsInParent().intersects(top.getBoundsInParent()) ||
            bird.getBoundsInParent().intersects(bottom.getBoundsInParent());
    }

    public void move(double speed) {
        x -= speed;
        top.setX(x);
        bottom.setX(x);
    }

    public void init() {
        randomGap();
        passed = false;
    }
}
