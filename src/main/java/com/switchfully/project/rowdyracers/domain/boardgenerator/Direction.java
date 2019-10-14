package com.switchfully.project.rowdyracers.domain.boardgenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    private static final List<Direction> VALUES = Arrays.asList(values());

    public static Direction getRandomDirection(Random random) {
        return VALUES.get(random.nextInt(4));
    }

    public Direction goOtherDirection() {
        return VALUES.get((this.ordinal() + 2) % 4);
    }
}
