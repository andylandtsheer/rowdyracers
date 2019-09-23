package com.switchfully.project.rowdyracers.fxgui;

import com.switchfully.project.rowdyracers.fxgui.elements.Drawable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import static com.switchfully.project.rowdyracers.RowdyRacersFxApplication.WINDOW_WIDTH;

public class GameView {

    private static final int CONTROLS_PANEL_WIDTH = 300;
    public static final int CANVAS_PANEL_WIDTH = WINDOW_WIDTH - CONTROLS_PANEL_WIDTH;
    public static final int CANVAS_PANEL_HEIGHT = WINDOW_WIDTH - CONTROLS_PANEL_WIDTH;


    private final GraphicsContext graphicsContext2D;
    private HBox layout;
    private Button[] buttons;
    private Drawable[] drawables;

    public GameView(Drawable[] drawables) {


        this.drawables = drawables;

        this.buttons = createButtons();

        GridPane gridPane = new GridPane();

        addButtonsToGrid(gridPane, buttons);

        Canvas canvas = new Canvas(CANVAS_PANEL_WIDTH, CANVAS_PANEL_HEIGHT);
        graphicsContext2D = canvas.getGraphicsContext2D();

        graphicsContext2D.setFill(Color.RED);
        graphicsContext2D.fillRect(0, 0, CANVAS_PANEL_WIDTH, CANVAS_PANEL_HEIGHT);

        layout = new HBox(10, gridPane, canvas);

    }

    public HBox getLayout() {
        return layout;
    }

    public Button[] createButtons() {
        return new Button[]{
                new Button(Direction.NORTH_WEST.getLabel()), new Button(Direction.NORTH.getLabel()), new Button(Direction.NORTH_EAST.getLabel()),
                new Button(Direction.WEST.getLabel()), new Button("  "), new Button(Direction.EAST.getLabel()),
                new Button(Direction.SOUTH_WEST.getLabel()), new Button(Direction.SOUTH.getLabel()), new Button(Direction.SOUTH_EAST.getLabel()),
        };
    }

    public void addButtonsToGrid(GridPane gridPane, Button[] buttons) {
        int buttonIndex = 0;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                gridPane.add(buttons[buttonIndex], column, row);
                buttonIndex++;
            }
        }
    }

    /**
     * Set the provided EventHandler for the button with Direction direction.
     *
     * @param eventHandler the {@code EventHandler} to set
     * @param direction      the {@code Direction} of the button for which we want to add the {@code EventHandler}
     * @return true if the eventHandler could be set for the button with the provided {@code Direction}.
     */
    public boolean setActionListenerForButtonWithDirection(EventHandler<Event> eventHandler, Direction direction) {
        for (Button button : buttons) {
            if (button != null && button.getText().equals(direction.getLabel())) {
                button.setOnMouseClicked(eventHandler);
                return true;
            }
        }
        return false;
    }

    public void redraw() {
        for (Drawable drawable : drawables) {
            drawable.paint(graphicsContext2D);
        }
    }
}
