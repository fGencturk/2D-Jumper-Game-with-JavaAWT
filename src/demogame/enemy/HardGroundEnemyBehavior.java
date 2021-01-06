package demogame.enemy;

import demogame.GameManager;
import gameengine.Behavior;

import java.awt.*;

public class HardGroundEnemyBehavior extends Enemy {
    int counter = 0;
    boolean isDashing = false;
    @Override
    public void Start() {
        gameObject.renderer.color = Color.ORANGE;
    }

    @Override
    public void Update() {
        counter++;
        float speedFactor = 5 - counter / 9;
        if(isDashing) {
            speedFactor = 15f;
            if(counter >= 10) {
                isDashing = false;
                counter = 0;
            }
        } else if(counter >= 45) {
            isDashing = true;
            counter = 0;
        }
        gameObject.position.x -= speedFactor;

        if(gameObject.position.x <= -50) {
            Destroy();
        }
        if(CheckPlayerCollision()) {
            EnemyHitPlayer();
        }

    }
}
