// Class Missile represents every instance of projectiles with their coordinates, their velocity and their inclination
public class Missile {
    public double xPos;
    public double yPos;
    public double xVelocity;
    public double yVelocity;
    public double degrees;
    public double burstRadius;

    // Constructor of the Missile class
    public Missile(double xPos, double yPos, double xVelocity, double yVelocity, double degrees, double burstRadius){
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.degrees = degrees;
        this.burstRadius = burstRadius;
    }

    public boolean IsInEnemyHitbox(Enemy enemy){
        return (xPos >= enemy.xPos - enemy.hitbox && xPos <= enemy.xPos + enemy.hitbox)
                && (yPos >= enemy.yPos - enemy.hitbox && yPos <= enemy.yPos + enemy.hitbox);
    }
}
