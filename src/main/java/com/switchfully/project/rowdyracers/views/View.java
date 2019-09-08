package com.switchfully.project.rowdyracers.views;

import com.switchfully.project.rowdyracers.GameCanvas;

public abstract class View {

    private final GameCanvas gameCanvas;

    public View(GameCanvas gameCanvas) {
        this.gameCanvas = gameCanvas;
    }

    protected GameCanvas getGameCanvas() {
        return gameCanvas;
    }

    public void repaint() {
        gameCanvas.repaint();
    }
}
