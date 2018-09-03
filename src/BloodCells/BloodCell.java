package BloodCells;

import bases.GameObject;
import bases.ImageRenderer;

public class BloodCell extends GameObject {
    public BloodCell(int x, int y) {
        super(x, y);
        imageRenderer = new ImageRenderer("images/blood cells/blood-cell1.png");
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(-3, 2);
    }
}
