package demogame.enemyspawner;

import demogame.enemy.*;

public class HardEnemySpawner extends EnemySpawner {
    @Override
    protected Enemy CreateEnemyBehavior(EnemyType type) {
        if(type == EnemyType.AIR) {
            return new HardAirEnemyBehavior();
        } else if(type == EnemyType.GROUND) {
            return new HardGroundEnemyBehavior();
        }
        return null;
    }
}
