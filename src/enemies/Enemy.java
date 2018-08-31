package enemies;

import bases.ImageRenderer;
import bases.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class Enemy {
    Vector2D position;
    ImageRenderer imageRenderer;
    //EnemyMove enemyMove;
    EnemyShoot enemyShoot;

    public ArrayList<EnemyBullet> bullets;

    public Enemy(int x, int y) {
        this.position = new Vector2D(x, y);
        imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
    }

    public void update() {
        Vector2D velocity = new Vector2D();
        velocity.y += 3;
        this.position.addUp(velocity);

        enemyShoot = new EnemyShoot();
        enemyShoot.run(this);

        for (EnemyBullet n: bullets) {
            n.update();
        }
    }

    public void render(Graphics g) {
        imageRenderer.render(g, this.position);
    }
}
