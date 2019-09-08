package com.switchfully.project.rowdyracers.views;

import com.switchfully.project.rowdyracers.GameCanvas;

public abstract class View {

    private GameCanvas canvas;

    public View(GameCanvas canvas) {
        this.canvas = canvas;
    }

    protected GameCanvas getCanvas() {
        return canvas;
    }

}
