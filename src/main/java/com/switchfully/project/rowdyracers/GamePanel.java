package com.switchfully.project.rowdyracers;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the game (canvas), of the Rowdy Racers game, that contains and shows all the GUI elements (The images representing
 * the grid, player, walls,...
 */
public class GamePanel extends JPanel {

    private static final Color BACKGROUND_COLOR = Color.BLACK;

    private final GameCanvas canvas;

    public GamePanel() {
        super(new FlowLayout());
        canvas = createCanvasComponent();
        this.add(canvas);
        this.setBackground(BACKGROUND_COLOR);
    }

    public void setSize(Dimension dimension) {
        this.canvas.setSize(dimension);
    }

    private GameCanvas createCanvasComponent() {
        GameCanvas canvas = new GameCanvas();
        canvas.setPreferredSize(new Dimension(GameFrame.CANVAS_PANEL_WIDTH, GameFrame.CANVAS_PANEL_HEIGHT));
        canvas.setBackground(BACKGROUND_COLOR);
        return canvas;
    }
}
