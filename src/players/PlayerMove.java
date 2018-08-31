package players;

import bases.Vector2D;
import inputs.InputManager;

public class PlayerMove {
    void run(Vector2D position) {
        Vector2D velocity = new Vector2D();

        if (InputManager.instance.rightPressed) {
            velocity.x += 3;
        }

        if (InputManager.instance.leftPressed) {
            velocity.x -= 3;
        }

        if (InputManager.instance.upPressed) {
            velocity.y -= 3;
        }

        if (InputManager.instance.downPressed) {
            velocity.y += 3;
        }

        position.addUp(velocity);
    }
}