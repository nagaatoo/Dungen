package ru.numbdev.dungen.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Enemy extends AbstractElement {

    public Enemy() {
        super();
        this.setColor(Color.RED);
        this.setHeight(Gdx.graphics.getHeight() - 300);
        this.setWidth(100);
    }
}
