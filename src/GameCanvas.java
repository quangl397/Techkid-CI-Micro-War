import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    InputManager inputManager;

    // Load
    public GameCanvas() {
        inputManager = new InputManager();

        random = new Random();

        player = new Player(268, 600);
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();

        background = ImageUtil.load("images/background/background.png");

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();

        player.inputManager = inputManager;
    }

    // Draw
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    void update() {
        player.update(bullets);

        for (Enemy n: enemies) {
            n.update();
        }

        if (enemySpawnCount >= 60) {
            enemySpawnCount = 0;
            int posX = random.nextInt(556);
            Enemy enemy = new Enemy(posX, 0);
            enemies.add(enemy);
        }
        else {
            enemySpawnCount++;
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

