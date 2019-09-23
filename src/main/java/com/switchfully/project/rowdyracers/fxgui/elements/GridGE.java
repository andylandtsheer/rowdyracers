package com.switchfully.project.rowdyracers.fxgui.elements;

import com.switchfully.project.rowdyracers.domain.Grid;
import com.switchfully.project.rowdyracers.domain.Square;
import javafx.scene.canvas.GraphicsContext;

public class GridGE implements Drawable {

    private final Grid grid;

    public GridGE(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void paint(GraphicsContext context) {
        Square[][] gridSquares = grid.getSquares();
        for (Square[] gridRow : gridSquares) {
            for (Square square : gridRow) {
                new SquareGE(square).paint(context);
            }
        }
    }


}
