package ru.numbdev.dungen.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

import ru.numbdev.dungen.system.Pair;

public class Player extends Actor {

    private static final Texture img = new Texture("badlogic.jpg");
    private final Sprite sprite;
    private boolean isSelected = false;

    public Player() {
        super();
        this.sprite = new Sprite(img);
        this.setTouchable(Touchable.enabled);
        this.setBounds(this.sprite.getX(), this.sprite.getY(), this.sprite.getWidth(), this.sprite.getHeight());
        this.setOrigin(this.sprite.getWidth() / 2, this.sprite.getHeight() / 2);
        this.setScale(0.25f);
        this.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int pointer, int button) {
                ((Player) event.getTarget()).toggleSelect();
            }
        });
    }

    @Override
    public void draw(Batch batch, float alpha) {
        sprite.draw(batch);
    }

    @Override
    public void positionChanged() {
        sprite.setPosition(getX(), getY());
    }

    public void toggleSelect() {
        this.isSelected = !this.isSelected;
        if (this.isSelected)
            sprite.setColor(0.5f, 0f, 0.5f, 1f);
        else
            sprite.setColor(0f, 0f, 0f, 0f);
    }

    public float getCenterX() {
        return getX() + (getWidth() /2f);
    }

    public float getCenterY() {
        return getY() + (getHeight() /2f);
    }

    public void movePlayer(Pair direction) {
        moveBy(direction.getX(), direction.getY());
    }
}
