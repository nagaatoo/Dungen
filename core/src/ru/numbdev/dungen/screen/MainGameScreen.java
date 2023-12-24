package ru.numbdev.dungen.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.numbdev.dungen.Dungen;
import ru.numbdev.dungen.element.ViewCamera;
import ru.numbdev.dungen.enums.Screens;
import ru.numbdev.dungen.input.GameInputEngine;
import ru.numbdev.dungen.item.AbstractElement;
import ru.numbdev.dungen.item.ButtonBar;
import ru.numbdev.dungen.item.Enemy;
import ru.numbdev.dungen.item.Player;
import ru.numbdev.dungen.item.Steps;

public class MainGameScreen implements DungeonScreen {

    private final Dungen game;

    private GameInputEngine inputEngine;

//    private final Player player;

    private Stage stage;
    private Skin skin;
    private BitmapFont defaultFont = new BitmapFont(Gdx.files.internal("bitmapfont/Amble-Regular-26.fnt"));

    public MainGameScreen(Dungen game) {
        this.game = game;
//        player = new Player();
//        inputEngine = new GameInputEngine(player);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor( 0, 0, 0, 0 );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        stage.act();
        stage.draw();

//        game.batch.begin();
//        player.draw(game.batch, 0);
//        game.batch.end();
    }

    @Override
    public void show() {
        Viewport viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new ViewCamera());
        stage = new Stage(viewport);

        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("test.json"));
        TextureAtlas buttonAtlas = new TextureAtlas(Gdx.files.internal("test.atlas"));
        skin.addRegions(buttonAtlas);
        buildMenu();
    }

    private void buildMenu(){
        AbstractElement player = new Player(skin);
        AbstractElement steps = new Steps(skin);
        AbstractElement enemy = new Enemy(skin);
        AbstractElement buttonBar = new ButtonBar(skin);

        buttonBar.setElementDebug(true);
        player.setElementDebug(true);
        steps.setElementDebug(true);
        enemy.setElementDebug(true);

        Table table= new Table();
        table.defaults().pad(10F);
        table.setFillParent(true);

        table.add(new Label("PLAYER",skin)).expand();
        table.add(steps);
        table.add(new Label("ENEMY",skin)).expand();
        table.row();
        table.add(buttonBar).colspan(3).fillX();

        stage.addActor(table);
        stage.setDebugAll(true);
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
        stage = null;
        skin = null;
    }

    @Override
    public void dispose() {
    }

    @Override
    public Screens getName() {
        return Screens.GAME;
    }
}
