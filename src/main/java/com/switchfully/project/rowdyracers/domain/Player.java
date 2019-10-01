package com.switchfully.project.rowdyracers.domain;

public class Player {

    private final String playerImgNameWithoutExtension;
    private Square square;

    public Player(String playerImgNameWithoutExtension) {
        this.playerImgNameWithoutExtension = playerImgNameWithoutExtension;
    }

    public void moveTo(Square newSquare) {
        square = newSquare;
    }

    public GridPosition getGridPosition() {
        return square.getGridPosition();
    }

    public String getPlayerImgNameWithoutExtension() {
        return playerImgNameWithoutExtension;
    }

}
