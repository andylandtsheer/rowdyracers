package com.switchfully.project.rowdyracers.domain;

public enum FillColor {

    GREY(0.5019608f, 0.5019608f, 0.5019608f),
    BLACK(0, 0, 0),
    YELLOW(1f, 1f, 0);

    private final float red;
    private final float green;
    private final float blue;

    FillColor(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }
}

