package com.switchfully.project.rowdyracers.fxgui;

import com.switchfully.project.rowdyracers.domain.Game;

public class GameController {

    private GameView gameView;
    private Game gameModel;

    public GameController(Game gameModel, GameView gameView) {
        this.gameView = gameView;
        this.gameModel = gameModel;
        setEventHandlersForButtons();
    }

    public void start() {
        this.gameModel.start();
        this.gameView.redraw();
    }

    private void setEventHandlersForButtons() {
        gameView.setActionListenerForButtonWithDirection(
                (event) -> {
                    gameModel.moveToSouth();
                    gameView.redraw();
                }, Direction.SOUTH);
        gameView.setActionListenerForButtonWithDirection(
                (event) -> {
                    gameModel.moveToEast();
                    gameView.redraw();
                }, Direction.EAST);
    }

}
