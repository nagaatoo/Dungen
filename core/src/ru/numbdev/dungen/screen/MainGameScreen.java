package ru.numbdev.dungen.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;
import java.util.List;

import ru.numbdev.dungen.Dungen;
import ru.numbdev.dungen.enums.Screens;
import ru.numbdev.dungen.input.GameInputEngine;
import ru.numbdev.dungen.element.ViewCamera;
import ru.numbdev.dungen.item.Player;

public class MainGameScreen implements DungeonScreen {

    private final Dungen game;

    private GameInputEngine inputEngine;

    private final List<Actor> actorElements = new ArrayList<>();
    private final List<Sprite> gameplayElements = new ArrayList<>();
    private final List<Sprite> controlElements = new ArrayList<>();
    private Player player;

    // Переделать на https://gist.github.com/Leejjon/7fb8aa3ea2e4024a9eba31fa4f3339fb
    public MainGameScreen(Dungen game) {
        this.game = game;
        player = new Player();
        inputEngine = new GameInputEngine(player);

        Player test = new Player();
        test.setPosition(300, 300);
        actorElements.add(test);
        actorElements.add(player);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        for(Actor actor : actorElements) {
            actor.draw(game.batch, 0);
        }
        for (Sprite element : gameplayElements) {
            element.draw(game.batch);
        }
        for (Sprite element : controlElements) {
            element.draw(game.batch);
        }
        game.batch.end();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(inputEngine);
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
        return Screens.GAME;
    }
}
