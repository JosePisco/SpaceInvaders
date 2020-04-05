// Class Player represents the player with its score, its coordinates, its life...
public class Player {
    // Declaring all the necessary variables
    public int score;
    public double xPos;
    public double yPos;
    public int life;
    public Ship spaceShip;
    public double velocity;
    public double maxVelocity;
    public double speed;
    public double degrees;
    public int hitbox;

    public boolean isGhost = false;

    // Creation of a Ship Type to change the skin of the space ship in function of the current background
    public enum Ship{
        SPACE ("ressources/Pictures/spaceShip0"),
        PLANET ("ressources/Pictures/spaceShip1"),
        DESERT ("ressources/Pictures/spaceShip2");

        public final String picturePath;
        public final String ghostPicturePath;
        // Constructor of the Ship sub class
        Ship(String picturePath){
            this.picturePath = picturePath + ".png";
            ghostPicturePath = picturePath + "Ghost.png";
        }
    }

    // Constructor of the Player class with all its variables
    public Player(int score, double xPos, double yPos, int life, double velocity, double maxVelocity, double speed, double degrees, int hitbox, Ship spaceShip){
        this.score = score;
        this.xPos = xPos;
        this.yPos = yPos;
        this.life = life;
        this.velocity = velocity;
        this.maxVelocity = maxVelocity;
        this.speed = speed;
        this.degrees = degrees;
        this.hitbox = hitbox;
        this.spaceShip = spaceShip;
    }

    // Function Movements that moves the player and restrict it to the dimensions of the window
    public void Movements(){
        // Movements in all four directions. The player cannot go above a certain Y coordinate.
        if (StdDraw.isKeyPressed('D') && xPos + 27 < Invaders.WIDTH)
            xPos += velocity * speed;
        if (StdDraw.isKeyPressed('Q') && xPos - 27 > 0)
            xPos -= velocity * speed;
        if (StdDraw.isKeyPressed('Z') && yPos < 100)
            yPos += velocity;
        if (StdDraw.isKeyPressed('S') && yPos > 27)
            yPos -= velocity;

        // Handles the rotation of the canon and the ship. Capped at 180 degrees.
        if (StdDraw.isKeyPressed('A') && degrees <= 85)
            degrees+=5;
        if (StdDraw.isKeyPressed('E') && degrees >= -85)
            degrees-=5;
    }

    public void ResetVelocity(){
        velocity = 3.5;
    }
}
