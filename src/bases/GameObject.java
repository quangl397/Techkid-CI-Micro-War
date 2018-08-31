package bases;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public ImageRenderer imageRenderer;

    private static ArrayList<GameObject> gameObjects = new ArrayList<>();
    private static ArrayList<GameObject> newGameObjects = new ArrayList<>();

    public static void add(GameObject g) {
        newGameObjects.add(g);
    }

    public static void runAll() {
        for (GameObject g: gameObjects) {
            g.run();
        }
    }

    public static void renderAll(Graphics g) {
        for (GameObject gr: gameObjects) {
            gr.render(g);
        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public GameObject(int x, int y) {
        this.position = new Vector2D(x, y);
        this.imageRenderer = null; // not yet specified
    }

    public void run() {

    }

    public void render(Graphics g) {
        if (this.imageRenderer != null) {
            this.imageRenderer.render(g, this.position);
        }
    }
}