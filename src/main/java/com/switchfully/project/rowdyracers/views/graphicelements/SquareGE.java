package com.switchfully.project.rowdyracers.views.graphicelements;

import java.awt.*;

public class SquareGE extends GraphicElement {

    private static final Color fillColor = Color.darkGray;

    private final Coordinates coordinates;
    private final Dimension dimension;

    public SquareGE(Coordinates coordinates, Dimension dimension) {
        this.coordinates = coordinates;
        this.dimension = dimension;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(fillColor);
        g.fillRect(coordinates.getX(), coordinates.getY(), dimension.width, dimension.height);
    }
}
