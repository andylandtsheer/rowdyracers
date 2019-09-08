package com.switchfully.project.rowdyracers.views.graphicelements;

import com.switchfully.project.rowdyracers.domain.Square;

import java.awt.*;

import static com.switchfully.project.rowdyracers.views.SquarePositionHelper.fromColumnToXCoordinate;
import static com.switchfully.project.rowdyracers.views.SquarePositionHelper.fromRowToYCoordinate;

public class SquareGE extends GraphicElement {

    private final Square square;

    public SquareGE(Square square) {
        this.square = square;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(
                new Color(
                        square.getFillColor().getRed(),
                        square.getFillColor().getGreen(),
                        square.getFillColor().getBlue()));
        g.fillRect(
                fromColumnToXCoordinate(square.getGridPosition().getColumn()),
                fromRowToYCoordinate(square.getGridPosition().getRow()),
                square.getSize().getWidth(),
                square.getSize().getHeight());
    }

    public Square getSquare() {
        return square;
    }
}
