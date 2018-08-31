package game;

import bases.FrameCounter;
import bases.GameObject;
import enemies.Enemy;
import enemies.EnemyBullet;
import inputs.InputManager;
import players.Player;
import players.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import bases.ImageUtil;

public class GameCanvas extends JPanel {
    Image background;

    Player player;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    Random random;

    FrameCounter frameCounter;

    public GameCanvas() {
        random = new Random();
        frameCounter = new FrameCounter(100);

        player = new Player(300, 650);
        GameObject.add(player);

        background = ImageUtil.load("images/background/background.png");

        backBuffer = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(backBuffer,0,0,null);
    }


    void run() {
        GameObject.runAll();

        enemySpawn();
    }

    void enemySpawn() {
        frameCounter.run();
        if (frameCounter.expired) {
            frameCounter.reset();
            Enemy newEnemy = new Enemy(random.nextInt(600), -64);
            GameObject.add(newEnemy);
        }
    }

    void render() {
        backBufferGraphics.drawImage(background,0,0, null);

        GameObject.renderAll(backBufferGraphics);

        this.repaint();
    }
}