package ru.numbdev.dungen.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public abstract class AbstractElement extends Group {

    public AbstractElement() {
//        this.setBounds(300, 300, 200, 200);
//        this.setSize(300, 300);
    }

    public void setElementDebug(boolean enabled) {
        for (Actor child : getChildren()) {
            child.setDebug(enabled);
        }
    }
}
