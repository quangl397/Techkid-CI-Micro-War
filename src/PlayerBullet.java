import java.awt.*;

public class PlayerBullet {
    int x;
    int y;
    Image image;

    PlayerBullet(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = ImageUtil.load("images/bullet/player/mb69bullet1.png");
    }

    void update() {
        this.y -= 5;
    }

    void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }
}
