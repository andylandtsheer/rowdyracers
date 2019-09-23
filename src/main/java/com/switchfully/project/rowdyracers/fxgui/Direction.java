package com.switchfully.project.rowdyracers.fxgui;

public enum Direction {

    NORTH("NO"),
    NORTH_EAST("NE"),
    EAST("EA"),
    SOUTH_EAST("SE"),
    SOUTH("SO"),
    SOUTH_WEST("SW"),
    WEST("WE"),
    NORTH_WEST("NW");

    private final String label;

    Direction(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
