package gameengine;

import java.awt.*;
import java.util.UUID;

public abstract class Behavior {
    public GameObject gameObject;
    //public GameObject gameObject; //attached gameObject
    private String behaviorId;

    public String GetId(){
        return behaviorId;
    }

    public Behavior(){
        behaviorId = UUID.randomUUID().toString();
    }

    public abstract void Start();
    public abstract void Update();
    public void OnRender(Graphics2D g2d){}
    protected boolean IsEnabled(){
        return true;
    }
}
