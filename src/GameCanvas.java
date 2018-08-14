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

    int x = 300 - 32;
    int y = 650 - 40;

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

        PlayerBullet b1 = new PlayerBullet();
        b1.x = 300;
        b1.y = 200;

        PlayerBullet b2 = new PlayerBullet();
        b2.x = 200;
        b2.y = 500;

        try {
            background = ImageIO.read(new File("images/background/background.png"));
            player = ImageIO.read(new File("images/player/MB-69/player1.png"));
            b1.image = ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));
            b2.image = ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        bs.add(b1);
        bs.add(b2);

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
        if (upPressed) {
            y -= 3;
        }

        if (downPressed) {
            y += 3;
        }

        if (leftPressed) {
            x -= 3;
        }

        if (rightPressed) {
            x += 3;
        }

        for (PlayerBullet b: bs) {
            b.y -= 5;
        }

        if (xPressed) {
            System.out.println("Shoot");
            PlayerBullet newB = new PlayerBullet();
            newB.x = x + 8;
            newB.y = y - 40;
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
            if (count > 1) {
                shootLock = false;
                count = 0;
            }
        }
    }

    boolean shootLock = false;
    int count;

    void render() {
        backBufferGraphics.drawImage(background, 0, 0, null);
        backBufferGraphics.drawImage(player, x, y, null);
        for (PlayerBullet b: bs) {
            backBufferGraphics.drawImage(b.image, b.x, b.y, null);
        }
        this.repaint();
    }
}

