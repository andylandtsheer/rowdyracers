package com.switchfully.project.rowdyracers.fxgui.elements.utility;

import static com.switchfully.project.rowdyracers.RowdyRacersFxApplication.*;
import static com.switchfully.project.rowdyracers.fxgui.GameView.CANVAS_PANEL_HEIGHT;
import static com.switchfully.project.rowdyracers.fxgui.GameView.CANVAS_PANEL_WIDTH;

public class SquareUtility {

    public static int getSquareHeight() {
        return (CANVAS_PANEL_HEIGHT - SPACING_SIZE * AMOUNT_OF_GRID_ROWS) / AMOUNT_OF_GRID_ROWS;
    }

    public static int getSquareWidth() {
        return (CANVAS_PANEL_WIDTH - SPACING_SIZE * AMOUNT_OF_GRID_COLUMNS) / AMOUNT_OF_GRID_COLUMNS;
    }

    public static int fromRowIndexToYCoordinate(int rowIndex) {
        return rowIndex * getSquareHeight() + SPACING_SIZE * rowIndex;
    }

    public static int fromColumnIndexToXCoordinate(int columnIndex) {
        return columnIndex * getSquareWidth() + SPACING_SIZE * columnIndex;
    }

}
