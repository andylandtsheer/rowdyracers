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
    private static int turnCounter = 1;

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

        checkTurn();
    }

    public void moveToEast() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex(),
                currentPlayer.getGridPosition().getColumnIndex() + 1));
        checkTurn();
    }

    public void moveToNorth() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex() - 1,
                currentPlayer.getGridPosition().getColumnIndex()));
        checkTurn();
    }

    public void moveToWest() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex(),
                currentPlayer.getGridPosition().getColumnIndex() - 1));
        checkTurn();
    }

    public void moveToNorthWest() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex() - 1,
                currentPlayer.getGridPosition().getColumnIndex() - 1));
        checkTurn();
    }

    public void moveToSouthWest() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex() + 1,
                currentPlayer.getGridPosition().getColumnIndex() - 1));
        checkTurn();
    }

    public void moveToNorthEast() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex() - 1,
                currentPlayer.getGridPosition().getColumnIndex() + 1));
        checkTurn();
    }

    public void moveToSouthEast() {
        moveTo(new GridPosition(
                currentPlayer.getGridPosition().getRowIndex() + 1,
                currentPlayer.getGridPosition().getColumnIndex() + 1));
        currentPlayer.addPositionToTrail();
        checkTurn();
    }

    private void checkTurn(){
        if(++turnCounter >=3) {
            turnCounter  = 0;
            changeCurrentPlayer();
        }
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
        if (newSquare == null) {
            return false;
        }
        if (playerBlue.getGridPosition().equals(newSquare.getGridPosition())||playerRed.getGridPosition().equals(newSquare.getGridPosition())){
            return false;
        }
        for (Wall wall:walls){
            if (wall.getGridPosition().equals(newSquare.getGridPosition())){
                return false;
            }
        }
        return true;
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
