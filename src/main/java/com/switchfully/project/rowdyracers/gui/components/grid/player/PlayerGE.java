package com.switchfully.project.rowdyracers.gui.components.grid.player;

import com.switchfully.project.rowdyracers.domain.Player;
import com.switchfully.project.rowdyracers.gui.components.GraphicElement;
import com.switchfully.project.rowdyracers.gui.components.SquarePositionHelper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static com.switchfully.project.rowdyracers.gui.components.SquarePositionHelper.*;

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
                    fromColumnToXCoordinate(player.getGridPosition().getColumnIndex()),
                    fromRowToYCoordinate(player.getGridPosition().getRowIndex()),
                    null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Image createImage() throws IOException {
        return ImageIO.read(getClass()
                .getResourceAsStream(RESOURCES_BASE_PATH + player.getPlayerImgNameWithoutExtension() + IMG_EXTENSION))
                    .getScaledInstance(
                        getSquareWidth(),
                        getSquareHeight(),
                        Image.SCALE_SMOOTH);
    }

}
