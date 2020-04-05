import java.util.ArrayList;
import java.util.List;

// Class weapon which determines what projectiles to shoot with what burst radius and what velocity
public class Weapon {
    // Declaring the class variables and a list of Missile so that we can access any projectile at any moment
    private static double _weaponVelocity;
    private static long _lastShotTimeStamp;
    private static List<Missile> _missiles;
    private static Ammo _ammo;

    public  List<Explosion> explosions;

    // Creation of a Ammo Type defining the characteristics of every different ammunition each one for one specific weapon
    public enum Ammo{
        // BASIC ammo with normal burst radius, speed and fire rate
        BASIC ("ressources/Pictures/ammo0.png", 30, 8, 250, Integer.MAX_VALUE, 10),
        // CONE ammo shoots 3 lasers in a cone shape with high speed and low burst radius
        CONE ("ressources/Pictures/ammo1.png", 10, 15, 100, 200, 4),
        // GRENADE ammo is particularly slow but with a great burst radius
        GRENADE("ressources/Pictures/ammo2.png", 60, 6, 1000, 20, 40);

        public String picturePath;
        public double burstRadius;
        public double velocity;
        public long shotInterval; // Fire rate in ms
        public int capacity;
        public int damage;
        // Constructor of the Ammo sub class
        Ammo(String picturePath, double burstRadius, double velocity, long shotInterval, int capacity, int damage){
            this.picturePath = picturePath;
            this.burstRadius = burstRadius;
            this.velocity = velocity;
            this.shotInterval = shotInterval;
            this.capacity = capacity;
            this.damage = damage;
        }
    }

    // Constructor of the weapon class (initialize a new empty list for the missiles)
    public Weapon(long lastShotTimeStamp, Ammo ammo){
        _weaponVelocity = ammo.velocity;
        _lastShotTimeStamp = lastShotTimeStamp;
        _ammo = ammo;
        _missiles = new ArrayList<>();
        explosions = new ArrayList<>();
    }

    // Moving the projectiles
    public void MissilesMovements(){
        for (Missile missile : _missiles) {
            missile.xPos += missile.xVelocity;
            missile.yPos += missile.yVelocity;
        }
    }

    // Shoot function, this one is using tons of trigonometric maths for the calculations of angles when the player
    // inclines its canon. It is also here we detect whether the player can shoot or not with the fire rate.
    // If you don't understand the trigonometric stuff, don't worry, I dont't know neither what I did but it works so...
    public void Shoot(Player player){
        // Condition to see if enough time passed after the last shot
        if (StdDraw.isKeyPressed(32) && System.currentTimeMillis() - _lastShotTimeStamp > _ammo.shotInterval){
            _lastShotTimeStamp = System.currentTimeMillis();

            // Here we are adding one or three projectiles to our Missile list depending on the current weapon
            switch (_ammo){
                // Both these cases only need one projectile to spawn
                case BASIC:
                case GRENADE:
                    _missiles.add(new Missile(player.xPos - Math.cos((player.degrees - 90) * Math.PI / 180) * 35,
                            player.yPos - Math.sin((player.degrees-90) * Math.PI / 180) * 35,
                            -Math.cos((player.degrees -90) * Math.PI / 180) * _weaponVelocity,
                            -Math.sin((player.degrees -90) * Math.PI / 180) * _weaponVelocity,
                            player.degrees, _ammo.burstRadius));
                    break;
                // The CONE case is special as it needs 3 projectiles to be added. The maths are quite the same tho.
                case CONE:
                    _missiles.add(new Missile(player.xPos - Math.cos((player.degrees-90) * Math.PI / 180) * 35,
                            player.yPos - Math.sin((player.degrees-90) * Math.PI / 180) * 35,
                            -Math.cos((player.degrees -90) * Math.PI / 180) * _weaponVelocity,
                            -Math.sin((player.degrees -90) * Math.PI / 180) * _weaponVelocity,
                            player.degrees, _ammo.burstRadius));

                    _missiles.add(new Missile(player.xPos - Math.cos((player.degrees-90) * Math.PI / 180) * 35,
                            player.yPos - Math.sin((player.degrees-90) * Math.PI / 180) * 35,
                            -Math.cos((player.degrees -90) * Math.PI / 180 + Math.PI/12) * _weaponVelocity,
                            -Math.sin((player.degrees -90) * Math.PI / 180 + Math.PI/12) * _weaponVelocity,
                            player.degrees, _ammo.burstRadius));

                    _missiles.add(new Missile(player.xPos - Math.cos((player.degrees-90) * Math.PI / 180) * 35,
                            player.yPos - Math.sin((player.degrees-90) * Math.PI / 180) * 35,
                            -Math.cos((player.degrees -90) * Math.PI / 180 - Math.PI/12) * _weaponVelocity,
                            -Math.sin((player.degrees -90) * Math.PI / 180 - Math.PI/12) * _weaponVelocity,
                            player.degrees, _ammo.burstRadius));
                    break;
                // Cannot happen, but it is clean code to write this
                default:
                    break;
            }
            if (_ammo.capacity <= 0)
                ChangeWeapon(player, Ammo.BASIC);
            else
                _ammo.capacity--;
        }
    }

    // Function to update the projectiles list if they are out of the canvas dimensions (so that we free memory)
    public void UpdateProjectiles(EnemyHandler enemyHandler){
        _missiles.removeIf(missile -> missile.xPos < 0 || missile.xPos > Invaders.WIDTH || missile.yPos < 0 || missile.yPos > Invaders.HEIGHT);
        for (Enemy enemy : enemyHandler.enemyList){
            _missiles.removeIf(missile -> missile.IsInEnemyHitbox(enemy));
        }
    }

    public void UpdateExplosions(){
        explosions.removeIf(explosion -> System.currentTimeMillis() - explosion.apparitonTime > 500);
    }

    public static void ChangeWeapon(Player player, Ammo ammo){
        switch (ammo){
            case BASIC:
                _ammo = Ammo.BASIC;
                player.spaceShip = Player.Ship.SPACE;
                _ammo.capacity = Integer.MAX_VALUE;
                break;
            case CONE:
                _ammo = Ammo.CONE;
                player.spaceShip = Player.Ship.PLANET;
                _ammo.capacity = 100;
                break;
            case GRENADE:
                _ammo = Ammo.GRENADE;
                player.spaceShip = Player.Ship.DESERT;
                _ammo.capacity = 20;
                break;
            default:
                break;
        }
        // re init ammo stats
        _missiles = new ArrayList<>();
        _lastShotTimeStamp = 0;
        _weaponVelocity = _ammo.velocity;
    }

    public Ammo GetAmmo(){
        return _ammo;
    }

    public List<Missile> GetMissiles(){
        return _missiles;
    }

    public static Ammo RandomAmmo(){
        double cast = Math.random();
        if (cast <= 0.5)
            return Ammo.CONE;
        return Ammo.GRENADE;
    }
}
