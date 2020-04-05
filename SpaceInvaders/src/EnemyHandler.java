import java.util.ArrayList;
import java.util.List;

public class EnemyHandler {
    private static double _velocity;
    private static double _UFOVelocity;
    private static double _coeff = 1.0;

    public List<Enemy> enemyList;
    public int difficulty = 3;
    public double resistance = 0.0;

    // Constructor of the EnemyHandler class
    // Declare a value for each class variables defined above;
    // Get a look at the other classes for hints
    public EnemyHandler(double velocity){
        _velocity = velocity;
        _UFOVelocity = 5;
        enemyList = new ArrayList<>();
    }

    // Function SpawnEnemy
    // Spawn "difficulty" layers of enemies switching between the 3 types : ALIEN0, ALIEN1, ALIEN2
    // One layer of enemies is one row of the screen (do not make them use all the row space, they need to move left and right! try with 10 enemies first)
    // Spawn a maximum of 4 layers of enemies at the same time. If difficulty = 5, then wait for the enemies to move down by one block.
    // UFO enemy spawns randomly, on a 0.1% chance
    public void SpawnEnemy(){
        int whatToSpawn = 0;
        Enemy.EnemyType enemyType = Enemy.EnemyType.ALIEN0;
        int x = 25;
        int y = (int)(Invaders.HEIGHT - 3 * 50) + 25;

        for (int i = 0; i < difficulty; i++){
            for (int j = 0; j < 10; j++){
                enemyList.add(new Enemy(x, y, enemyType));
                x += 50;
            }
            x = 25;
            y += 50;
            if (whatToSpawn != 2)
                whatToSpawn++;
            else
                whatToSpawn = 0;
            switch (whatToSpawn){
                case 2:
                    enemyType = Enemy.EnemyType.ALIEN2;
                    break;
                case 1:
                    enemyType = Enemy.EnemyType.ALIEN1;
                    break;
                case 0:
                    enemyType = Enemy.EnemyType.ALIEN0;
                    break;
                default:
                    break;
            }
        }
    }

    public void SpawnUFO(){
        if (Math.random() > 0.999)
            enemyList.add(new Enemy(25, Invaders.HEIGHT - 25, Enemy.EnemyType.UFO));
    }

    // Function EnemyMovements
    // Should move all the enemies on the X axis according to their velocity
    // If any enemy reaches the left or right border, reverse all the enemies' velocity
    // And make them move one block below (one block = the enemy picture size)
    // The UFO has 3 times the other enemies' velocity
    public void EnemyMovements(){
        boolean moveDown = false;

        for (Enemy enemy : enemyList){
            if (enemy.enemyType != Enemy.EnemyType.UFO)
                enemy.xPos += _velocity;
            else
                enemy.xPos += _UFOVelocity;
            if ((enemy.xPos < 25 || enemy.xPos > Invaders.WIDTH - 25) && enemy.enemyType != Enemy.EnemyType.UFO)
                moveDown = true;
        }

        if (moveDown)
            MoveEnemiesDown();
    }

    private void MoveEnemiesDown(){
        for (Enemy enemy : enemyList){
            if (enemy.enemyType != Enemy.EnemyType.UFO){
                enemy.yPos -= 50;
            }
        }
        _velocity *= -1;
    }

    // Function UpdateEnemyList
    // Should remove enemies from the enemyList if:
    // life <= 0.0
    // its Y position is <= 0.0
    // If the enemy is killed (life <= 0.0), add its points to the player score
    // If the enemy reaches the bottom of the screen (yPos <= 0.0), remove 1/3 of the player's life
    // Increases n by 0.05 and calls the UpdateEnemyVelocity function
    // A UFO is removed if its x coordinates are out of the canvas
    public void UpdateEnemyList(Player player){
        for (Enemy enemy : enemyList){
            if (enemy.life <= 0.0){
                player.score += enemy.enemyType.points;
                _coeff += 0.001;
                UpdateEnemyVelocity();
            }
            if ((enemy.yPos <= 0.0 && enemy.life > 0.0) || enemy.IsInPlayerHitbox(player))
                player.life -= enemy.life;
        }
        enemyList.removeIf(enemy -> enemy.life <= 0.0 || enemy.yPos < 0.0 ||
                (enemy.enemyType == Enemy.EnemyType.UFO && (enemy.xPos < 0 || enemy.xPos > Invaders.WIDTH)) || enemy.IsInPlayerHitbox(player));
    }

    // Function UpdateEnemyVelocity
    // Increases the velocity according to the number of enemies left by multiplicating it by n
    private static void UpdateEnemyVelocity(){
        _velocity *= _coeff;
    }

    public void UpdateEnemyHits(Weapon weapon){
        List<Missile> missiles = weapon.GetMissiles();
        for (Enemy enemy : enemyList){
            for (Missile missile : missiles){
                if (missile.IsInEnemyHitbox(enemy)){
                    weapon.explosions.add(new Explosion(System.currentTimeMillis(), missile.xPos, missile.yPos, missile.burstRadius * 2));
                    enemy.life -= (weapon.GetAmmo().damage * ((100 - resistance) / 100));
                    for (Enemy enemy1 : enemyList){
                        if (DoHitboxCollide(enemy1, missile) && enemy1 != enemy)
                            enemy1.life -= weapon.GetAmmo().damage * ((100 - resistance) / 100);
                    }
                }

            }
        }
    }

    // i did this shit, yes sir
    private static boolean DoHitboxCollide(Enemy enemy, Missile missile){
        return ((enemy.xPos - enemy.hitbox < missile.xPos - missile.burstRadius && enemy.yPos + enemy.hitbox < missile.yPos + missile.burstRadius
                && enemy.xPos - enemy.hitbox > missile.xPos + missile.burstRadius && enemy.yPos + enemy.hitbox > missile.yPos - missile.burstRadius)
        || (enemy.xPos + enemy.hitbox < missile.xPos + missile.burstRadius && enemy.yPos + enemy.hitbox < missile.yPos + missile.burstRadius
                && enemy.xPos + enemy.hitbox > missile.xPos - missile.burstRadius && enemy.yPos + enemy.hitbox > missile.yPos - missile.burstRadius)
        || (enemy.xPos - enemy.hitbox > missile.xPos - missile.burstRadius && enemy.yPos - enemy.hitbox > missile.yPos - missile.burstRadius
                && enemy.xPos - enemy.hitbox < missile.xPos + missile.burstRadius && enemy.yPos - enemy.hitbox < missile.yPos + missile.burstRadius)
        || (enemy.xPos + enemy.hitbox > missile.xPos + missile.burstRadius && enemy.yPos - enemy.hitbox > missile.yPos - missile.burstRadius
                && enemy.xPos + enemy.hitbox < missile.xPos - missile.burstRadius && enemy.yPos - enemy.hitbox < missile.yPos + missile.burstRadius));
    }

    public double GetVelocity(){
        return _velocity;
    }

    public void ResetVelocity(){
        _velocity = 0.5;
    }

    public void SetVelocity(double velocity){
        _velocity = velocity;
    }

    public void ResetCoeff(){
        _coeff = 1.0;
    }
}
