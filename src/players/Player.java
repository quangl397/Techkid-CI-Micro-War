package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;

public class Player extends GameObject {
    PlayerMove playerMove;
    PlayerShoot playerShoot;

    public Player(int x, int y) {
        super(x, y);
        imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(x, y, 50, 50);
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

    public void getHit() {
        this.gameOver();
    }
}