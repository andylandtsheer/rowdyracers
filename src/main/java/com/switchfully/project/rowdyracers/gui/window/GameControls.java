package com.switchfully.project.rowdyracers.gui.window;

import java.awt.*;
import java.awt.event.ActionListener;

import static com.switchfully.project.rowdyracers.gui.window.GameControls.Direction.*;

public class GameControls {

    private final Button[][] controlButtons;

    public GameControls() {
        controlButtons = createControlButtons();
    }

    public Button[][] getControlButtons() {
        return controlButtons;
    }

    /**
     * Set the provided ActionListener for the button with Direction direction.
     * @param actionListener the {@code ActionListener} to set
     * @param direction the {@code Direction} of the button for which we want to add the {@code ActionListener}
     * @return true if the actionListener could be set for the button with the provided {@code Direction}.
     */
    public boolean setActionListenerForButtonWithDirection(ActionListener actionListener, Direction direction) {
        for (Button[] buttonRow : controlButtons) {
            for (Button button : buttonRow) {
                if(button != null && button.getLabel().equals(direction.getLabel())) {
                    button.addActionListener(actionListener);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * We create a 3x3 matrix of buttons (based on the cardinal (North, North-east,...) directions.
     * The middle location (1,1) should contain no button.
     *
     * @return the 2D array containing 8 buttons.
     */
    private Button[][] createControlButtons() {
        return new Button[][]{
                {createButtonForLabel(NORTH_WEST.getLabel()), createButtonForLabel(NORTH.getLabel()), createButtonForLabel(NORTH_EAST.getLabel())},
                {createButtonForLabel(WEST.getLabel()), null, createButtonForLabel(EAST.getLabel())},
                {createButtonForLabel(SOUTH_WEST.getLabel()), createButtonForLabel(SOUTH.getLabel()), createButtonForLabel(SOUTH_EAST.getLabel())},
        };
    }

    private Button createButtonForLabel(String btnLabel) {
        Button btn = new Button(btnLabel);
        btn.setBackground(Color.yellow);
        btn.setFont(new Font("Default", Font.BOLD, 20));
        return btn;
    }

    public enum Direction {

        NORTH("N"),
        NORTH_EAST("NE"),
        EAST("E"),
        SOUTH_EAST("SE"),
        SOUTH("S"),
        SOUTH_WEST("SW"),
        WEST("W"),
        NORTH_WEST("NW");

        private final String label;

        Direction(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

}
