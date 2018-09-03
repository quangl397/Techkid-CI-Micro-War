package game;

import bases.GameObject;
import bases.FrameCounter;
import enemies.Enemy;

import java.util.Random;

public class EnemySpawner {
    Random random;
    FrameCounter frameCounter;

    EnemySpawner() {
        random = new Random();
        frameCounter = new FrameCounter(100);
    }

    void run() {
        frameCounter.run();
        if (frameCounter.expired) {
            frameCounter.reset();
            Enemy newEnemy = new Enemy(random.nextInt(600), -64);
            GameObject.add(newEnemy);
        }
    }
}
