package players;

import java.awt.*;
import java.util.ArrayList;

import bases.ImageRenderer;
import bases.Vector2D;

public class Player {
    Vector2D position;
    ImageRenderer imageRenderer;
    PlayerMove playerMove;
    PlayerShoot playerShoot;

    public ArrayList<PlayerBullet> bullets;

    public Player(int x, int y) {
        this.position = new Vector2D(x, y);
        imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
    }

    public void update() {
        playerMove = new PlayerMove(position);
        playerShoot = new PlayerShoot();
        playerMove.run();
        playerShoot.run(this);

        for (PlayerBullet n: bullets) {
            n.update();
        }
    }

    public void render(Graphics g) {
        imageRenderer.render(g, this.position);
    }
}