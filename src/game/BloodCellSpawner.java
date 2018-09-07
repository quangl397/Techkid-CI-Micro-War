package game;

import BloodCells.BloodCell;
import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class BloodCellSpawner extends GameObject {
    Random random;
    FrameCounter frameCounter;

    BloodCellSpawner() {
        super(0, 0);
        random = new Random();
        frameCounter = new FrameCounter(100);
    }

    public void run() {
        frameCounter.run();
        if (frameCounter.expired) {
            frameCounter.reset();
            BloodCell newBloodCell = new BloodCell(600, random.nextInt(700));
            GameObject.add(newBloodCell);
        }
    }
}
