package com.switchfully.project.rowdyracers.domain;

public class Square {

    private final Coordinates coordinates;
    private final Size size;

    private FillColor fillColor;

    public Square(Coordinates coordinates, Size size, FillColor fillColor) {
        this.coordinates = coordinates;
        this.size = size;
        this.fillColor = fillColor;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Size getSize() {
        return size;
    }

    public FillColor getFillColor() {
        return fillColor;
    }
}
