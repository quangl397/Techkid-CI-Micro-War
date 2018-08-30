package enemies;

import java.awt.*;
import bases.Vector2D;
import bases.ImageUtil;

public class EnemyBullet {
    Vector2D position;
    Image image;

    EnemyBullet(int x, int y) {
        this.position = new Vector2D(x, y);
        this.image = ImageUtil.load("images/bullet/enemy/enemy2_bullet1.png");
    }

    void update() {
        Vector2D velocity = new Vector2D();
        velocity.y += 5;
        this.position.addUp(velocity);
    }

    public void render(Graphics g) {
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
    }
}
