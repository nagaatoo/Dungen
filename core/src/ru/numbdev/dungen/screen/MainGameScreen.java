package ru.numbdev.dungen.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

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

    private Stage stage;
    private Skin skin;

    public MainGameScreen(Dungen game) {
        this.game = game;
//        player = new Player();
//        inputEngine = new GameInputEngine(player);
//
//        Player test = new Player();
//        test.setPosition(300, 300);
//        actorElements.add(test);
//        actorElements.add(player);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        game.batch.begin();

//        for(Actor actor : actorElements) {
//            actor.draw(game.batch, 0);
//        }
//        for (Sprite element : gameplayElements) {
//            element.draw(game.batch);
//        }
//        for (Sprite element : controlElements) {
//            element.draw(game.batch);
//        }
//        game.batch.end();
    }

    @Override
    public void show() {
        stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);

        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("data/skins/skin.json"));

        buildMenu();
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
