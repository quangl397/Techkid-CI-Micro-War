package game;

import bases.GameObject;
import bases.ImageRenderer;

public class Background extends GameObject {
    Background(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/background/background.png");
    }
}
