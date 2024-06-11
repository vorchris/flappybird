package at.flappybird.game;

public class Data {
    public static class Images {
        public static final String pipeTop = "file:assets/Images/pipe-top.png";
        public static final String pipeBody =
            "file:assets/Images/pipe-body.png";
        public static final String background = "file:assets/Images/background.png";
        public static final String base = "file:assets/Images/base.png";
        public static final String bird = "file:assets/bird.png";
    }
    public static class Settings {
        public static final double gravity = 600;
        public static final double jumpPower = 500;
        public static final int spawnPlayerX = 100;
        public static final int spawnPlayerY = 100;
        public static final int delay = 50;
        public static final int pipeSpeed = 3;
    }
    public static class Sounds {
        public static final String flap = "assets/flap.wav";
        public static final String die = "assets/die.wav";
        public static final String themeSong = "assets/theme-song.wav";
        public static final String point = "assets/point.wav";
    }
}
