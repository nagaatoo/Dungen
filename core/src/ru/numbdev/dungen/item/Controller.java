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

    public void calculatePosOnScreen() {
        float xPos = camera.position.x + (camera.viewportWidth / 2) - img.getWidth() - indent;
        float yPos = camera.position.y - (camera.viewportHeight / 2) + img.getHeight() + indent;

        this.setPosition(posXonScreen = xPos - (img.getWidth() / 2), posYonScreen = yPos - (img.getHeight() / 2));
    }

    public boolean isTouched(float x, float y) {
        float hX = img.getWidth();
        float hY = img.getHeight();
        float radius = img.getWidth() / 2;

        // Center of controller
        float xPos = Gdx.graphics.getWidth() - getOriginX() - indent;
        float yPos = Gdx.graphics.getHeight() - getOriginY() - indent;

        return Math.sqrt(Math.pow((x - xPos) + indent*2, 2) + Math.pow((y - yPos) + indent*2, 2)) < radius;
    }
}
