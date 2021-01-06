package gameengine.renderer;

import gameengine.Vector2;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleRenderer2D extends Renderer2D {
    public float radius;

    public CircleRenderer2D(float radius) {
        this.radius = radius;
    }

    @Override
    public Shape GetShape(Vector2 position) {
        return new Ellipse2D.Double( position.x, position.y, this.radius, this.radius );
    }
}
