package enemies;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import bases.GameObject;
import bases.ImageRenderer;

public class Enemy extends GameObject {
    public ArrayList<EnemyBullet> enemyBullets;
    Random random;

    EnemyShoot enemyShoot;
    EnemyMove enemyMove;

    public Enemy(int x, int y) {
        super(x, y);
        imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        random = new Random();
        enemyMove = new EnemyMove();
        enemyShoot = new EnemyShoot();
        enemyBullets = new ArrayList<>();
    }

    public void run() {
        this.move();
        this.shoot();

        for (EnemyBullet e: enemyBullets) {
            e.run();
        }
    }
    public void shoot() {
        this.enemyShoot.run(this);
    }

    public void move() {
        this.enemyMove.run(position);
    }

    public void render(Graphics g) {
        imageRenderer.render(g, this.position);

        for (EnemyBullet e: enemyBullets) {
            e.render(g);
        }
    }
}