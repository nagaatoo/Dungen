package ru.numbdev.dungen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

import ru.numbdev.dungen.enums.Screens;
import ru.numbdev.dungen.screen.DungeonScreen;
import ru.numbdev.dungen.screen.MainGameScreen;
import ru.numbdev.dungen.screen.MenuScreen;

public class Dungen extends Game {

    public SpriteBatch batch;

    private final List<DungeonScreen> screens = new ArrayList<>();

    public void create() {
        batch = new SpriteBatch();
        screens.add(new MenuScreen(this));
        screens.add(new MainGameScreen(this));

        activeScreen(Screens.MAIN_MENU);
    }

    public void render() {
        super.render(); // important!
    }

    public void dispose() {
        batch.dispose();
//        font.dispose();
    }

    public void activeScreen(Screens name) {
        for (DungeonScreen screen : screens) {
            if (screen.getName() == name) {
                setScreen(screen);
            }
        }
    }
}
