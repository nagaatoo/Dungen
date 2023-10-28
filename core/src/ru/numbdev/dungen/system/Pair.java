package ru.numbdev.dungen.system;

public class Pair {

    private float x;
    private float y;

    private Pair(float first, float second) {
        this.x = first;
        this.y = second;
    }

    public static Pair of(float first, float second) {
        return new Pair(first, second);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
