package com.switchfully.project.rowdyracers;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the canvas, of the Rowdy Racers game, that contains and shows all the GUI elements (The images representing
 * the grid, player, walls,...
 */
public class CanvasPanel extends JPanel {

    private static final Color BACKGROUND_COLOR = Color.green;

    private final Component canvas;

    public CanvasPanel() {
        super(new FlowLayout());
        canvas = createCanvasComponent();
        this.add(canvas);
    }

    public void setSize(Dimension dimension) {
        this.canvas.setSize(dimension);
    }

    private Component createCanvasComponent() {
        Canvas canvas = new Canvas();
        canvas.setSize(GameFrame.CANVAS_PANEL_WIDTH, GameFrame.WINDOW_HEIGHT);
        canvas.setBackground(BACKGROUND_COLOR);
        return canvas;
    }
}
