package game;

import bases.GameObject;
import bases.FrameCounter;
import enemies.Enemy;

import java.util.Random;

public class EnemySpawner extends GameObject {
    private Random random;
    private FrameCounter frameCounter;

    EnemySpawner() {
        super(0, 0);
        random = new Random();
        frameCounter = new FrameCounter(100);
    }

    public void run() {
        frameCounter.run();
        if (frameCounter.expired) {
            frameCounter.reset();
            Enemy newEnemy = new Enemy(random.nextInt(600), 0);
            GameObject.add(newEnemy);
        }
    }
}
