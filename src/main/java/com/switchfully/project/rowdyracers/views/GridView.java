package com.switchfully.project.rowdyracers.views;

import com.switchfully.project.rowdyracers.GameCanvas;
import com.switchfully.project.rowdyracers.GameFrame;
import com.switchfully.project.rowdyracers.views.graphicelements.Coordinates;
import com.switchfully.project.rowdyracers.views.graphicelements.SquareGE;

import java.awt.*;

public class GridView extends View {

    private static final int AMOUNT_OF_GRID_ROWS = 10;
    private static final int AMOUNT_OF_GRID_COLUMNS = 10;
    private static final int SPACING_SIZE = 5;

    public GridView(GameCanvas canvas) {
        super(canvas);
        createSquareShapes();
    }

    private void createSquareShapes() {
        for (int row = 0; row < AMOUNT_OF_GRID_ROWS; row++) {
            for (int column = 0; column < AMOUNT_OF_GRID_COLUMNS; column++) {
                SquareGE square = new SquareGE(
                        new Coordinates(
                                column * getSquareWidth() + SPACING_SIZE * column,
                                row * getSquareHeight() + SPACING_SIZE * row),
                        new Dimension(getSquareWidth(), getSquareHeight()));
                getCanvas().addComponent(square);
            }
        }
    }

    private int getSquareHeight() {
        return (GameFrame.CANVAS_PANEL_HEIGHT - SPACING_SIZE * AMOUNT_OF_GRID_ROWS) / AMOUNT_OF_GRID_ROWS;
    }

    private int getSquareWidth() {
        return (GameFrame.CANVAS_PANEL_WIDTH - SPACING_SIZE * AMOUNT_OF_GRID_COLUMNS) / AMOUNT_OF_GRID_COLUMNS;
    }


}
