package com.switchfully.project.rowdyracers.gui.components.grid.player;

import com.switchfully.project.rowdyracers.domain.GridPosition;
import com.switchfully.project.rowdyracers.domain.Player;
import com.switchfully.project.rowdyracers.gui.components.GraphicElement;
import com.switchfully.project.rowdyracers.gui.components.SquarePositionHelper;
import com.switchfully.project.rowdyracers.gui.components.grid.square.SquareGE;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class PlayerGE extends GraphicElement {

    private static final String IMG_EXTENSION = ".png";
    private static final String RESOURCES_BASE_PATH = "/";

    private final Player player;

    public PlayerGE(Player player) {
        this.player = player;
    }

    @Override
    public void paint(Graphics g) {
        try {
            g.drawImage(
                    createImage(),
                    SquarePositionHelper.fromColumnToXCoordinate(player.getGridPosition().getColumn()),
                    SquarePositionHelper.fromRowToYCoordinate(player.getGridPosition().getRow()),
                    null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Image createImage() throws IOException {
        return ImageIO.read(getClass()
                .getResourceAsStream(RESOURCES_BASE_PATH + player.getPlayerImgNameWithoutExtension() + IMG_EXTENSION))
                    .getScaledInstance(
                        player.getSize().getWidth(),
                        player.getSize().getHeight(),
                        Image.SCALE_SMOOTH);
    }

    public GridPosition getPositionOfSouthSquare(int maxAllowedRowIndex) {
        GridPosition proposedNewGridPosition = player.getSouthPosition();
        if(proposedNewGridPosition.getRow() <= maxAllowedRowIndex) {
            return proposedNewGridPosition;
        }
        return player.getGridPosition();
    }

    public void placeOnSquare(SquareGE squareGE) {
        player.moveToSquare(squareGE.getSquare());
    }
}
