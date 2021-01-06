package demogame.playermovement;

import demogame.PlayerMovementBehavior;
import gameengine.renderer.RectangleRenderer2D;

public class StandingState extends MovementState {
    public StandingState(RectangleRenderer2D renderer, PlayerMovementBehavior playerMovementBehavior) {
        super(renderer, playerMovementBehavior);
    }

    @Override
    public void HandleUp() {
        playerMovementBehavior.setCurrentState(playerMovementBehavior.getJumpingState());
    }

    @Override
    public void HandleDown() {
        playerMovementBehavior.setCurrentState(playerMovementBehavior.getDuckingState());
    }
}
