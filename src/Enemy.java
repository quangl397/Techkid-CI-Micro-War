import java.awt.*;

public class Enemy {
    int x;
    int y;
    Image image;

    Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
    }

    void update() {
        this.y += 3;
    }

    void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }
}
