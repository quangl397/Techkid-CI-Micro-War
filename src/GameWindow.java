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
                canvas.inputManager.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                canvas.inputManager.keyReleased(e);
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

    // Game Loop
    void mainLoop() {
        long lastTimeRender = 0;
        long currentTime;

        while (true) {
            currentTime = System.nanoTime();
            if (currentTime - lastTimeRender >= 17_000_000) {
                canvas.update();
                canvas.render();
                lastTimeRender = currentTime;
            }
        }
    }
}

