package ru.numbdev.dungen.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class Steps extends AbstractElement {

    public Steps() {
        super();
        this.setColor(Color.YELLOW);
        this.setName("Steps");
        this.setHeight(Gdx.graphics.getHeight() - 300);
        this.setWidth(100);
    }
}
