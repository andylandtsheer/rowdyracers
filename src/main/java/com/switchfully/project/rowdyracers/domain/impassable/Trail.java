package com.switchfully.project.rowdyracers.domain.impassable;

import com.switchfully.project.rowdyracers.domain.GridPosition;

import java.util.LinkedList;
import java.util.Queue;

public class Trail implements Impassable {
    private LinkedList<GridPosition> positions = new LinkedList<>();

    public void addPosition(GridPosition position){
        positions.offer(position);
        if (positions.size() > 3){
            positions.poll();
        }
    }

    public LinkedList<GridPosition> getPositions() {
        return positions;
    }
}
