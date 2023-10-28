package ru.numbdev.dungen.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

import ru.numbdev.dungen.element.ViewCamera;
import ru.numbdev.dungen.item.Controller;
import ru.numbdev.dungen.item.Player;

public class GameInputEngine implements InputProcessor {

    private Vector2 touchedPosition = null;
    private boolean isTouchedController = false;

    private final ViewCamera camera;
    private final Controller controller;
    private final Player player;

    public GameInputEngine(ViewCamera camera, Controller controller, Player player) {
        this.camera = camera;
        this.controller = controller;
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touchedPosition = null;
        isTouchedController = false;
        controller.clearDirection();
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int touchedX, int touchedY, int pointer) {
        if (pointer > 0) {
            return false;
        }

        if (controller.isTouched(touchedX, touchedY) || isTouchedController) {
            isTouchedController = true;
            touchedPosition = new Vector2(touchedX, touchedY);
            player.movePlayer(controller.getDirection(touchedPosition));
            camera.position.set(player.getCenterX(), player.getCenterY(), 0);
        } else {
            if (touchedPosition == null) {
                touchedPosition = new Vector2(touchedX, touchedY);
            } else {
                float deltaX = touchedX - touchedPosition.x;
                float deltaY = touchedY - touchedPosition.y;

                float newX = camera.position.x - deltaX;
                float newY = camera.position.y + deltaY;
                camera.position.set(newX, newY, 0);
                touchedPosition = new Vector2(touchedX, touchedY);
            }
        }
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
