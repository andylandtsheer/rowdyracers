package com.switchfully.project.rowdyracers.views.graphicelements;

import com.switchfully.project.rowdyracers.domain.Square;

import java.awt.*;

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
                square.getCoordinates().getX(),
                square.getCoordinates().getY(),
                square.getSize().getWidth(),
                square.getSize().getHeight());
    }
}
