package com.switchfully.project.rowdyracers.gui.components.grid.square;

import com.switchfully.project.rowdyracers.domain.Square;
import com.switchfully.project.rowdyracers.gui.components.GraphicElement;

import java.awt.*;

import static com.switchfully.project.rowdyracers.gui.components.SquarePositionHelper.fromColumnToXCoordinate;
import static com.switchfully.project.rowdyracers.gui.components.SquarePositionHelper.fromRowToYCoordinate;

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
                fromColumnToXCoordinate(square.getGridPosition().getColumnIndex()),
                fromRowToYCoordinate(square.getGridPosition().getRowIndex()),
                square.getSize().getWidth(),
                square.getSize().getHeight());
    }

    public Square getSquare() {
        return square;
    }
}
