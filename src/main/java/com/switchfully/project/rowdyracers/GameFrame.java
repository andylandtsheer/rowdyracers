package com.switchfully.project.rowdyracers;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the actual window in which RowdyRacers will be played.
 * The window is divided into 2 horizontal sections.
 *      The top is reserved for the controls.
 *      The bottom is reserved for the canvas.
 */
public class GameFrame extends JFrame {

    public static final int WINDOW_WIDTH = 1050;
    public static final int WINDOW_HEIGHT = 750;
    public static final int CONTROL_PANEL_WIDTH = 300;
    public static final int CANVAS_PANEL_WIDTH = WINDOW_WIDTH - CONTROL_PANEL_WIDTH - 15;
    public static final int CANVAS_PANEL_HEIGHT = WINDOW_WIDTH - CONTROL_PANEL_WIDTH - 40;

    private final JPanel gamePanel;
    private final JPanel controlPanel;

    public GameFrame(String title, JPanel gamePanel, JPanel controlPanel) throws HeadlessException {
        super(title);
        this.setResizable(false);
        this.controlPanel = controlPanel;
        this.gamePanel = gamePanel;
    }

    public void launch() {
        this.add(controlPanel, BorderLayout.WEST);
        this.add(gamePanel, BorderLayout.EAST);
        controlPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH, WINDOW_HEIGHT));
        gamePanel.setPreferredSize(new Dimension(CANVAS_PANEL_WIDTH, WINDOW_HEIGHT));
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setBackground(Color.darkGray);
        this.setVisible(true);
    }

}
