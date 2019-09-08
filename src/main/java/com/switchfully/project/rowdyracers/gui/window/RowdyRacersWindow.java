package com.switchfully.project.rowdyracers.gui.window;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the actual window in which RowdyRacers will be played.
 * The window is divided into 2 horizontal sections.
 *      The top is reserved for the controls.
 *      The bottom is reserved for the gameCanvas.
 */
public class RowdyRacersWindow extends JFrame {

    private static final int WINDOW_WIDTH = 1050;
    private final int WINDOW_HEIGHT = 750;
    private static final int CONTROL_PANEL_WIDTH = 300;

    public static final int CANVAS_PANEL_WIDTH = WINDOW_WIDTH - CONTROL_PANEL_WIDTH - 15;
    public static final int CANVAS_PANEL_HEIGHT = WINDOW_WIDTH - CONTROL_PANEL_WIDTH - 40;

    private final GamePanel gamePanel;
    private final ControlsPanel controlsPanel;

    public RowdyRacersWindow(String title) throws HeadlessException {
        super(title);
        this.setResizable(false);
        this.gamePanel = new GamePanel();
        this.controlsPanel = new ControlsPanel();
    }

    public void launch() {
        this.add(controlsPanel, BorderLayout.WEST);
        this.add(gamePanel, BorderLayout.EAST);
        controlsPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH, WINDOW_HEIGHT));
        gamePanel.setPreferredSize(new Dimension(CANVAS_PANEL_WIDTH, WINDOW_HEIGHT));
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setBackground(Color.darkGray);
        this.setVisible(true);
    }

    public GameCanvas getGameCanvas() {
        return gamePanel.getGameCanvas();
    }

    public GameControls getGameControls() {
        return controlsPanel.getGameControls();
    }

    /**
     * Represents the game (gameCanvas), of the Rowdy Racers game, that contains and shows all the GUI elements (The images representing
     * the grid, player, walls,...
     */
    private static class GamePanel extends JPanel {

        private static final Color BACKGROUND_COLOR = Color.BLACK;

        private final GameCanvas gameCanvas;

        private GamePanel() {
            super(new FlowLayout());
            gameCanvas = createCanvasComponent();
            this.add(gameCanvas);
            this.setBackground(BACKGROUND_COLOR);
        }

        private GameCanvas createCanvasComponent() {
            GameCanvas canvas = new GameCanvas();
            canvas.setPreferredSize(new Dimension(RowdyRacersWindow.CANVAS_PANEL_WIDTH, RowdyRacersWindow.CANVAS_PANEL_HEIGHT));
            canvas.setBackground(BACKGROUND_COLOR);
            return canvas;
        }

        private GameCanvas getGameCanvas() {
            return gameCanvas;
        }
    }

    /**
     * Represents a panel that contains the GUI Controls to move a {@code Player}
     */
    private static class ControlsPanel extends JPanel {

        private static final Color BACKGROUND_COLOR = Color.black;

        private final GameControls gameControls;

        private ControlsPanel() {
            gameControls = new GameControls();
            this.setLayout(new GridLayout(3, 3, 10, 10));
            this.setBackground(BACKGROUND_COLOR);
            addButtonsToPanel(gameControls.getControlButtons());
        }

        private void addButtonsToPanel(Button[][] buttons) {
            for (Button[] buttonRows : buttons) {
                for (Button button : buttonRows) {
                    this.add(button != null ? button : new Label(""));
                }
            }
        }

        private GameControls getGameControls() {
            return gameControls;
        }
    }



}
