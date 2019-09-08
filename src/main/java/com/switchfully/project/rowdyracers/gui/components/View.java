package com.switchfully.project.rowdyracers.gui.components;

import com.switchfully.project.rowdyracers.gui.window.GameCanvas;

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
