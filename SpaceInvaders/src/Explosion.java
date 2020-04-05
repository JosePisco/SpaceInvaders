public class Explosion {
    public long apparitonTime;
    public double xPos;
    public double yPos;
    public int degree;
    public String picturePath;
    public double burst;

    public Explosion(long apparitonTime, double xPos, double yPos, double burst){
        this.apparitonTime = apparitonTime;
        this.xPos = xPos;
        this.yPos = yPos;
        this.burst = burst;
        degree = (int)(Math.random() * 360);
        picturePath = "ressources/Pictures/explosion.png";
    }
}
