import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    Image background;
    Image player;

    ArrayList<PlayerBullet> bs;

    int playerX = 300 - 32;
    int playerY = 650 - 40;

    boolean upPressed = false;
    boolean downPressed = false;
    boolean leftPressed = false;
    boolean rightPressed = false;
    boolean xPressed = false;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    // Load
    public GameCanvas() {
        bs = new ArrayList<>();

        try {
            background = ImageIO.read(new File("images/background/background.png"));
            player = ImageIO.read(new File("images/player/MB-69/player1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    // Draw
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    void keyPressed(KeyEvent e) {
        if (e.getKeyCode() ==  KeyEvent.VK_UP) {
            upPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = true;
        }
    }

    void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = false;
        }
    }

    void run() {
        if (upPressed && (playerY >= 0)) {
            playerY -= 3;
        }

        if (downPressed && (playerY <= 620)) {
            playerY += 3;
        }

        if (leftPressed && (playerX >= 0)) {
            playerX -= 3;
        }

        if (rightPressed && playerX <= 520) {
            playerX += 3;
        }

        for (PlayerBullet b: bs) {
            b.y -= 5;
        }

        if (xPressed && !shootLock) {
            PlayerBullet newB = new PlayerBullet();
            newB.x = playerX + 8;
            newB.y = playerY - 40;
            try {
                newB.image = ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            bs.add(newB);
            shootLock = true;
        }

        if (shootLock) {
            count++;
            if (count > 20) {
                shootLock = false;
                count = 0;
            }
        }
    }

    boolean shootLock = false;
    int count;

    void render() {
        backBufferGraphics.drawImage(background, 0, 0, null);
        backBufferGraphics.drawImage(player, playerX, playerY, null);
        for (PlayerBullet b: bs) {
            backBufferGraphics.drawImage(b.image, b.x, b.y, null);
        }
        this.repaint();
    }
}

