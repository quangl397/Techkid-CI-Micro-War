package enemies;

import bases.GameObject;
import bases.ImageRenderer;

public class EnemyBullet extends GameObject {
    public EnemyBullet(int x, int y) {
        super(x, y);
        imageRenderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet2.png");
    }

    public void run() {
        super.run();
        this.position.addUp(0, 5);
    }
}