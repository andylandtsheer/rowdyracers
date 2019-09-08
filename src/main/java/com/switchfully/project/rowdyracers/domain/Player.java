package com.switchfully.project.rowdyracers.domain;

public class Player {

    private final Coordinates coordinates;
    private final Size size;
    private final String playerImgNameWithoutExtension;

    public Player(Coordinates coordinates, Size size, String playerImgNameWithoutExtension) {
        this.coordinates = coordinates;
        this.size = size;
        this.playerImgNameWithoutExtension = playerImgNameWithoutExtension;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Size getSize() {
        return size;
    }

    public String getPlayerImgNameWithoutExtension() {
        return playerImgNameWithoutExtension;
    }
}
