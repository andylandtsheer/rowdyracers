package com.switchfully.project.rowdyracers.views;

import com.switchfully.project.rowdyracers.GameCanvas;
import com.switchfully.project.rowdyracers.GameControls;

public abstract class View {

    private final GameCanvas gameCanvas;
    private final GameControls gameControls;

    public View(GameCanvas gameCanvas, GameControls gameControls) {
        this.gameCanvas = gameCanvas;
        this.gameControls = gameControls;
    }

    protected GameCanvas getGameCanvas() {
        return gameCanvas;
    }

    protected GameControls getGameControls() {
        return gameControls;
    }
}
