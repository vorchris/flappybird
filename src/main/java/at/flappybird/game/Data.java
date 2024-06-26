package at.flappybird.game;

public class Data {
    public static class Images {
        public static final String pipe = "file:assets/pipe.png";
        public static final String background = "file:assets/background.png";
        public static final String bird = "file:assets/bird.png";
    }
    public static class Settings {
        public static final double gravity = 0.5;
        public static final double jumpPower = 7;
        public static final int height = 500;
        public static final int width = 1000;
        public static final int pipeSpeed = 2;
        public static final int gap = 150;
        public static final int minHeight = 50;
        public static final int maxHeight = 300;
    }
    public static class Sounds {
        public static final String flap = "assets/flap.wav";
        public static final String die = "assets/die.wav";
        public static final String themeSong = "assets/theme-song.wav";
        public static final String point = "assets/point.wav";
    }
}
