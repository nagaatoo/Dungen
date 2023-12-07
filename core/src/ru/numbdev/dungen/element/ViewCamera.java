package ru.numbdev.dungen.element;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class ViewCamera extends OrthographicCamera {

    public ViewCamera() {
        super(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }


}
