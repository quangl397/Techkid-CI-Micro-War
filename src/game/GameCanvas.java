package game;

import bases.FrameCounter;
import bases.ImageUtil;
import enemies.Enemy;
import players.Player;
import players.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {
    Image background;

    Player player;
    ArrayList<PlayerBullet> bullets;
    ArrayList<Enemy> enemies;

    int enemySpawnCount;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    Random random;

    // Load
    public GameCanvas() {
        random = new Random();

        bullets = new ArrayList<>();
        enemies = new ArrayList<>();

        player = new Player(268, 600);
        player.bullets = this.bullets;

        background = ImageUtil.load("images/background/background.png");

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    // Draw
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    void update() {
        player.update();

        for (Enemy n: enemies) {
            n.update();
        }

        FrameCounter frameCounter = new FrameCounter(60);

        if (!frameCounter.expired) {
            int posX = random.nextInt(556);
            Enemy enemy = new Enemy(posX, 0);
            enemies.add(enemy);
            frameCounter.reset();
        }
        else {
            frameCounter.run();
        }
    }

    void render() {
        backBufferGraphics.drawImage(background, 0, 0, null);
        player.render(backBufferGraphics);

        for (PlayerBullet n: bullets) {
            n.render(backBufferGraphics);
        }

        for (Enemy n: enemies) {
            n.render(backBufferGraphics);
        }

        this.repaint();
    }
}

