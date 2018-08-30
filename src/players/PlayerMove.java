package players;

import inputs.InputManager;
import bases.Vector2D;

class PlayerMove {
    Vector2D position;

    PlayerMove(Vector2D position) {
        this.position = position;
    }

    void run() {
        Vector2D velocity = new Vector2D();
        if (InputManager.instance.upPressed && (this.position.y >= 0)) {
            velocity.y -= 3;
        }

        if (InputManager.instance.downPressed && (this.position.y <= 600)) {
            velocity.y += 3;
        }

        if (InputManager.instance.leftPressed && (this.position.x >= -30)) {
            velocity.x -= 3;
        }

        if (InputManager.instance.rightPressed && this.position.x <= 550) {
            velocity.x += 3;
        }

        this.position.addUp(velocity);
    }
}
