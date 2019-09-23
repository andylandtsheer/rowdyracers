package com.switchfully.project.rowdyracers.fxgui.elements;

import com.switchfully.project.rowdyracers.domain.Square;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static com.switchfully.project.rowdyracers.fxgui.elements.utility.SquareUtility.fromColumnIndexToXCoordinate;
import static com.switchfully.project.rowdyracers.fxgui.elements.utility.SquareUtility.fromRowIndexToYCoordinate;

public class SquareGE implements Drawable {

    private final Square square;

    public SquareGE(Square square) {
        this.square = square;
    }

    public Square getSquare() {
        return square;
    }

    @Override
    public void paint(GraphicsContext context) {
        context.setFill(Color.color(
                        square.getFillColor().getRed(),
                        square.getFillColor().getGreen(),
                        square.getFillColor().getBlue()));
        context.fillRect(
                fromColumnIndexToXCoordinate(square.getGridPosition().getColumnIndex()),
                fromRowIndexToYCoordinate(square.getGridPosition().getRowIndex()),
                square.getSize().getWidth(),
                square.getSize().getHeight());
    }
}
