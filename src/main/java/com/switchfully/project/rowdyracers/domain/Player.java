package com.switchfully.project.rowdyracers.domain;

public class Player {

    private final Size size;
    private final String playerImgNameWithoutExtension;

    private Square square;

    public Player(Square square, Size size, String playerImgNameWithoutExtension) {
        this.square = square;
        this.size = size;
        this.playerImgNameWithoutExtension = playerImgNameWithoutExtension;
    }

    public GridPosition getGridPosition() {
        return square.getGridPosition();
    }

    public void moveToSquare(Square newSquare) {
        square = newSquare;
    }

    public Size getSize() {
        return size;
    }

    public String getPlayerImgNameWithoutExtension() {
        return playerImgNameWithoutExtension;
    }

    public GridPosition getSouthPosition() {
        return new GridPosition(square.getGridPosition().getRow() + 1, square.getGridPosition().getColumn());
    }


}
