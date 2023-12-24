package ru.numbdev.dungen.item;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class ButtonBar extends AbstractElement {

    private final Skin skin;
    private final Table play = new Table();

    public ButtonBar(Skin skin) {
        super();
        this.skin = skin;
        this.setColor(Color.BROWN);
        this.setHeight(180);

        initPlay();
    }

    private void initPlay() {
        play.defaults().pad(10F);
        play.setFillParent(true);
        Button playButton = new Button(skin);
        play.add(playButton).expandX().align(Align.left);

        Button menuButton = new Button(skin);
        play.add(menuButton).expandX().align(Align.right);
        this.addActor(play);
    }
}
