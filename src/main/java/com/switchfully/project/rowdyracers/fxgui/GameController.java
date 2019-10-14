package com.switchfully.project.rowdyracers.fxgui;

import com.switchfully.project.rowdyracers.domain.Game;

public class GameController {

    private final GameView gameView;
    private final Game gameModel;

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
        gameView.setActionListenerForButtonWithDirection(
                (event) -> {
                    gameModel.moveToNorth();
                    gameView.redraw();
                }, Direction.NORTH);
        gameView.setActionListenerForButtonWithDirection(
                (event) -> {
                    gameModel.moveToWest();
                    gameView.redraw();
                }, Direction.WEST);
        gameView.setActionListenerForButtonWithDirection(
                (event) -> {
                    gameModel.moveToNorthWest();
                    gameView.redraw();
                }, Direction.NORTH_WEST);
        gameView.setActionListenerForButtonWithDirection(
                (event) -> {
                    gameModel.moveToNorthEast();
                    gameView.redraw();
                }, Direction.NORTH_EAST);
        gameView.setActionListenerForButtonWithDirection(
                (event) -> {
                    gameModel.moveToSouthWest();
                    gameView.redraw();
                }, Direction.SOUTH_WEST);
        gameView.setActionListenerForButtonWithDirection(
                (event) -> {
                    gameModel.moveToSouthEast();
                    gameView.redraw();
                }, Direction.SOUTH_EAST);
    }
}
