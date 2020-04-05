import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;

// GameHandler class handles everything in the game e.g the background, the musics and the drawings on the canvas
public class GameHandler {

    // Defining the class variables
    private static Background _background;
    private static Clip musicSpace;
    private static Clip musicPlanet;
    private static Clip musicDesert;

    public short count = 0;

    // Creating a Background Type to alternate between each one
    public enum Background{
        SPACE ("ressources/Pictures/background0.png", "ressources/Music/music0.wav"),
        PLANET ("ressources/Pictures/background1.png", "ressources/Music/music1.wav"),
        DESERT ("ressources/Pictures/background2.jpg", "ressources/Music/music2.wav");

        // Declaring the sub class variable
        private final String picturePath;
        private final String musicPath;

        // Constructor of the sub class Background
        Background(String path, String musicPath){
            this.picturePath = path;
            this.musicPath = musicPath;
        }
    }

    // Constructor of the class GameHandler
    public GameHandler(Background background){
        _background = background;
    }

    // Function Draw draws every object on the canvas at their right coordinates after clearing everything
    public void Update(Player player, Weapon weapon, BonusHandler bonusHandler, EnemyHandler enemyHandler){
        // Clear the canvas
        StdDraw.clear(Color.black);

        //Drawing Score makes everything lag
        StdDraw.setPenColor(Color.white);
        StdDraw.picture(40, -25, "ressources/Pictures/life.png", 100, 53);
        StdDraw.setPenRadius(0.01);
        StdDraw.rectangle(175, -25, 103, 12);
        //StdDraw.textLeft(300, -25, "" + player.score);
        StdDraw.setPenColor(Color.green);
        if (player.life > 0)
            StdDraw.filledRectangle(175, -25, player.life, 10);

        // Move the objects : Player - Projectiles
        player.Movements();
        weapon.MissilesMovements();
        bonusHandler.BonusMovements();
        enemyHandler.EnemyMovements();

        // Update for spawning objects and if they are out of the canvas
        if (enemyHandler.enemyList.isEmpty()){
            enemyHandler.SpawnEnemy();
            enemyHandler.difficulty++;
            enemyHandler.ResetVelocity();
            enemyHandler.ResetCoeff();
        }
        enemyHandler.SpawnUFO();
        enemyHandler.UpdateEnemyList(player);
        enemyHandler.UpdateEnemyHits(weapon);

        weapon.Shoot(player);
        weapon.UpdateProjectiles(enemyHandler);
        weapon.UpdateExplosions();

        bonusHandler.SpawnBonus();
        bonusHandler.UpdateBonus(player, enemyHandler);

        // Redraw every objects : Background - Player space ship - Every projectile from the Missile list
        StdDraw.picture(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, _background.picturePath, Invaders.WIDTH, Invaders.HEIGHT);


        if (!player.isGhost)
            StdDraw.picture(player.xPos, player.yPos, player.spaceShip.picturePath, player.degrees);
        else
            StdDraw.picture(player.xPos, player.yPos, player.spaceShip.ghostPicturePath, player.degrees);

        for (Missile missile: weapon.GetMissiles()) {
            StdDraw.picture(missile.xPos, missile.yPos, weapon.GetAmmo().picturePath, 30, 30, missile.degrees);
        }

        for (Explosion explosion : weapon.explosions){
            StdDraw.picture(explosion.xPos, explosion.yPos, explosion.picturePath,  explosion.burst,
                    explosion.burst, explosion.degree);
        }

        for (Bonus bonus : bonusHandler.bonuses){
            StdDraw.picture(bonus.xPos, bonus.yPos, bonus.powerup.picturePath, 30, 30);
        }

        for (Enemy enemy : enemyHandler.enemyList){
            if (enemy.enemyType == Enemy.EnemyType.UFO)
                StdDraw.picture(enemy.xPos, enemy.yPos, enemy.enemyType.picturePathUFO, 50, 50);
            else {
                if (count < 25)
                    StdDraw.picture(enemy.xPos, enemy.yPos, enemy.enemyType.picturePath0, 50, 50);
                 else if (count < 50)
                    StdDraw.picture(enemy.xPos, enemy.yPos, enemy.enemyType.picturePath1, 50, 50);
                else
                    count = 0;
            }
        }
        count++;

        // Show
        StdDraw.show();
    }

    public static void ChangeBackground(){
        switch (_background){
            case SPACE:
                _background = Background.PLANET;
                if (musicSpace != null)
                    StopMusic(musicSpace);
                musicPlanet = StartMusic();
                break;
            case PLANET:
                _background = Background.DESERT;
                if (musicPlanet != null)
                    StopMusic(musicPlanet);
                musicDesert = StartMusic();
                break;
            case DESERT:
                _background = Background.SPACE;
                if (musicDesert != null)
                    StopMusic(musicDesert);
                musicSpace = StartMusic();
            default:
                break;
        }
    }

    // Function StartMusic to display music on audio output
    private static Clip StartMusic(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(_background.musicPath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(100);
            return clip;
        }
        catch(Exception ex) {
            System.err.println("Error while loading music.");
        }
        // Return null only if the path to the audio file is wrong which should never happen
        return null;
    }

    // StopMusic function used to stop the current music from playing
    public static void StopMusic(Clip clip){
        clip.stop();
    }

    public void StopAllMusic(){
        if (musicSpace != null)
            musicSpace.stop();
        if (musicPlanet != null)
            musicPlanet.stop();
        if (musicDesert != null)
            musicDesert.stop();
    }

    public void InitiateMusic(){
        musicSpace = StartMusic();
        musicPlanet = null;
        musicDesert = null;
    }
}
