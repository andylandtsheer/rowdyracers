package com.switchfully.project.rowdyracers.domain;

import static com.switchfully.project.rowdyracers.gui.components.SquarePositionHelper.getSquareHeight;
import static com.switchfully.project.rowdyracers.gui.components.SquarePositionHelper.getSquareWidth;

public class Grid {

    private final int rows;
    private final int columns;

    private Square[][] squares;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.squares = createSquaresForGrid();
    }

    public Square getSquareFor(GridPosition gridPosition) {
        if(gridPosition.isOutOfBoundsOfGrid(rows, columns)) {
            return null;
        }
        return squares[gridPosition.getRowIndex()][gridPosition.getColumnIndex()];
    }

    private Square[][] createSquaresForGrid() {
        Square[][] squares = new Square[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                squares[row][column] =
                        new Square(
                                new GridPosition(row, column),
                                new Size(getSquareWidth(), getSquareHeight()),
                                FillColor.GREY);
            }
        }
        return squares;
    }


    public int getAmountOfRows() {
        return rows;
    }

    public int getAmountOfColumns() {
        return columns;
    }

    public Square[][] getSquares() {
        return squares;
    }
}
