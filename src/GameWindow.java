import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLOutput;

public class GameWindow extends JFrame {
    GameCanvas canvas;

    public GameWindow() {
        // Setup game window
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() ==  KeyEvent.VK_UP) {
                    canvas.keyPressed(e);
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    canvas.keyPressed(e);
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    canvas.keyPressed(e);
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    canvas.keyPressed(e);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                canvas.keyReleased(e);
            }
        });
        this.setSize(600, 800);
        this.setResizable(false);
        this.setTitle("Micro War");

        // Setup canvas
        canvas = new GameCanvas();
        this.setContentPane(canvas);

        this.setVisible(true);
    }

    long lastTimeRender = 0;

    void mainLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTimeRender >= 17_000_000) {
                canvas.run();
                canvas.render();
                lastTimeRender = currentTime;
            }
        }
    }
}

