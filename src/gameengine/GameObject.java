package gameengine;

import gameengine.renderer.Renderer2D;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GameObject {
    public Vector2 position;
    public Renderer2D renderer;
    private Map<String, Behavior> behaviors;

    public GameObject(Vector2 position, Renderer2D renderer) {
        behaviors = new HashMap<String, Behavior>();
        this.position = position;
        this.renderer = renderer;
    }

    public void AddBehavior(Behavior behavior) {
        behaviors.put(behavior.GetId(), behavior);
        behavior.gameObject = this;
    }

    public void RemoveBehavior(String id) {
        behaviors.remove(id);
    }

    public Iterator<Behavior> CreateIterator(){
        return behaviors.values().iterator();
    }

    public void Display(Graphics2D g2d) {

        for(Map.Entry<String, Behavior> entry : behaviors.entrySet()) {
            String key = entry.getKey();
            Behavior value = entry.getValue();
            if(value.IsEnabled()) {
                value.OnRender(g2d);
            }
        }

        if(this.renderer != null) {
            this.renderer.display(this.position, g2d);
        }
    }
    public void Start() {
        for(Map.Entry<String, Behavior> entry : behaviors.entrySet()) {
            String key = entry.getKey();
            Behavior value = entry.getValue();
            if(value.IsEnabled()) {
                value.Start();
            }
        }
    }

    public void Update() {
        for(Map.Entry<String, Behavior> entry : behaviors.entrySet()) {
            String key = entry.getKey();
            Behavior value = entry.getValue();
            if(value.IsEnabled()) {
                value.Update();
            }
        }
    }
}
