package demogame;

import demogame.playermovement.DuckingState;
import demogame.playermovement.JumpingState;
import demogame.playermovement.MovementState;
import demogame.playermovement.StandingState;
import gameengine.Behavior;
import gameengine.KeyboardInput;
import gameengine.renderer.RectangleRenderer2D;
import gameengine.Vector2;

public class PlayerMovementBehavior extends Behavior {
    private MovementState standingState, duckingState, jumpingState;
    private MovementState currentState;

    @Override
    public void Start() {
        standingState = new StandingState((RectangleRenderer2D) gameObject.renderer, this);
        duckingState = new DuckingState((RectangleRenderer2D) gameObject.renderer, this);
        jumpingState = new JumpingState((RectangleRenderer2D) gameObject.renderer, this);

        currentState = standingState;
    }

    @Override
    public void Update() {
        RectangleRenderer2D renderer = (RectangleRenderer2D)this.gameObject.renderer;
        float height = renderer.size.y;
        int movementFactor = 0;

        currentState.Update();
        if(KeyboardInput.GetInstance().IsKeyPressedThisFrame('w')) {
            currentState.HandleUp();
        }
        if(KeyboardInput.GetInstance().IsKeyPressedThisFrame('s')) {
            currentState.HandleDown();
        }
    }

    public MovementState getStandingState() {
        return standingState;
    }

    public MovementState getDuckingState() {
        return duckingState;
    }

    public MovementState getJumpingState() {
        return jumpingState;
    }

    public void setCurrentState(MovementState currentState) {
        this.currentState = currentState;
        currentState.Init();
    }
}
