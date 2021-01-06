package demogame.enemy;

import demogame.GameManager;
import gameengine.Behavior;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GroundEnemyBehavior extends Enemy {
    @Override
    public void Start() {
        gameObject.renderer.color = Color.PINK;
    }

    @Override
    public void Update() {
        gameObject.position.x -= 5;

        if(gameObject.position.x <= -50) {
            Destroy();
        }
        if(CheckPlayerCollision()) {
            EnemyHitPlayer();
        }

    }

}
