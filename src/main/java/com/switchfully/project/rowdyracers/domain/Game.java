package com.switchfully.project.rowdyracers.domain;

import com.switchfully.project.rowdyracers.domain.boardgenerator.WallGenerator;
import com.switchfully.project.rowdyracers.domain.impassable.Wall;

import java.util.List;
import java.util.Random;

public class Game {
    private final Random random = new Random();
    private final Grid grid;
    private final Player playerRed;
    private final Player playerBlue;
    private final List<Wall> walls;

    private Player currentPlayer;

    public Game(Grid grid, Player playerRed, Player playerBlue) {
        this.grid = grid;
        this.playerRed = playerRed;
        this.playerBlue = playerBlue;
        this.currentPlayer = playerRed;
        this.walls = WallGenerator.generateWalls(random, grid);
    }

    public void start() {
        placePlayersAtStartingPositions();
    }


    public void moveToSouth() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex() + 1,
                currentPlayer.getGridPosition().getColumnIndex()));
        changeCurrentPlayer();
    }

    public void moveToEast() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex(),
                currentPlayer.getGridPosition().getColumnIndex() + 1));
        changeCurrentPlayer();
    }

    public void moveToNorth() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex() - 1,
                currentPlayer.getGridPosition().getColumnIndex()));
        changeCurrentPlayer();
    }

    public void moveToWest() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex(),
                currentPlayer.getGridPosition().getColumnIndex() - 1));
        changeCurrentPlayer();
    }

    public void moveToNorthWest() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex() - 1,
                currentPlayer.getGridPosition().getColumnIndex() - 1));
        changeCurrentPlayer();
    }

    public void moveToSouthWest() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex() + 1,
                currentPlayer.getGridPosition().getColumnIndex() - 1));
        changeCurrentPlayer();
    }

    public void moveToNorthEast() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex() - 1,
                currentPlayer.getGridPosition().getColumnIndex() + 1));
        changeCurrentPlayer();
    }

    public void moveToSouthEast() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex() + 1,
                currentPlayer.getGridPosition().getColumnIndex() + 1));
        changeCurrentPlayer();
    }

    private void changeCurrentPlayer() {
        if (currentPlayer == playerRed) {
            currentPlayer = playerBlue;
        } else {
            currentPlayer = playerRed;
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public Player getPlayerRed() {
        return playerRed;
    }

    public Player getPlayerBlue() {
        return playerBlue;
    }

    private boolean newPositionIsAvailable(Square newSquare) {
        return newSquare != null;
    }

    private boolean moveTo(GridPosition gridPositionToMoveTo) {
        Square newSquare = grid.getSquareFor(gridPositionToMoveTo);
        if (newPositionIsAvailable(newSquare)) {
            currentPlayer.moveTo(newSquare);
            return true;
        }
        return false;
    }

    private void placePlayersAtStartingPositions() {
        this.playerRed.moveTo(grid.getSquareFor(new GridPosition(0, 0)));
        this.playerBlue.moveTo(grid.getSquareFor(new GridPosition(grid.getAmountOfRows() - 1, grid.getAmountOfColumns() - 1)));
    }

    public List<Wall> getWalls() {
        return walls;
    }
}
