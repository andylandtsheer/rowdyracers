package com.switchfully.project.rowdyracers.domain;

public class Square {

    public static final int WIDTH_HEIGHT_IN_PX = 50;

    private final GridPosition gridPosition;
    private final Size size;

    private FillColor fillColor;

    public Square(GridPosition gridPosition, Size size, FillColor fillColor) {
        this.gridPosition = gridPosition;
        this.size = size;
        this.fillColor = fillColor;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public Size getSize() {
        return size;
    }

    public FillColor getFillColor() {
        return fillColor;
    }

}
