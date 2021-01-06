package gameengine;

import unityengine.MonoBehavior;

// This custom engine supports MonoBehavior of UnityGameEngine
public class MonoBehaviorAdapter extends Behavior {
    MonoBehavior monoBehavior;

    public MonoBehaviorAdapter(MonoBehavior monoBehavior) {
        this.monoBehavior = monoBehavior;
    }

    @Override
    public void Start() {
        monoBehavior.Awake();
        monoBehavior.Start();
    }

    @Override
    public void Update() {
        monoBehavior.Update();
        monoBehavior.FixedUpdate();
    }
}
