package com.switchfully.project.rowdyracers.fxgui.elements;

import com.switchfully.project.rowdyracers.domain.Grid;
import com.switchfully.project.rowdyracers.domain.Square;
import javafx.scene.canvas.GraphicsContext;

public class GridGE implements Drawable {

    private final Grid grid;

    public GridGE(Grid grid) {
        this.grid = grid;
    }

    public SquareGE[][] getSquares() {
        SquareGE[][] squares = new SquareGE[grid.getAmountOfRows()][grid.getAmountOfColumns()];
        Square[][] gridSquares = grid.getSquares();
        for (int row = 0; row < gridSquares.length; row++) {
            for (int column = 0; column < gridSquares[row].length; column++) {
                squares[row][column] = new SquareGE(gridSquares[row][column]);
            }
        }
        return squares;
    }

    @Override
    public void paint(GraphicsContext context) {
        // Nothing to paint...
    }
}
