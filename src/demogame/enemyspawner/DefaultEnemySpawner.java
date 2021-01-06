package demogame.enemyspawner;

import demogame.enemy.AirEnemyBehavior;
import demogame.enemy.Enemy;
import demogame.enemy.GroundEnemyBehavior;

public class DefaultEnemySpawner extends EnemySpawner {
    @Override
    protected Enemy CreateEnemyBehavior(EnemyType type) {
        if(type == EnemyType.AIR) {
            return new AirEnemyBehavior();
        } else if(type == EnemyType.GROUND) {
            return new GroundEnemyBehavior();
        }
        return null;
    }
}
