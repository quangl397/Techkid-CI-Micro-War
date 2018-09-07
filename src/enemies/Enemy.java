package enemies;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import bases.BoxCollider;
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
        this.boxCollider = new BoxCollider(x, y, 30, 30);
    }

    public void run() {
        super.run();
        this.move();
        this.shoot();
    }

    public void getHit() {
        this.destroy();
    }

    public void shoot() {
        this.enemyShoot.run(this);
    }

    public void move() {
        this.enemyMove.run(position);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }
}