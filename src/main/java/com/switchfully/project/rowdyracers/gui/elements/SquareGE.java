package com.switchfully.project.rowdyracers.gui.elements;

import com.switchfully.project.rowdyracers.domain.Square;

import java.awt.*;

import static com.switchfully.project.rowdyracers.gui.elements.utility.SquareUtility.fromColumnIndexToXCoordinate;
import static com.switchfully.project.rowdyracers.gui.elements.utility.SquareUtility.fromRowIndexToYCoordinate;

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
                fromColumnIndexToXCoordinate(square.getGridPosition().getColumnIndex()),
                fromRowIndexToYCoordinate(square.getGridPosition().getRowIndex()),
                square.getSize().getWidth(),
                square.getSize().getHeight());
    }

    public Square getSquare() {
        return square;
    }
}
