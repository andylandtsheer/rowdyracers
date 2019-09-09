package com.switchfully.project.rowdyracers.domain;

public final class GridPosition {

    private final int rowIndex;
    private final int columnIndex;

    public GridPosition(int rowIndex, int column) {
        this.rowIndex = rowIndex;
        this.columnIndex = column;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public boolean isOutOfBoundsOfGrid(int amountOfRows, int amountOfColumns) {
        return rowIndex < 0 || rowIndex >= amountOfRows || columnIndex < 0 || columnIndex >= amountOfColumns;
    }
}
