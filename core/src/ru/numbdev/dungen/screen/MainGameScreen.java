package ru.numbdev.dungen.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.numbdev.dungen.Dungen;
import ru.numbdev.dungen.element.ViewCamera;
import ru.numbdev.dungen.enums.Screens;
import ru.numbdev.dungen.input.GameInputEngine;
import ru.numbdev.dungen.item.Player;

public class MainGameScreen implements DungeonScreen {

    private final Dungen game;

    private GameInputEngine inputEngine;

    private final Player player;

    private Stage stage;
    private Skin skin;

    public MainGameScreen(Dungen game) {
        this.game = game;
        player = new Player();
//        inputEngine = new GameInputEngine(player);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

        game.batch.begin();
        player.draw(game.batch, 0);
        game.batch.end();
    }

    @Override
    public void show() {
        Viewport viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new ViewCamera());
        stage = new Stage(viewport);

        Gdx.input.setInputProcessor(stage);
//        skin = new Skin(Gdx.files.internal("badlogic.jpg"));

//        buildMenu();
    }

    private void buildMenu(){
        Table menuTable = new Table(skin);
        menuTable.setPosition(0, 0);
        menuTable.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        menuTable.align(Align.top);

        stage.addActor(menuTable);

        Texture texture = new Texture(Gdx.files.internal("data/ubuntulogo.png"));
        Image image = new Image(texture);

        //first option
        image.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //your action on click
            }
        });
        menuTable.add(image);

        //second option
        ImageButton imageButton = new ImageButton(image.getDrawable());
        imageButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //your action on click
            }
        });
        menuTable.add(imageButton);

        //third option
        Button button = new Button(skin);
        button.add(image);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //your action on click
            }
        });
        menuTable.add(button);

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
