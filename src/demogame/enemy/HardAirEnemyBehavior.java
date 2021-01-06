package demogame.enemy;

import demogame.GameManager;
import gameengine.Behavior;

import java.awt.*;

public class HardAirEnemyBehavior extends Enemy {
    float initialYPos;
    int directionY;
    @Override
    public void Start() {
        directionY = 1;
        initialYPos = gameObject.position.y;
        gameObject.renderer.color = Color.RED;
    }

    @Override
    public void Update() {
        gameObject.position.y += directionY * 5;
        if(gameObject.position.y > initialYPos + 120) {
            directionY = -1;
        } else if(gameObject.position.y < initialYPos) {
            directionY = 1;
        }
        gameObject.position.x -= 5;

        if(gameObject.position.x <= -50) {
            Destroy();
        }
        if(CheckPlayerCollision()) {
            EnemyHitPlayer();
        }

    }
}
