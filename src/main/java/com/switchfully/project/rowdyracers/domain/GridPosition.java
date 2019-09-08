package com.switchfully.project.rowdyracers.domain;

public final class GridPosition {

    private final int row;
    private final int column;

    public GridPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
