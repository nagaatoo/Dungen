package ru.numbdev.dungen.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Enemy extends AbstractElement {

    public Enemy(Skin skin) {
        super(skin);
        this.setColor(Color.RED);
//        this.setHeight(Gdx.graphics.getHeight() - 300);
//        this.setWidth(100);
    }
}
