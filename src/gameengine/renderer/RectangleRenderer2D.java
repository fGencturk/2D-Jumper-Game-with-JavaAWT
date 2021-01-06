package gameengine.renderer;

import gameengine.Vector2;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleRenderer2D extends Renderer2D {
    public Vector2 size;

    public RectangleRenderer2D(Vector2 size) {
        this.size = size;
    }

    @Override
    public Shape GetShape(Vector2 position) {
        return new Rectangle2D.Double( position.x, position.y, this.size.x, this.size.y );
    }
}
