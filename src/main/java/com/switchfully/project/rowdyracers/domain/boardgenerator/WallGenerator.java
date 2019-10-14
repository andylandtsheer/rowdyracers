package com.switchfully.project.rowdyracers.domain.boardgenerator;

import com.switchfully.project.rowdyracers.domain.Grid;
import com.switchfully.project.rowdyracers.domain.GridPosition;
import com.switchfully.project.rowdyracers.domain.impassable.Wall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WallGenerator extends ImpassableGenerator<Wall> {
    private static List<Wall> walls = new ArrayList<>();

    public static List<Wall> generateWalls(Random random, Grid grid) {
        int numbersOfWallsToCalculate = (random.nextInt(20)) * grid.getAmountOfColumns() * grid.getAmountOfRows() / 100;
        if (numbersOfWallsToCalculate < 1) {
            numbersOfWallsToCalculate = 1;
        }
        while (walls.size() < numbersOfWallsToCalculate) {
            GridPosition gridPosition = new GridPosition(random.nextInt(grid.getAmountOfRows()), random.nextInt(grid.getAmountOfColumns()));
            Direction direction = Direction.getRandomDirection(random);
            int length = calculateLength(random, grid, direction);
            if (lastSquareOfWallIsOutOfBound(direction, length, gridPosition, grid)) {
                direction = direction.goOtherDirection();
            }
            List <Wall> tempWalls = calculateTempWall(length, direction, gridPosition);
            if (!wallsInterfereWithOtherThings(tempWalls, grid)) {
                walls.add((Wall) tempWalls);
            }
        }

        return walls;
    }

    private static boolean wallsInterfereWithOtherThings(List<Wall> walls, Grid grid) {
        if(wallOnStartposition(walls, grid)){
            return true;
        }
        return false;
    }

    private static boolean wallOnStartposition(List<Wall> walls, Grid grid) {
        for (Wall wall:walls) {
            if (wall.getGridPosition().equals(new GridPosition(0,0))||wall.getGridPosition().equals(new GridPosition(grid.getAmountOfRows()-1,grid.getAmountOfColumns()-1))){
                return true;
            }
        }
        return false;
    }

    private static List<Wall> calculateTempWall(int length, Direction direction, GridPosition gridPosition) {
        List <Wall> tempWall = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            switch (direction) {
                case EAST:
                    tempWall.add(new Wall(new GridPosition(gridPosition.getRowIndex(), gridPosition.getColumnIndex() + i)));
                    break;
                case WEST:
                    tempWall.add(new Wall(new GridPosition(gridPosition.getRowIndex(), gridPosition.getColumnIndex() - i)));
                    break;
                case NORTH:
                    tempWall.add(new Wall(new GridPosition(gridPosition.getRowIndex() - i, gridPosition.getColumnIndex())));
                    break;
                case SOUTH:
                    tempWall.add(new Wall(new GridPosition(gridPosition.getRowIndex() + i, gridPosition.getColumnIndex())));
                    break;
            }
        }
        return tempWall;

    }

    private static boolean lastSquareOfWallIsOutOfBound(Direction direction, int length, GridPosition gridPosition, Grid grid) {
        switch (direction) {
            case EAST:
                return (gridPosition.getColumnIndex() + length - 1) > grid.getAmountOfColumns();
            case WEST:
                return (gridPosition.getColumnIndex() - length + 1) < 0;
            case NORTH:
                return (gridPosition.getRowIndex() - length + 1) < 0;
            case SOUTH:
                return (gridPosition.getRowIndex() + length - 1) > grid.getAmountOfRows();
        }
        return false;
    }

    private static int calculateLength(Random random, Grid grid, Direction direction) {
        if (direction.ordinal() % 2 == 0) {
            return random.nextInt(grid.getAmountOfRows() / 2);
        }
        return random.nextInt(grid.getAmountOfColumns() / 2);
    }
}
