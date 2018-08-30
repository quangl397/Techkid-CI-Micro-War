package players;

import bases.FrameCounter;
import inputs.InputManager;

public class PlayerShoot {
    FrameCounter frameCounter;
    boolean shootLock = false;

    void run(Player player) {
        frameCounter = new FrameCounter(20);

        if (InputManager.instance.xPressed && !this.shootLock) {
            PlayerBullet newB = new PlayerBullet((int) player.position.x + 8, (int) player.position.y - 40);
            player.bullets.add(newB);
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
