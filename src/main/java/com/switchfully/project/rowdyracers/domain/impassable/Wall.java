package com.switchfully.project.rowdyracers.domain.impassable;

import com.switchfully.project.rowdyracers.domain.GridPosition;

import java.util.List;
import java.util.Objects;

public class Wall implements Impassable{
    private final GridPosition gridPosition;


    public Wall(GridPosition gridPosition) {
        this.gridPosition = gridPosition;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return Objects.equals(gridPosition, wall.gridPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gridPosition);
    }
}
