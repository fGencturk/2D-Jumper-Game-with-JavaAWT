package demogame.enemyspawner;

import demogame.GameManager;
import demogame.enemy.Enemy;
import demogame.enemy.GroundEnemyBehavior;
import demogame.enemy.HardAirEnemyBehavior;
import gameengine.Behavior;
import gameengine.GameObject;
import gameengine.Vector2;
import gameengine.renderer.RectangleRenderer2D;
import gameengine.renderer.Renderer2D;

public abstract class EnemySpawner extends Behavior {
    double lastSpawnTime, nextSpawnDuration = 1000;
    enum EnemyType {
        AIR,
        GROUND
    }

    protected abstract Enemy CreateEnemyBehavior(EnemyType type);

    private GameObject SpawnEnemyGameObject() {
        Renderer2D enemyRenderer = new RectangleRenderer2D(new Vector2(30, 30));
        EnemyType type =Math.random() > 0.5 ? EnemyType.AIR : EnemyType.GROUND;
        Behavior enemyBehavior = CreateEnemyBehavior(type);
        GameObject enemyGameObject = new GameObject(new Vector2(GameManager.WIDTH + 100, type == EnemyType.GROUND ? GameManager.HEIGHT / 2 + 70 : GameManager.HEIGHT / 2), enemyRenderer);
        enemyGameObject.AddBehavior(enemyBehavior);
        GameManager.spawnedGameObjects.add(enemyGameObject);
        return enemyGameObject;
    }

    @Override
    public void Start() {
        lastSpawnTime = System.currentTimeMillis();
    }

    @Override
    public void Update() {
        if(System.currentTimeMillis() - lastSpawnTime >= nextSpawnDuration) {
            System.out.println("SPAWNED");
            lastSpawnTime = System.currentTimeMillis();
            SpawnEnemyGameObject();
            nextSpawnDuration = 1500 + Math.random() * 1000;
        }
    }

}
