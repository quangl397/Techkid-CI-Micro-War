import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class ImageRenderer {
    Image image;

    ImageRenderer(String url) {
        this.image = ImageUtil.load(url);
    }

    void render(Graphics g, Vector2D position) {
        g.drawImage(this.image, (int)position.x, (int)position.y, null);
    }
}
