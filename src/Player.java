import java.awt.*;
import java.util.ArrayList;

public class Player {
    Vector2D position;
    ImageRenderer imageRenderer;
    PlayerMove playerMove;
    InputManager inputManager;

    boolean shootLock = false;
    int count;

    ArrayList<PlayerBullet> bullets;

    Player(int x, int y) {
        this.position = new Vector2D(x, y);
        imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
    }

    void update() {
        playerMove = new PlayerMove(inputManager, position);
        playerMove.move();
        this.shoot();

        for (PlayerBullet n: bullets) {
            n.update();
        }
    }

    private void shoot() {
        if (this.shootLock) {
            this.count++;
            if (count > 20) {
                this.shootLock = false;
                this.count = 0;
            }
        }

        if (inputManager.xPressed && !this.shootLock) {
            PlayerBullet newB = new PlayerBullet((int)this.position.x + 8, (int)this.position.y - 40);
            this.bullets.add(newB);
            this.shootLock = true;
        }
    }

//    private void move() {
//        Vector2D velocity = new Vector2D();
//        if (inputManager.upPressed && (this.position.y >= 0)) {
//            velocity.y -= 3;
//        }
//
//        if (inputManager.downPressed && (this.position.y <= 600)) {
//            velocity.y += 3;
//        }
//
//        if (inputManager.leftPressed && (this.position.x >= -30)) {
//            velocity.x -= 3;
//        }
//
//        if (inputManager.rightPressed && this.position.x <= 550) {
//            velocity.x += 3;
//        }
//
//        this.position.addUp(velocity);
//    }

    void render(Graphics g) {
        imageRenderer.render(g, this.position);
    }
}