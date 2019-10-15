package com.switchfully.project.rowdyracers.fxgui.elements;

import com.switchfully.project.rowdyracers.domain.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;

import static com.switchfully.project.rowdyracers.fxgui.elements.utility.SquareUtility.*;

public class LineGE implements Drawable {
    private final Player player;
    private Line line = new Line();

    public LineGE(Player player) {
        this.player = player;
    }


    @Override
    public void paint(GraphicsContext context) {
        for (int i = 0; i < player.getTrail().getPositions().size() - 1 ; i++) {
            line.setStartX(fromColumnIndexToXCoordinateMiddleOfSquare(player.getTrail().getPositions().get(i).getColumnIndex()));
            line.setStartY(fromRowIndexToYCoordinateMiddleOfSquare(player.getTrail().getPositions().get(i).getRowIndex()));
            line.setEndX(fromColumnIndexToXCoordinateMiddleOfSquare(player.getTrail().getPositions().get(i+1).getColumnIndex()));
            line.setEndY(fromRowIndexToYCoordinateMiddleOfSquare(player.getTrail().getPositions().get(i+1).getRowIndex()));
        }
    }
}
