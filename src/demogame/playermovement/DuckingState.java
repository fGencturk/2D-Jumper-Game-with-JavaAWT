package demogame.playermovement;

import demogame.PlayerMovementBehavior;
import gameengine.Vector2;
import gameengine.renderer.RectangleRenderer2D;

public class DuckingState extends MovementState {
    private float initHeight, initYPos;

    public DuckingState(RectangleRenderer2D renderer, PlayerMovementBehavior playerMovementBehavior) {
        super(renderer, playerMovementBehavior);
    }

    @Override
    public void HandleUp() {
        playerMovementBehavior.gameObject.position.y = initYPos;
        renderer.size.y = initHeight;
        playerMovementBehavior.setCurrentState(playerMovementBehavior.getStandingState());
    }

    @Override
    public void HandleDown() {
        System.out.println("Already ducking.");
    }

    @Override
    public void Init(){
        initHeight = renderer.size.y;
        initYPos = playerMovementBehavior.gameObject.position.y;
        renderer.size.y = initHeight / 2;
        playerMovementBehavior.gameObject.position.y = initYPos + initHeight / 2;
    }
}
