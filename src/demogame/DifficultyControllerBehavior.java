package demogame;

import demogame.enemyspawner.DefaultEnemySpawner;
import demogame.enemyspawner.EnemySpawner;
import demogame.enemyspawner.HardEnemySpawner;
import gameengine.Behavior;
import gameengine.GameObject;
import gameengine.KeyboardInput;
import gameengine.Vector2;

public class DifficultyControllerBehavior extends Behavior {
    GameObject enemySpawnerGO;
    boolean difficultySelected = false;

    @Override
    public void Start() {

    }

    @Override
    public void Update() {
        if(difficultySelected) {
            if(KeyboardInput.GetInstance().IsKeyPressedThisFrame('r')) {
                GameManager.removedGameObjects.add(enemySpawnerGO);
                difficultySelected = false;
            }
            return;
        }
        if(KeyboardInput.GetInstance().IsKeyPressedThisFrame('e')) {
            Behavior enemyBehavior = new DefaultEnemySpawner();
            enemySpawnerGO = new GameObject(new Vector2(0, 0), null);
            enemySpawnerGO.AddBehavior(enemyBehavior);
            GameManager.spawnedGameObjects.add(enemySpawnerGO);
            difficultySelected = true;
        } else if(KeyboardInput.GetInstance().IsKeyPressedThisFrame('h')) {
            Behavior enemyBehavior = new HardEnemySpawner();
            enemySpawnerGO = new GameObject(new Vector2(0, 0), null);
            enemySpawnerGO.AddBehavior(enemyBehavior);
            GameManager.spawnedGameObjects.add(enemySpawnerGO);
            difficultySelected = true;
        }
    }
}
