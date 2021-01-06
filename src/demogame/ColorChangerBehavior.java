package demogame;

import gameengine.Behavior;

import java.awt.*;

public class ColorChangerBehavior extends Behavior {

    private float changeInSeconds = 3;
    private long lastChange;

    public ColorChangerBehavior(){}

    public ColorChangerBehavior(float changeInSeconds) {
        this.changeInSeconds = changeInSeconds;
    }

    @Override
    public void Start() {
        lastChange = System.currentTimeMillis();
    }

    @Override
    public void Update() {
        if(System.currentTimeMillis() - lastChange >= changeInSeconds * 1000) {
            lastChange = System.currentTimeMillis();
            this.gameObject.renderer.color = Color.getHSBColor((float)Math.random(),(float)Math.random(), (float)Math.random() );
        }
    }
}
