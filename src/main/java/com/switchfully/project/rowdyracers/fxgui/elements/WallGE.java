package com.switchfully.project.rowdyracers.fxgui.elements;

import com.switchfully.project.rowdyracers.domain.impassable.Wall;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;

import static com.switchfully.project.rowdyracers.domain.Square.WIDTH_HEIGHT_IN_PX;
import static com.switchfully.project.rowdyracers.fxgui.elements.utility.SquareUtility.fromColumnIndexToXCoordinate;
import static com.switchfully.project.rowdyracers.fxgui.elements.utility.SquareUtility.fromRowIndexToYCoordinate;

public class WallGE implements Drawable {

    private static final String IMG_FILENAME = "wall.png";
    private static final String RESOURCES_BASE_PATH = "/";

    private final List<Wall> walls;

    public WallGE(List<Wall> walls) {
        this.walls = walls;
    }

    private Image createImage() {
        return new Image(getClass().getResourceAsStream(RESOURCES_BASE_PATH + IMG_FILENAME),
                WIDTH_HEIGHT_IN_PX, WIDTH_HEIGHT_IN_PX, true, true);
    }

    @Override
    public void paint(GraphicsContext context) {
        for (Wall wall : walls) {
            context.drawImage(
                    createImage(),
                    fromColumnIndexToXCoordinate(wall.getGridPosition().getColumnIndex()),
                    fromRowIndexToYCoordinate(wall.getGridPosition().getRowIndex()));
        }
    }
}
