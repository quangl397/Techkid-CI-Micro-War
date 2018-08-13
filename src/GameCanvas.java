import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    Image background;
    Image player;
    int x = 300 - 32;
    int y = 650 - 40;
    boolean upPressed = false;
    boolean downPressed = false;
    boolean leftPressed = false;
    boolean rightPressed = false;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    // Load
    public GameCanvas() {
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
    }

    void render() {
        backBufferGraphics.drawImage(background, 0, 0, null);
        backBufferGraphics.drawImage(player, x, y, null);
        this.repaint();
    }
}

