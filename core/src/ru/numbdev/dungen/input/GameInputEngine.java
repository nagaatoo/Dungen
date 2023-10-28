package ru.numbdev.dungen.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

import ru.numbdev.dungen.element.ViewCamera;
import ru.numbdev.dungen.item.Controller;
import ru.numbdev.dungen.item.Player;

public class GameInputEngine implements InputProcessor {

    private Vector2 touchedPosition = null;

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

        int screenX = touchedX;
        int screenY = touchedY;
        if (controller.isTouched(touchedX, touchedY)) {
            camera.position.set(player.getOriginX(), player.getOriginY(), 0);
        } else {
            if (touchedPosition == null) {
                touchedPosition = new Vector2(screenX, screenY);
            } else {

                float deltaX = screenX - touchedPosition.x;
                float deltaY = screenY - touchedPosition.y;

                float newX = camera.position.x - deltaX;
                float newY = camera.position.y + deltaY;
                camera.position.set(newX, newY, 0);
                touchedPosition = new Vector2(screenX, screenY);
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
