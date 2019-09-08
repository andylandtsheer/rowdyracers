package com.switchfully.project.rowdyracers.views.graphicelements;

import com.switchfully.project.rowdyracers.domain.Player;

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
                    player.getCoordinates().getX(),
                    player.getCoordinates().getY(),
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

}
