package ru.numbdev.dungen.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import ru.numbdev.dungen.element.ViewCamera;
import ru.numbdev.dungen.system.Pair;

public class Controller extends Sprite {

    private static final int STEP = 3;
    private final static int INDENT = 70;

    private static final Texture IMG = new Texture("controller.png");
    private final ViewCamera camera;

    private Vector2 previous = null;
    private Pair previousDifferent = Pair.of(0, 0);

    public Controller(ViewCamera camera) {
        super(IMG);
        this.camera = camera;
    }

    public void calculatePosOnScreen() {
        float xPos = camera.position.x + (camera.viewportWidth / 2) - IMG.getWidth() - INDENT;
        float yPos = camera.position.y - (camera.viewportHeight / 2) + IMG.getHeight() + INDENT;

        this.setPosition(xPos - (IMG.getWidth() / 2), yPos - (IMG.getHeight() / 2));
    }

    public boolean isTouched(float x, float y) {
        float radius = IMG.getWidth() / 2;

        // Center of controller
        float xPos = Gdx.graphics.getWidth() - getOriginX() - INDENT;
        float yPos = Gdx.graphics.getHeight() - getOriginY() - INDENT;

        return Math.sqrt(Math.pow((x - xPos) + INDENT *2, 2) + Math.pow((y - yPos) + INDENT *2, 2)) < radius;
    }

    public Pair getDirection(Vector2 touched) {
        float x = 0;
        float y = 0;

         if (previous != null) {
             // TODO запоминание движения не работает - допчинить
             if (previous.equals(touched)) {
                 x = previousDifferent.getX();
                 y = previousDifferent.getY();
             } else {
                 if (touched.y > previous.y) {
                     y -= STEP;
                 }

                 if (touched.y <= previous.y) {
                     y += STEP;
                 }

                 if (touched.x < previous.x) {
                     x -= STEP;
                 }

                 if (touched.x >= previous.x) {
                     x += STEP;
                 }

                 previousDifferent = Pair.of(touched.x - previous.x, touched.y - previous.y);
             }
        }

        previous = touched;
        return Pair.of(x, y);
    }

    public void clearDirection() {
        previous = null;
        previousDifferent = Pair.of(0, 0);
    }
}
