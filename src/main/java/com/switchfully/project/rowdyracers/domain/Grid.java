package com.switchfully.project.rowdyracers.domain;

import static com.switchfully.project.rowdyracers.domain.Square.WIDTH_HEIGHT_IN_PX;

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
                                new Size(WIDTH_HEIGHT_IN_PX, WIDTH_HEIGHT_IN_PX),
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
