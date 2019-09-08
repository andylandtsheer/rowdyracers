package com.switchfully.project.rowdyracers.views;

import com.switchfully.project.rowdyracers.RowdyRacersWindow;
import com.switchfully.project.rowdyracers.domain.*;
import com.switchfully.project.rowdyracers.views.graphicelements.PlayerGE;
import com.switchfully.project.rowdyracers.views.graphicelements.SquareGE;

public class GridController {

    private static final int AMOUNT_OF_GRID_ROWS = 10;
    private static final int AMOUNT_OF_GRID_COLUMNS = 10;
    private static final int SPACING_SIZE = 5;

    private final GridView gridView;

    private final SquareGE[][] gridGE;
    private final PlayerGE playerGEBlue;
    private final PlayerGE playerGERed;

    public GridController(GridView gridView) {
        this.gridView = gridView;
        this.gridGE = createGrid();
        this.playerGERed = createPlayer(0, 0, "player-red");
        this.playerGEBlue = createPlayer(AMOUNT_OF_GRID_ROWS - 1, AMOUNT_OF_GRID_COLUMNS - 1, "player-blue");
        this.gridView.addToCanvas(gridGE);
        this.gridView.addToCanvas(playerGERed);
        this.gridView.addToCanvas(playerGEBlue);
    }

    private SquareGE[][] createGrid() {
        SquareGE[][] grid = new SquareGE[AMOUNT_OF_GRID_ROWS][AMOUNT_OF_GRID_COLUMNS];
        for (int row = 0; row < AMOUNT_OF_GRID_ROWS; row++) {
            for (int column = 0; column < AMOUNT_OF_GRID_COLUMNS; column++) {
                grid[row][column] = new SquareGE(
                        new Square(
                                new Coordinates(
                                        fromColumnToXCoordinate(column),
                                        fromRowToYCoordinate(row)),
                                new Size(getSquareWidth(), getSquareHeight()),
                                FillColor.GREY));
            }
        }
        return grid;
    }

    private PlayerGE createPlayer(int gridRow, int gridColumn, String playerImgNameWithoutExtensions) {
        return new PlayerGE(
                new Player(
                        new Coordinates(
                                fromColumnToXCoordinate(gridRow),
                                fromRowToYCoordinate(gridColumn)),
                        new Size(getSquareWidth(), getSquareHeight()),
                        playerImgNameWithoutExtensions
                ));
    }

    private static int fromRowToYCoordinate(int row) {
        return row * getSquareHeight() + SPACING_SIZE * row;
    }

    private static int fromColumnToXCoordinate(int column) {
        return column * getSquareWidth() + SPACING_SIZE * column;
    }

    private static int getSquareHeight() {
        return (RowdyRacersWindow.CANVAS_PANEL_HEIGHT - SPACING_SIZE * AMOUNT_OF_GRID_ROWS) / AMOUNT_OF_GRID_ROWS;
    }

    private static int getSquareWidth() {
        return (RowdyRacersWindow.CANVAS_PANEL_WIDTH - SPACING_SIZE * AMOUNT_OF_GRID_COLUMNS) / AMOUNT_OF_GRID_COLUMNS;
    }
}
