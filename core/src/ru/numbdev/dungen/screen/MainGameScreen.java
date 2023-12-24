package ru.numbdev.dungen.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.numbdev.dungen.Dungen;
import ru.numbdev.dungen.element.ViewCamera;
import ru.numbdev.dungen.enums.Screens;
import ru.numbdev.dungen.input.GameInputEngine;
import ru.numbdev.dungen.item.Avatar;
import ru.numbdev.dungen.item.ButtonBar;
import ru.numbdev.dungen.item.Enemy;
import ru.numbdev.dungen.item.Player;
import ru.numbdev.dungen.item.Steps;

public class MainGameScreen implements DungeonScreen {

    private final Dungen game;

    private GameInputEngine inputEngine;

    private final Player player;

    private Stage stage;
    private Skin skin;
    private BitmapFont defaultFont = new BitmapFont(Gdx.files.internal("bitmapfont/Amble-Regular-26.fnt"));

    public MainGameScreen(Dungen game) {
        this.game = game;
        player = new Player();
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
        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();
        float cWidth = width * 0.7f;
        float cHeight = height * 0.5f;

        Container<Table> container = new Container<>();
        container.setName("container");
        container.setSize(cWidth, cHeight);
        container.setPosition((width - cWidth) / 2.0f, (height - cHeight) / 2.0f);
        container.fillX();
        container.fillY();

        Table table = new Table(skin);
        table.setFillParent(true);
        table.setDebug(true);

        table.row().colspan(3).expandX().fillX();
        table.add(new Player()).fillX();
        table.add(new Steps()).fillX();
        table.add(new Enemy()).fillX();
        table.row().center();
        table.pack();

//        Table buttonTable = new Table();
//        buttonTable.pad(16).row().fillX().expandX();
//        buttonTable.add(new ButtonBar());
//        table.add(buttonTable);

//        Label.LabelStyle labelStyle = new Label.LabelStyle(defaultFont, Color.WHITE);
//        Label topLabel = new Label("A LABEL", labelStyle);
//        topLabel.setAlignment(Align.center);
//        Slider slider = new Slider(0, 100, 1, false, skin);
//        Label anotherLabel = new Label("ANOTHER LABEL", skin);
//        anotherLabel.setAlignment(Align.center);
//
//        CheckBox checkBoxA = new CheckBox("Checkbox Left", skin);
//        CheckBox checkBoxB = new CheckBox("Checkbox Center", skin);
//        CheckBox checkBoxC = new CheckBox("Checkbox Right", skin);
//
//        Table buttonTable = new Table(skin);
//
//        TextButton buttonA = new TextButton("LEFT", skin);
//        TextButton buttonB = new TextButton("RIGHT", skin);
//
//        table.row().colspan(3).expandX().fillX();
//        table.add(topLabel).fillX();
//        table.row().colspan(3).expandX().fillX();
//        table.add(slider).fillX();
//        table.row().colspan(3).expandX().fillX();
//        table.add(anotherLabel).fillX();
//        table.row().expandX().fillX();
//
//        table.add(checkBoxA).expandX().fillX();
//        table.add(checkBoxB).expandX().fillX();
//        table.add(checkBoxC).expandX().fillX();
//        table.row().expandX().fillX();
//
//        table.add(buttonTable).colspan(3);
//
//        buttonTable.pad(16);
//        buttonTable.row().fillX().expandX();
//        buttonTable.add(buttonA).width(cWidth/3.0f);
//        buttonTable.add(buttonB).width(cWidth/3.0f);

//        container.setActor(table);
//        stage.addActor(container);
        stage.addActor(table);
//        stage.setDebugAll(true);
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
