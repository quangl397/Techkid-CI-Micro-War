package game;

import BloodCells.BloodCell;
import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class BloodCellSpawner {
    Random random;
    FrameCounter frameCounter;

    BloodCellSpawner() {
        random = new Random();
        frameCounter = new FrameCounter(100);
    }

    void run() {
        frameCounter.run();
        if (frameCounter.expired) {
            frameCounter.reset();
            BloodCell newBloodCell = new BloodCell(700, random.nextInt(700));
            GameObject.add(newBloodCell);
        }
    }
}
