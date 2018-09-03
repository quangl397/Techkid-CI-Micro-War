package game;

import BloodCells.BloodCell;
import bases.GameObject;
import players.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    Background background;

    Player player;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    EnemySpawner enemySpawner;
    BloodCellSpawner bloodCellSpawner;

    public GameCanvas() {
        background = new Background(300, 400);
        GameObject.add(background);

        player = new Player(300, 650);
        GameObject.add(player);

        enemySpawner = new EnemySpawner();
        bloodCellSpawner = new BloodCellSpawner();

        backBuffer = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(backBuffer,0,0,null);
    }

    void run() {
        GameObject.runAll();
        enemySpawner.run();
        bloodCellSpawner.run();
    }

    void render() {
        GameObject.renderAll(backBufferGraphics);

        this.repaint();
    }
}