package demogame.playermovement;

import demogame.PlayerMovementBehavior;
import gameengine.renderer.RectangleRenderer2D;

public abstract class MovementState {
    protected RectangleRenderer2D renderer;
    protected PlayerMovementBehavior playerMovementBehavior;

    public MovementState(RectangleRenderer2D renderer, PlayerMovementBehavior playerMovementBehavior) {
        this.renderer = renderer;
        this.playerMovementBehavior = playerMovementBehavior;
    }

    public abstract void HandleUp();
    public abstract void HandleDown();
    public void Init() {};
    public void Update() {};
}
