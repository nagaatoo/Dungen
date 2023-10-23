package ru.numbdev.dungen.element;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class ViewCamera extends OrthographicCamera {

    private static final int WIDTH  = 1920;
    private static final int HEIGHT = 1024;


    public ViewCamera() {
        super(WIDTH, HEIGHT);
    }

    public ViewCamera(float viewportWidth, float viewportHeight) {
        super(viewportWidth, viewportHeight);
    }


}
