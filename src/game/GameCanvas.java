package game;

import bases.GameObject;
import players.Player;
import Player2.Player2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    Background background;

    Player player;
    Player2 player2;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    EnemySpawner enemySpawner;
    BloodCellSpawner bloodCellSpawner;

    public GameCanvas() {
        background = new Background(300, 400);
        GameObject.add(background);

        player = new Player(300, 650);
        GameObject.add(player);

        player2 = new Player2(400, 650);
        GameObject.add(player2);

        GameObject.add(new EnemySpawner());

        GameObject.add(new BloodCellSpawner());

        backBuffer = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(backBuffer,0,0,null);
    }

    void run() {
        GameObject.runAll();
    }

    void render() {
        GameObject.renderAll(backBufferGraphics);

        this.repaint();
    }
}