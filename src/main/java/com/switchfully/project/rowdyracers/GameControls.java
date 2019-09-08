package com.switchfully.project.rowdyracers;

import java.awt.*;

public class GameControls {

    private final Button[][] controlButtons;

    public GameControls() {
        controlButtons = createControlButtons();
    }

    public Button[][] getControlButtons() {
        return controlButtons;
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
