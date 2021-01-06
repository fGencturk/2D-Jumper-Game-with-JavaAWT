package demogame.playermovement;

import demogame.PlayerMovementBehavior;
import gameengine.renderer.RectangleRenderer2D;

public class JumpingState extends MovementState {
    public JumpingState(RectangleRenderer2D renderer, PlayerMovementBehavior playerMovementBehavior) {
        super(renderer, playerMovementBehavior);
    }

    float angle, startYPosition;

    @Override
    public void HandleUp() {
        System.out.println("Already jumping...");
    }

    @Override
    public void HandleDown() {
        System.out.println("Jumping. Cannot duck.");
    }

    public void Init(){
        angle = 0;
        startYPosition = playerMovementBehavior.gameObject.position.y;
    }

    public void Update() {
        angle += 8;
        double jumpFactor = Math.sin(Math.toRadians(angle)) * 100;
        if(jumpFactor <= 0) {
            playerMovementBehavior.gameObject.position.y = startYPosition;
            playerMovementBehavior.setCurrentState(playerMovementBehavior.getStandingState());
        } else {
            playerMovementBehavior.gameObject.position.y = (float) (startYPosition - jumpFactor);
        }
    }

}
