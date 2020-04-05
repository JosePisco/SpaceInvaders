import java.util.ArrayList;
import java.util.List;

public class BonusHandler {

    public long lastBonusSpawned;
    public long lastBackgroundChange;
    public long lastFreezePicked;
    public long lastGhostPicked;
    public long lastMonsterPicked;
    public int bonusDuration;
    public List<Bonus> bonuses;

    private static double storeEnemyVelocity = 0.5;
    private static double storeEnemyResistance = 0.0;

    public BonusHandler(int bonusDuration){
        lastBonusSpawned = System.currentTimeMillis();
        lastBackgroundChange = System.currentTimeMillis();

        lastFreezePicked = Long.MAX_VALUE;
        lastGhostPicked = Long.MAX_VALUE;
        lastMonsterPicked = Long.MAX_VALUE;

        this.bonusDuration = bonusDuration;
        bonuses = new ArrayList<>();
    }

    public void SpawnBonus(){
        if ((System.currentTimeMillis() - lastBackgroundChange) * Bonus.Powerups.BACKGROUND.probability > Bonus.Powerups.BACKGROUND.cap){ // Probability of spawning a bonus
            lastBackgroundChange = System.currentTimeMillis();
            bonuses.add(new Bonus(Math.random() * (Invaders.WIDTH - 20) + 10, Invaders.HEIGHT - 20, GetRandomVelocity(true), GetRandomVelocity(false), Bonus.Powerups.BACKGROUND));
            Bonus.Powerups.BACKGROUND.probability = 0.0;
        }
        else
            Bonus.Powerups.BACKGROUND.probability += (Math.random() * 0.015);

        if ((System.currentTimeMillis() - lastBonusSpawned) * Bonus.Powerups.FREEZE.probability > Bonus.Powerups.FREEZE.cap){
            lastBonusSpawned = System.currentTimeMillis();
            bonuses.add(new Bonus(Math.random() * (Invaders.WIDTH - 20) + 10, Invaders.HEIGHT - 10, GetRandomVelocity(true), GetRandomVelocity(false), Bonus.Powerups.FREEZE));
            Bonus.Powerups.FREEZE.probability = 0.0;
        }
        else
            Bonus.Powerups.FREEZE.probability += (Math.random() * 0.015);

        if ((System.currentTimeMillis() - lastBonusSpawned) * Bonus.Powerups.GHOST.probability > Bonus.Powerups.GHOST.cap){
            lastBonusSpawned = System.currentTimeMillis();
            bonuses.add(new Bonus(Math.random() * (Invaders.WIDTH - 20) + 10, Invaders.HEIGHT - 10, GetRandomVelocity(true), GetRandomVelocity(false), Bonus.Powerups.GHOST));
            Bonus.Powerups.GHOST.probability = 0.0;
        }
        else
            Bonus.Powerups.GHOST.probability += (Math.random() * 0.015);

        if ((System.currentTimeMillis() - lastBonusSpawned) * Bonus.Powerups.MONSTER.probability > Bonus.Powerups.MONSTER.cap){
            lastBonusSpawned = System.currentTimeMillis();
            bonuses.add(new Bonus(Math.random() * (Invaders.WIDTH - 20) + 10, Invaders.HEIGHT - 10, GetRandomVelocity(true), GetRandomVelocity(false), Bonus.Powerups.MONSTER));
            Bonus.Powerups.MONSTER.probability = 0.0;
        }
        else
            Bonus.Powerups.MONSTER.probability += (Math.random() * 0.015);

        if ((System.currentTimeMillis() - lastBonusSpawned) * Bonus.Powerups.WEAPON.probability > Bonus.Powerups.WEAPON.cap){
            lastBonusSpawned = System.currentTimeMillis();
            bonuses.add(new Bonus(Math.random() * (Invaders.WIDTH - 20) + 10, Invaders.HEIGHT - 10, GetRandomVelocity(true), GetRandomVelocity(false), Bonus.Powerups.WEAPON));
            Bonus.Powerups.WEAPON.probability = 0.0;
        }
        else
            Bonus.Powerups.WEAPON.probability += (Math.random() * 0.015);
    }

