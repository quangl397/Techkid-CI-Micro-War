class PlayerMove {
    Vector2D position;
    InputManager inputManager;

    PlayerMove(InputManager inputManager, Vector2D position) {
        this.inputManager = inputManager;
        this.position = position;
    }

    void move() {
        Vector2D velocity = new Vector2D();
        if (inputManager.upPressed && (this.position.y >= 0)) {
            velocity.y -= 3;
        }

        if (inputManager.downPressed && (this.position.y <= 600)) {
            velocity.y += 3;
        }

        if (inputManager.leftPressed && (this.position.x >= -30)) {
            velocity.x -= 3;
        }

        if (inputManager.rightPressed && this.position.x <= 550) {
            velocity.x += 3;
        }

        this.position.addUp(velocity);
    }
}
