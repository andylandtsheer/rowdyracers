package com.switchfully.project.rowdyracers.gui.components.grid;

import com.switchfully.project.rowdyracers.domain.Game;
import com.switchfully.project.rowdyracers.gui.components.grid.player.PlayerGE;
import com.switchfully.project.rowdyracers.gui.window.GameCanvas;
import com.switchfully.project.rowdyracers.gui.window.GameControls;

public class GameController {

    public static final int AMOUNT_OF_GRID_ROWS = 10;
    public static final int AMOUNT_OF_GRID_COLUMNS = 10;
    public  static final int SPACING_SIZE = 5;

    private final GameCanvas gameCanvas;
    private final GameControls gameControls;

    private final GridGE gridGE;
    private final PlayerGE playerGEBlue;
    private final PlayerGE playerGERed;

    private final Game game;

    public GameController(GameCanvas gameCanvas, GameControls gameControls, Game game) {
        this.gameCanvas = gameCanvas;
        this.gameControls = gameControls;
        this.game = game;

        gridGE = new GridGE(game.getGrid());
        playerGERed = new PlayerGE(game.getPlayerRed());
        playerGEBlue = new PlayerGE(game.getPlayerBlue());

        addComponentsToTheCanvas();
        makePlayerRedMoveable();
    }

    public void start() {
        this.game.start();
    }

    private void addComponentsToTheCanvas() {
        this.gameCanvas.addComponents(gridGE.getSquares());
        this.gameCanvas.addComponent(playerGERed);
        this.gameCanvas.addComponent(playerGEBlue);
    }

    private void makePlayerRedMoveable() {
        gameControls.setActionListenerForButtonDirection((event) -> {
            game.moveToSouth();
            gameCanvas.repaint();
        }, GameControls.Direction.SOUTH);
    }

}
