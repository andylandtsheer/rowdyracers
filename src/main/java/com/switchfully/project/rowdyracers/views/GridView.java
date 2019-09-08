package com.switchfully.project.rowdyracers.views;

import com.switchfully.project.rowdyracers.GameCanvas;
import com.switchfully.project.rowdyracers.GameControls;
import com.switchfully.project.rowdyracers.RowdyRacersWindow;
import com.switchfully.project.rowdyracers.domain.*;
import com.switchfully.project.rowdyracers.views.graphicelements.PlayerGE;
import com.switchfully.project.rowdyracers.views.graphicelements.SquareGE;

public class GridView extends View {

    public GridView(GameCanvas gameCanvas, GameControls gameControls) {
        super(gameCanvas, gameControls);
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
