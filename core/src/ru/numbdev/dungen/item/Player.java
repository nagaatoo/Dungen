package ru.numbdev.dungen.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

import java.util.ArrayList;
import java.util.List;

import ru.numbdev.dungen.context.PlayerContextHolder;

public class Player extends AbstractElement implements Players {

    private final Table steps = new Table();
    private final Table stack = new Table();

    private final Image avatar = new Image(new Texture(Gdx.files.internal("badlogic.jpg")));

    public Player(Skin skin) {
        super(skin);

        // TODO engine
        this.setColor(Color.BLUE);
        this.setName("Player");
        buildSteps();
    }

    private void buildSteps() {
        stack.add(new Label("Skills", skin)).height(100).row();
        SelectBox<String> box = new SelectBox<>(skin);
        box.setItems("One", "Two", "Three");
        box.setAlignment(Align.center);
        stack.add(box).size(650, 250).row();
        stack.add(new SelectBox<String>(skin)).row();
        stack.add(new SelectBox<String>(skin)).row();
        stack.add(new SelectBox<String>(skin)).row();

        int sideAvatar = Gdx.graphics.getWidth() / 10;
        steps.add(PlayerContextHolder.getAvatar()).size(sideAvatar, sideAvatar);
        steps.row();
        steps.add(stack);
        steps.defaults().pad(20f);
        this.addActor(steps);
    }

    @Override
    public void prepareAction() {

    }

    @Override
    public void action() {

    }
}
