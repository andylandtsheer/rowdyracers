package com.switchfully.project.rowdyracers.domain;

public class Game {

    private final Grid grid;
    private final Player playerRed;
    private final Player playerBlue;

    private Player currentPlayer;

    public Game(Grid grid, Player playerRed, Player playerBlue) {
        this.grid = grid;
        this.playerRed = playerRed;
        this.playerBlue = playerBlue;
        this.currentPlayer = playerRed;
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

    private void changeCurrentPlayer() {
        if (currentPlayer == playerRed) {
            currentPlayer = playerBlue;
        } else        {
            currentPlayer = playerRed;
        }
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
                currentPlayer.getGridPosition().getRowIndex()-1,
                currentPlayer.getGridPosition().getColumnIndex() - 1));
        changeCurrentPlayer();
    }

    public void moveToSouthWest() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex()+1,
                currentPlayer.getGridPosition().getColumnIndex() - 1));
        changeCurrentPlayer();
    }

    public void moveToNorthEast() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex()-1,
                currentPlayer.getGridPosition().getColumnIndex() + 1));
        changeCurrentPlayer();
    }

    public void moveToSouthEast() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex()+1,
                currentPlayer.getGridPosition().getColumnIndex() + 1));
        changeCurrentPlayer();
    }

    private void moveTo(GridPosition gridPositionToMoveTo) {
        Square newSquare = grid.getSquareFor(gridPositionToMoveTo);
        if (newSquare != null) {
            currentPlayer.moveTo(newSquare);
        }
    }

    private void placePlayersAtStartingPositions() {
        this.playerRed.moveTo(grid.getSquareFor(new GridPosition(0, 0)));
        this.playerBlue.moveTo(grid.getSquareFor(new GridPosition(grid.getAmountOfRows() - 1, grid.getAmountOfColumns() - 1)));
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
}
