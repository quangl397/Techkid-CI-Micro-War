package enemies;

import bases.FrameCounter;

public class EnemyShoot {
    FrameCounter frameCounter;
    boolean shootLock = false;

    void run(Enemy enemy) {
        frameCounter = new FrameCounter(20);

        if (!this.shootLock) {
            EnemyBullet newB = new EnemyBullet((int) enemy.position.x, (int) enemy.position.y);
            enemy.bullets.add(newB);
            this.shootLock = true;
        }

        if (this.shootLock) {
            frameCounter.run();
            if (frameCounter.expired) {
                this.shootLock = false;
                frameCounter.reset();
            }
        }
    }
}