    public void BonusMovements(){
        for (Bonus powerups : bonuses) {
            powerups.xPos += powerups.xVelocity;
            powerups.yPos += powerups.yVelocity;
        }
    }

    // Function to update the bonus list if they are out of the canvas dimensions (so that we free memory)
    public void UpdateBonus(Player player, EnemyHandler enemyHandler){
        for (Bonus bonus : bonuses) {
            if (bonus.xPos <= 10 || bonus.xPos >= Invaders.WIDTH - 10)
                bonus.xVelocity *= -1;

            if (bonus.IsInHitbox(player)){
                ApplyPowerupAbility(bonus, player, enemyHandler);
                switch (bonus.powerup){
                    case FREEZE:
                        player.score += 100;
                        lastFreezePicked = System.currentTimeMillis();
                        break;
                    case GHOST:
                        player.score += 100;
                        lastGhostPicked = System.currentTimeMillis();
                        break;
                    case MONSTER:
                        player.score -= 50;
                        lastMonsterPicked = System.currentTimeMillis();
                        break;
                    case WEAPON:
                        player.score += 100;
                        break;
                    case BACKGROUND:
                        player.score += 75;
                        break;
                    default:
                        break;
                }
            }
        }
        bonuses.removeIf(bonus -> bonus.yPos < 0 || bonus.IsInHitbox(player));

        if (System.currentTimeMillis() - lastFreezePicked > 5000)
            RemovePowerupAbility(player, enemyHandler, Bonus.Powerups.FREEZE);
        if (System.currentTimeMillis() - lastGhostPicked > 5000)
            RemovePowerupAbility(player, enemyHandler, Bonus.Powerups.GHOST);
        if (System.currentTimeMillis() - lastMonsterPicked > 5000)
            RemovePowerupAbility(player, enemyHandler, Bonus.Powerups.MONSTER);
    }

    private static double GetRandomVelocity(boolean xVelocity){
        int cast = (int)(Math.random() * 2);
        double velocity = Math.random() * -5;

        if (!xVelocity)
            velocity -= 0.5;

        if (cast == 1 && xVelocity)
            velocity *= -1;
        return velocity;
    }

    private static void ApplyPowerupAbility(Bonus bonus, Player player, EnemyHandler enemyHandler){
        switch (bonus.powerup){
            case BACKGROUND:
                GameHandler.ChangeBackground();
                break;
            case FREEZE:
                storeEnemyVelocity = enemyHandler.GetVelocity();
                enemyHandler.SetVelocity(storeEnemyVelocity / 5);
                enemyHandler.resistance -= 25;
                break;
            case GHOST:
                player.isGhost = true;
                player.velocity = player.maxVelocity;
                break;
            case MONSTER:
                storeEnemyResistance = enemyHandler.resistance;
                enemyHandler.resistance += Math.random() * 100;
                enemyHandler.SetVelocity(enemyHandler.GetVelocity() * 2);
                enemyHandler.difficulty++;
                break;
            case WEAPON:
                Weapon.ChangeWeapon(player, Weapon.RandomAmmo());
                break;
            default:
                break;
        }
    }

    private void RemovePowerupAbility(Player player, EnemyHandler enemyHandler, Bonus.Powerups powerup){
        switch (powerup){
            case FREEZE:
                enemyHandler.SetVelocity(storeEnemyVelocity);
                enemyHandler.resistance += 25;
                lastFreezePicked = Long.MAX_VALUE;
                break;
            case GHOST:
                player.isGhost = false;
                player.ResetVelocity();
                lastGhostPicked = Long.MAX_VALUE;
                break;
            case MONSTER:
                enemyHandler.resistance = storeEnemyResistance;
                enemyHandler.SetVelocity(enemyHandler.GetVelocity() / 2);
                lastMonsterPicked = Long.MAX_VALUE;
                break;
            default:
                break;
        }
    }
}
