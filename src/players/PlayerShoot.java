package players;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import inputs.InputManager;

public class PlayerShoot {
    private boolean shootLock;
    FrameCounter frameCounter = new FrameCounter(50);

    void run(Player player) {
        if (InputManager.instance.xPressed && !shootLock) {
            Vector2D bulletPosition1 = player.position.subtract(18, 50);
            Vector2D bulletPosition2 = player.position.subtract(-20, 50);
            PlayerBullet newBullet1 = new PlayerBullet((int)bulletPosition1.x,(int)bulletPosition1.y);
            PlayerBullet newBullet2 = new PlayerBullet((int)bulletPosition2.x,(int)bulletPosition2.y);
            GameObject.add(newBullet1);
            GameObject.add(newBullet2);
            shootLock = true;
        }

        if (shootLock) {
            frameCounter.run();
            if (frameCounter.expired) {
                frameCounter.reset();
                shootLock = false;
            }
        }
    }
}