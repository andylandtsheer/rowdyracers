package com.switchfully.project.rowdyracers.fxgui;

import com.switchfully.project.rowdyracers.domain.Game;
import com.switchfully.project.rowdyracers.fxgui.elements.Drawable;
import com.switchfully.project.rowdyracers.fxgui.elements.GridGE;
import com.switchfully.project.rowdyracers.fxgui.elements.PlayerGE;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private GameView gameView;
    private Game gameModel;

    public GameController(Game game) {
        GridGE gridGE = new GridGE(game.getGrid());

        ArrayList<Drawable> drawablesToPaint = new ArrayList<>();
        addDrawables(gridGE.getSquares(), drawablesToPaint);
        addDrawable(new PlayerGE(game.getPlayerRed()), drawablesToPaint);
        addDrawable(new PlayerGE(game.getPlayerBlue()), drawablesToPaint);

        this.gameView = new GameView(drawablesToPaint.toArray(Drawable[]::new));
        this.gameModel = game;

        setEventHandlersForButtons();


    }

    public GameView getGameView() {
        return gameView;
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

    private void addDrawable(Drawable drawable, List<Drawable> drawablesToPaint) {
        drawablesToPaint.add(drawable);
    }

    private void addDrawables(Drawable[][] drawables, List<Drawable> drawablesToPaint) {
        for (Drawable[] drawableRow: drawables) {
            for(Drawable drawable: drawableRow) {
                addDrawable(drawable, drawablesToPaint);
            }
        }
    }
}
