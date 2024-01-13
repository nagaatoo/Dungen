package ru.numbdev.dungen.element;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerDescription {

    private final Image avatar;
    private final int maxHp;
    private final int maxMp;
    private final int maxStamina;
    private final List<Buff> buffs;

    private PlayerDescription(
            Image avatar,
            int maxHp,
            int maxMp,
            int maxStamina,
            List<Buff> buffs
    ) {

        this.avatar = avatar;
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.maxStamina = maxStamina;
        this.buffs = buffs;
    }

    public Image getAvatar() {
        return avatar;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public List<Buff> getBuffs() {
        return buffs;
    }

    public static class PlayerDescriptionBuilder {
        public static PlayerDescription initPlayer(String description) {
            Json json = new Json();
            Map<String, Object> player = json.fromJson(Map.class, description);

            return new PlayerDescription(
                    getImage((String) player.get("avatar")),
                    Integer.parseInt((String) player.get("hp")),
                    Integer.parseInt((String) player.get("mp")),
                    Integer.parseInt((String) player.get("stamina")),
                    parseBuff(null)
            );
        }

        private static Image getImage(String name) {
            return new Image(new Texture(Gdx.files.internal(name)));
        }

        private static List<Buff> parseBuff(Object buffsJson) {
            return new ArrayList<>();
        }

    }
}
