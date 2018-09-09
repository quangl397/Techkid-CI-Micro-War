package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import enemies.Enemy;

public class PlayerBullet extends GameObject {
    public PlayerBullet(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");
        this.boxCollider = new BoxCollider(x, y, 15, 40);
    }

    public void run() {
        super.run();
        move();
        hitEnemies();
    }

    private void hitEnemies() {
        Enemy enemy = GameObject.checkCollisionOfEnemy(this.boxCollider);

        if (enemy != null) {
            enemy.getHit();
            this.destroy();
        }
    }

    private void move() {
        this.position.addUp(0, -5);
    }
}