public class Bonus {
    public double xPos;
    public double yPos;
    public double xVelocity;
    public double yVelocity;
    public Powerups powerup;

    public enum Powerups{
        BACKGROUND ("ressources/Pictures/backgroundBonus.png", 1000000),
        FREEZE ("ressources/Pictures/freezeBonus.png",300000),
        GHOST ("ressources/Pictures/ghostBonus.png", 300000),
        MONSTER ("ressources/Pictures/monsterMalus.png", 300000),
        WEAPON ("ressources/Pictures/weaponBonus.png", 300000);

        public String picturePath;
        public double probability = 0.0;
        public long cap;

        Powerups(String picturePath, long cap){
            this.picturePath = picturePath;
            this.cap = cap;
        }
    }

    public Bonus(double xPos, double yPos, double xVelocity, double yVelocity, Powerups powerup) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.powerup = powerup;
    }

    public boolean IsInHitbox(Player player){
        return (xPos >= player.xPos - player.hitbox && xPos <= player.xPos + player.hitbox)
                && (yPos >= player.yPos - player.hitbox && yPos <= player.yPos + player.hitbox);
    }
}
