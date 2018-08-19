import java.awt.*;
import java.util.ArrayList;

public class Player {
    int x;
    int y;
    Image image = null;

    InputManager inputManager;

    boolean shootLock = false;
    int count;

    Player(int x, int y) {
        this.x = x;
        this.y = y;
        image = ImageUtil.load("images/player/MB-69/player1.png");
    }

    void update(ArrayList<PlayerBullet> bullets) {


        if (inputManager.upPressed && (this.y >= 0)) {
            this.y -= 3;
        }

        if (inputManager.downPressed && (this.y <= 600)) {
            this.y += 3;
        }

        if (inputManager.leftPressed && (this.x >= -30)) {
            this.x -= 3;
        }

        if (inputManager.rightPressed && this.x <= 550) {
            this.x += 3;
        }

        if (shootLock) {
            count++;
            if (count > 20) {
                shootLock = false;
                count = 0;
            }
        }

        if (inputManager.xPressed && !shootLock) {
            int posX = this.x + 8;
            int posY = this.y - 40;
            PlayerBullet newB = new PlayerBullet(posX, posY);
            bullets.add(newB);
            shootLock = true;
        }

        for (PlayerBullet n: bullets) {
            n.update();
        }
    }

    void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }
}
