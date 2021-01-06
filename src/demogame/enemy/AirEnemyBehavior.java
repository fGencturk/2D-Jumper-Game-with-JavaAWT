package demogame.enemy;

import demogame.GameManager;
import gameengine.Behavior;

import java.awt.*;

public class AirEnemyBehavior extends Enemy {
    float angle,
        initialYPos;
    @Override
    public void Start() {
        angle = 0;
        initialYPos = gameObject.position.y;
        gameObject.renderer.color = Color.MAGENTA;
    }

    @Override
    public void Update() {
        angle += 10;
        double yFactor = Math.sin(Math.toRadians(angle)) * 10;
        gameObject.position.y = (float) (initialYPos + yFactor);

        gameObject.position.x -= 5;

        if(gameObject.position.x <= -50) {
            Destroy();
        }
        if(CheckPlayerCollision()) {
            EnemyHitPlayer();
        }
    }
}
