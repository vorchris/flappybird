package at.flappybird.game;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Pipe extends Group {
  @Getter int x, height;
  ArrayList<ImageView> allImages = new ArrayList<>();

  public Pipe(int height) {
    int amount = calculateAmount(height);
    this.height = height;
    int opening = getRandomGap(amount);

    IntStream.range(0, amount).forEach(i -> {
      if (!isOpening(i, opening)) {
        ImageView iw = createImageView(Data.Images.pipeBody, i);
        this.getChildren().add(iw);
        allImages.add(iw);
      }
    });

    ImageView top = createImageView(Data.Images.pipeTop, opening - 1);
    top.setScaleY(-1);
    ImageView bottom = createImageView(Data.Images.pipeTop, opening + 2);
    this.getChildren().addAll(top, bottom);
    allImages.add(top);
    allImages.add(bottom);
  }

  private int calculateAmount(int height) {
    return IntStream.iterate(height, h -> h - 32).takeWhile(h -> h > 0).map(h -> 1).sum();
  }

  private boolean isOpening(int index, int opening) {
    return index == opening || index == opening + 1;
  }

  private ImageView createImageView(String imagePath, int position) {
    ImageView iw = new ImageView(imagePath);
    iw.setFitHeight(32);
    iw.setFitWidth(32);
    iw.setX(0);
    iw.setY(position * 32);
    return iw;
  }

  private int getRandomGap(int amount){
    return new Random().ints(3, amount - 1).findFirst().getAsInt();
  }

  public void setX(int x){
    this.x = x;
    allImages.forEach(a -> a.setX(x));
  }

  public boolean colliding(ImageView iw){
    Bounds b1 = iw.getBoundsInParent();
    return b1.getMaxY() >= height || b1.getMinY() <= 0 || allImages.stream().anyMatch(img -> b1.intersects(img.getBoundsInParent()));
  }

  public void delete(){
    allImages.forEach(a -> getChildren().remove(a));
  }
}
