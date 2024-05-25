package at.flappybird.game;

public class Data {
    public static class Images {
        public static final String pipeTop = "file:assets/Images/pipe-top.png";
        public static final String pipeBody =
            "file:assets/Images/pipe-body.png";
        public static final String bird = "file:assets/Images/player.png";
    }
    public static class Settings {
        public static final double gravity = 600;
        public static final double jumpPower = 500;
        public static final int spawnPlayerX = 100;
        public static final int spawnPlayerY = 100;
        public static final int delay = 50;
        public static final int pipeSpeed = 3;
    }
}
