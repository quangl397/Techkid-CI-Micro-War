package enemies;

import bases.FrameCounter;
import bases.GameObject;

public class EnemyShoot {
    FrameCounter frameCounter = new FrameCounter(100);

    public void run(Enemy enemy) {
        frameCounter.run();
        if (frameCounter.expired) {
            EnemyBullet newB = new EnemyBullet((int)enemy.position.x + 8, (int)enemy.position.y + 40);
            GameObject.add(newB);
            frameCounter.reset();
        }
    }
}