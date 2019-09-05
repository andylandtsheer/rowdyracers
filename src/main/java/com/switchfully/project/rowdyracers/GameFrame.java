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

    static final int WINDOW_WIDTH = 1200;
    static final int WINDOW_HEIGHT = 750;
    static final int CONTROL_PANEL_WIDTH = 300;
    static final int CANVAS_PANEL_WIDTH = WINDOW_WIDTH - CONTROL_PANEL_WIDTH;


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
        controlPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH, WINDOW_HEIGHT));
        this.add(gamePanel, BorderLayout.EAST);
        gamePanel.setPreferredSize(new Dimension(CANVAS_PANEL_WIDTH, WINDOW_HEIGHT));
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

}
