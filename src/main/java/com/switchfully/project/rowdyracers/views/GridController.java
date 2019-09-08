package com.switchfully.project.rowdyracers.views;

import com.switchfully.project.rowdyracers.GameControls;
import com.switchfully.project.rowdyracers.domain.*;
import com.switchfully.project.rowdyracers.views.graphicelements.PlayerGE;
import com.switchfully.project.rowdyracers.views.graphicelements.SquareGE;

import static com.switchfully.project.rowdyracers.views.SquarePositionHelper.getSquareHeight;
import static com.switchfully.project.rowdyracers.views.SquarePositionHelper.getSquareWidth;

public class GridController {

    static final int AMOUNT_OF_GRID_ROWS = 10;
    static final int AMOUNT_OF_GRID_COLUMNS = 10;
    static final int SPACING_SIZE = 5;

    private final GridView gridView;
    private final GameControls gameControls;

    private final SquareGE[][] gridGE;
    private final PlayerGE playerGEBlue;
    private final PlayerGE playerGERed;

    public GridController(GridView gridView, GameControls gameControls) {
        this.gridView = gridView;
        this.gameControls = gameControls;

        this.gridGE = createGrid();
        this.playerGERed = createPlayer(0, 0, "player-red");
        this.playerGEBlue = createPlayer(AMOUNT_OF_GRID_ROWS - 1, AMOUNT_OF_GRID_COLUMNS - 1, "player-blue");

        addComponentsToTheView();
        makePlayerRedMoveable();
    }

    private void addComponentsToTheView() {
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
                                new GridPosition(row, column),
                                new Size(getSquareWidth(), getSquareHeight()),
                                FillColor.GREY));
            }
        }
        return grid;
    }

    private PlayerGE createPlayer(int gridRow, int gridColumn, String playerImgNameWithoutExtensions) {
        return new PlayerGE(
                new Player(
                        gridGE[gridRow][gridColumn].getSquare(),
                        new Size(getSquareWidth(), getSquareHeight()),
                        playerImgNameWithoutExtensions
                ));
    }

    private void makePlayerRedMoveable() {
        gameControls.setActionListenerForButtonDirection((event) -> {
            GridPosition newGridPosition = playerGERed.getPositionOfSouthSquare(AMOUNT_OF_GRID_ROWS - 1);
            playerGERed.placeOnSquare(gridGE[newGridPosition.getRow()][newGridPosition.getColumn()]);
            gridView.repaint();
        }, GameControls.Direction.SOUTH);
    }

}
