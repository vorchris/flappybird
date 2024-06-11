package at.flappybird.game;

import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;

public class Pipe {
    @Getter @Setter private int x;
    @Getter
    private ImageView top = new ImageView(Data.Images.pipe);
    @Getter
    private ImageView bottom = new ImageView(Data.Images.pipe);
    private static final int gap = 100;

    public Pipe(int x) {
        this.x = x;

        int topY = (int)(Math.random() * (1000 - gap));
        int bottomY = topY + gap;
        top.setRotate(180);
        top.setY(topY);
        bottom.setY(bottomY);
    }

    public boolean colliding(ImageView player) {
        ImageView pipeTopImageView = this.top;
        ImageView pipeBottomImageView = this.bottom;
        return player.getBoundsInParent().intersects(
                   pipeTopImageView.getBoundsInParent()) ||
            player.getBoundsInParent().intersects(
                pipeBottomImageView.getBoundsInParent());
    }
}
