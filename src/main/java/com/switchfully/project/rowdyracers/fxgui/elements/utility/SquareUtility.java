package com.switchfully.project.rowdyracers.fxgui.elements.utility;

import static com.switchfully.project.rowdyracers.RowdyRacersFxApplication.SPACING_SIZE;
import static com.switchfully.project.rowdyracers.domain.Square.WIDTH_HEIGHT_IN_PX;

public class SquareUtility {

    public static int fromRowIndexToYCoordinate(int rowIndex) {
        return rowIndex * WIDTH_HEIGHT_IN_PX + SPACING_SIZE * rowIndex;
    }

    public static int fromColumnIndexToXCoordinate(int columnIndex) {
        return columnIndex * WIDTH_HEIGHT_IN_PX + SPACING_SIZE * columnIndex;
    }

    public static int fromRowIndexToYCoordinateMiddleOfSquare(int rowIndex) {
        return fromRowIndexToYCoordinate(rowIndex) + WIDTH_HEIGHT_IN_PX/2;
    }

    public static int fromColumnIndexToXCoordinateMiddleOfSquare(int columnIndex) {
        return fromColumnIndexToXCoordinate(columnIndex) + WIDTH_HEIGHT_IN_PX/2;
    }

}
