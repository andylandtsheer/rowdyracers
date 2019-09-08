package com.switchfully.project.rowdyracers.views;

import static com.switchfully.project.rowdyracers.RowdyRacersWindow.CANVAS_PANEL_HEIGHT;
import static com.switchfully.project.rowdyracers.RowdyRacersWindow.CANVAS_PANEL_WIDTH;
import static com.switchfully.project.rowdyracers.views.GridController.*;
import static com.switchfully.project.rowdyracers.views.GridController.SPACING_SIZE;

public class SquarePositionHelper {

    public static int getSquareHeight() {
        return (CANVAS_PANEL_HEIGHT - SPACING_SIZE * AMOUNT_OF_GRID_ROWS) / AMOUNT_OF_GRID_ROWS;
    }

    public static int getSquareWidth() {
        return (CANVAS_PANEL_WIDTH - SPACING_SIZE * AMOUNT_OF_GRID_COLUMNS) / AMOUNT_OF_GRID_COLUMNS;
    }

    public static int fromRowToYCoordinate(int row) {
        return row * getSquareHeight() + SPACING_SIZE * row;
    }

    public static int fromColumnToXCoordinate(int column) {
        return column * getSquareWidth() + SPACING_SIZE * column;
    }

}
