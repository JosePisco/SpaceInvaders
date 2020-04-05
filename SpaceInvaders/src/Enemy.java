public class Enemy {
    public double xPos;
    public double yPos;
    public EnemyType enemyType;
    public int hitbox = 25;
    public double life;

    public enum EnemyType{
        ALIEN0 ("ressources/Pictures/enemy0", 10, 5),
        ALIEN1 ("ressources/Pictures/enemy1", 15, 12),
        ALIEN2 ("ressources/Pictures/enemy2", 25, 30),
        UFO ("ressources/Pictures/enemyUFO.png", 1, 100);

        public String picturePath0;
        public String picturePath1;
        public String picturePathUFO;
        public int life;
        public int points;

        EnemyType(String picturePath, int life, int points){
            picturePath0 = picturePath + "_0.png";
            picturePath1 = picturePath + "_1.png";
            picturePathUFO = picturePath;
            this.life = life;
            this.points = points;
        }
    }

    public Enemy(double xPos, double yPos, EnemyType enemyType) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.enemyType = enemyType;
        life = enemyType.life;
    }

    public boolean IsInPlayerHitbox(Player player){
        return (xPos >= player.xPos - player.hitbox && xPos <= player.xPos + player.hitbox)
                && (yPos >= player.yPos - player.hitbox && yPos <= player.yPos + player.hitbox);
    }
}
