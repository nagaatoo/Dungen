package ru.numbdev.dungen.context;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;

import java.util.List;

import ru.numbdev.dungen.element.Buff;
import ru.numbdev.dungen.element.Effect;
import ru.numbdev.dungen.element.PlayerDescription;
import ru.numbdev.dungen.element.Skill;

public class PlayerContextHolder {

    private static PlayerDescription description;

    public static void setDescription(PlayerDescription description) {
        PlayerContextHolder.description = description;
    }

    public static List<Skill> getSkills() {
        return null;
    }

    public static  Image getAvatar() {
        return null;
    }

    public static  PlayerContextHolder setStats(int hp, int mp, int stamina, List<Effect> effects) {
        return null;
    }

    public static  int getHp() {
        return 0;
    }

    public static  int getMp() {
        return 0;
    }

    public static int getStamina() {
        return 0;
    }

    public static List<Effect> getEffects() {
        return null;
    }

    public static List<Buff> getBuffs() {
        return null;
    }
}
