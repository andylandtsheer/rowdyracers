package com.switchfully.project.rowdyracers.gui;

import com.switchfully.project.rowdyracers.domain.Game;
import com.switchfully.project.rowdyracers.gui.elements.GridGE;
import com.switchfully.project.rowdyracers.gui.elements.PlayerGE;
import com.switchfully.project.rowdyracers.gui.windowpanels.GameCanvas;
import com.switchfully.project.rowdyracers.gui.windowpanels.GameControls;

public class GameController {

    private final GameCanvas gameCanvas;
    private final GameControls gameControls;

    private final Game game;

    public GameController(GameCanvas gameCanvas, GameControls gameControls, Game game) {
        this.gameCanvas = gameCanvas;
        this.gameControls = gameControls;
        this.game = game;

        addComponentsToTheCanvas();
        setActionListenersForButtons();
    }

    public void start() {
        this.game.start();
    }

    private void addComponentsToTheCanvas() {
        GridGE gridGE = new GridGE(game.getGrid());
        this.gameCanvas.addComponents(gridGE.getSquares());
        this.gameCanvas.addComponent(new PlayerGE(game.getPlayerRed()));
        this.gameCanvas.addComponent(new PlayerGE(game.getPlayerBlue()));
    }

    private void setActionListenersForButtons() {
        gameControls.setActionListenerForButtonWithDirection(
                (event) -> {
                    game.moveToSouth();
                    gameCanvas.repaint();
                }, GameControls.Direction.SOUTH);
        gameControls.setActionListenerForButtonWithDirection(
                (event) -> {
                    game.moveToEast();
                    gameCanvas.repaint();
                }, GameControls.Direction.EAST);
    }

}
