package ru.numbdev.dungen.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import ru.numbdev.dungen.Dungen;
import ru.numbdev.dungen.enums.Screens;
import ru.numbdev.dungen.input.MenuInputEngine;

public class MenuScreen implements DungeonScreen {

    private final Dungen game;

    private final MenuInputEngine inputEngine;

    private Label label;

    public MenuScreen(Dungen game) {
        this.game = game;
        inputEngine = new MenuInputEngine(game);
        init();
    }

    private void init() {
        Label.LabelStyle label1Style = new Label.LabelStyle();
        BitmapFont myFont = new BitmapFont(Gdx.files.internal("bitmapfont/Amble-Regular-26.fnt"));
        label1Style.font = myFont;
        label1Style.fontColor = Color.RED;

        label = new Label("Tap for begin", label1Style);
        label.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(inputEngine);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        label.draw(game.batch, 5);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public Screens getName() {
        return Screens.MAIN_MENU;
    }
}
