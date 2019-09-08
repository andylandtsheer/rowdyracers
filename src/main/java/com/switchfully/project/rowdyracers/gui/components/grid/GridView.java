package com.switchfully.project.rowdyracers.gui.components.grid;

import com.switchfully.project.rowdyracers.gui.components.View;
import com.switchfully.project.rowdyracers.gui.components.grid.player.PlayerGE;
import com.switchfully.project.rowdyracers.gui.components.grid.square.SquareGE;
import com.switchfully.project.rowdyracers.gui.window.GameCanvas;

public class GridView extends View {

    public GridView(GameCanvas gameCanvas) {
        super(gameCanvas);
    }

    public void addToCanvas(PlayerGE playerGE) {
        getGameCanvas().addComponent(playerGE);
    }

    public void addToCanvas(SquareGE[][] gridGE) {
        for (SquareGE[] gridRow: gridGE) {
            for (SquareGE squareGE: gridRow) {
                getGameCanvas().addComponent(squareGE);
            }
        }
    }
}
