package ru.numbdev.dungen.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Steps extends AbstractElement {

    public Steps(Skin skin) {
        super(skin);
        this.setColor(Color.YELLOW);
        this.setName("Steps");
        this.setWidth(200);
    }
}
