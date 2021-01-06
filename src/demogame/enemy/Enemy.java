package demogame.enemy;

import demogame.GameManager;
import demogame.PlayerMovementBehavior;
import gameengine.Behavior;
import gameengine.Vector2;
import gameengine.renderer.RectangleRenderer2D;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Enemy extends Behavior {
    boolean hitPlayer = false;
    int count = 0;
    public static PlayerMovementBehavior playerMovementBehavior;

    boolean CheckPlayerCollision() {
        Vector2 l1 = new Vector2(playerMovementBehavior.gameObject.position);
        Vector2 r1 = new Vector2(l1);
        RectangleRenderer2D renderer = (RectangleRenderer2D) playerMovementBehavior.gameObject.renderer;
        r1.x += renderer.size.x;
        r1.y += renderer.size.y;

        Vector2 l2 = new Vector2(gameObject.position);
        Vector2 r2 = new Vector2(l2);
        renderer = (RectangleRenderer2D) gameObject.renderer;
        r2.x += renderer.size.x;
        r2.y += renderer.size.y;
        // If one rectangle is on left side of other
        if (l1.x >= r2.x || l2.x >= r1.x)
            return false;

        // If one rectangle is above other
        if (l1.y >= r2.y || l2.y >= r1.y)
            return false;

        return true;
    }

    void Destroy() {
        GameManager.removedGameObjects.add(gameObject);
    }

    protected void EnemyHitPlayer() {
        hitPlayer = true;
    }

    @Override
    public void OnRender(Graphics2D g2d) {
        if(hitPlayer) {
            g2d.setPaint(Color.red);
            g2d.fill(new Rectangle2D.Double( 0, 0, GameManager.WIDTH, GameManager.HEIGHT ));
            count++;
            if(count >= 3) {
                Destroy();
            }
        }
    }

}
