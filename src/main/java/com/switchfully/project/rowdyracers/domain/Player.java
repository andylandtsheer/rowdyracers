package com.switchfully.project.rowdyracers.domain;

import com.switchfully.project.rowdyracers.domain.impassable.Trail;

import java.util.LinkedList;

public class Player {

    private final String playerImgNameWithoutExtension;
    private Square square;
    private final Trail trail;

    public Player(String playerImgNameWithoutExtension) {
        this.playerImgNameWithoutExtension = playerImgNameWithoutExtension;
        trail = new Trail();
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

    public void addPositionToTrail() {
        trail.addPosition(square.getGridPosition());
    }

    public Trail getTrail() {
        return trail;
    }
}
