package gameengine.renderer;

import gameengine.Vector2;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Renderer2D {
    public Color color = Color.blue;

    public final void display(Vector2 position, Graphics2D g2d){
        g2d.setPaint(color);
        g2d.fill( this.GetShape(position) );
    }

    public abstract Shape GetShape(Vector2 position);
}
