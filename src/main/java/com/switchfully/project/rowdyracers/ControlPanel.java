package com.switchfully.project.rowdyracers;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a panel that contains the GUI Controls to move a {@code Player}
 */
public class ControlPanel extends JPanel {

    private static final Color BACKGROUND_COLOR = Color.black;

    private final Button[][] buttons;

    public ControlPanel() {
        this.setLayout(new GridLayout(3, 3, 10, 10));
        this.setBackground(BACKGROUND_COLOR);
        buttons = createControlButtons();
        addButtonsToPanel();
    }

    private void addButtonsToPanel() {
        for (Button[] buttonRows : buttons) {
            for (Button button : buttonRows) {
                this.add(button != null ? button : new Label(""));
            }
        }
    }

    /**
     * We create a 3x3 matrix of buttons (based on the cardinal (North, North-east,...) directions.
     * The middle location (1,1) should contain no button.
     *
     * @return the 2D array containing 8 buttons.
     */
    private Button[][] createControlButtons() {
        return new Button[][]{
                {createButtonForLabel("NW"), createButtonForLabel("N"), createButtonForLabel("NE")},
                {createButtonForLabel("W"), null, createButtonForLabel("E")},
                {createButtonForLabel("SW"), createButtonForLabel("S"), createButtonForLabel("SE")},
        };
    }

    private Button createButtonForLabel(String btnLabel) {
        Button btn = new Button(btnLabel);
        btn.setBackground(Color.yellow);
        btn.setFont(new Font("Default", Font.BOLD, 20));
        return btn;
    }

}
