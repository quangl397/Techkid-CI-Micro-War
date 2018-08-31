package players;

import java.util.ArrayList;

import bases.GameObject;
import bases.ImageRenderer;

public class Player extends GameObject {
    PlayerMove playerMove;
    PlayerShoot playerShoot;

    public ArrayList<PlayerBullet> bullets;

    public Player(int x, int y) {
        super(x, y);
        imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
    }

    public void run() {
        super.run();
        this.move();
        this.shoot();
    }

    void move() {
        this.playerMove.run(position);
    }

    void shoot() {
        this.playerShoot.run(this);
    }
}