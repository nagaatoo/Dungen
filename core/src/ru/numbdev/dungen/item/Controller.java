package ru.numbdev.dungen.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.numbdev.dungen.element.ViewCamera;

public class Controller extends Sprite {

    private final static int indent = 70;

    private static Texture img = new Texture("controller.png");
    private ViewCamera camera;

    private float posXonScreen;
    private float posYonScreen;

    public Controller(ViewCamera camera) {
        super(img);
        this.camera = camera;
    }

    public Controller(int xPos, int yPos) {
        super(img, xPos, yPos, 50, 50);
    }

    public void calculatePosOnScreen() {
        float xPos = camera.position.x + (camera.viewportWidth / 2) - img.getWidth() - indent;
        float yPos = camera.position.y - (camera.viewportHeight / 2) + img.getHeight() + indent;


        this.setPosition(xPos - (img.getWidth() / 2), yPos - (img.getHeight() / 2));
    }

    public boolean isTouched(float x, float y) {
        return true;
//        return this.x <= x && this.x + img.getWidth() >= x && this.y <= y && this.y + img.getHeight()  >= y;
    }
}
