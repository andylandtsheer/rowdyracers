package com.switchfully.project.rowdyracers.gui.elements;

import com.switchfully.project.rowdyracers.domain.Grid;
import com.switchfully.project.rowdyracers.domain.Square;

import java.awt.*;

public class GridGE extends GraphicElement {

    private final Grid grid;

    public GridGE(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void paint(Graphics g) {
        // Grid itself has nothing to draw (for now)
        // The individual squares are drawn by the SquareGE class.
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
}
