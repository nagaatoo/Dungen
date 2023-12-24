package ru.numbdev.dungen.item;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Player extends AbstractElement {


    public Player(Skin skin) {
        super(skin);
        this.setColor(Color.BLUE);
        this.setName("Player");
    }

}
