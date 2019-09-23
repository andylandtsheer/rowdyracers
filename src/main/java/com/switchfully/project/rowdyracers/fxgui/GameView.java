package com.switchfully.project.rowdyracers.fxgui;

import com.switchfully.project.rowdyracers.fxgui.elements.Drawable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static com.switchfully.project.rowdyracers.RowdyRacersFxApplication.*;
import static com.switchfully.project.rowdyracers.domain.Square.WIDTH_HEIGHT_IN_PX;

public class GameView {

    public static final int HORIZONTAL_SPACING_BETWEEN_PANES = 10;
    public static final int BUTTONS_PANEL_WIDTH = 110;
    public static final int CANVAS_PANEL_WIDTH = AMOUNT_OF_GRID_COLUMNS * (SPACING_SIZE + WIDTH_HEIGHT_IN_PX);
    public static final int CANVAS_PANEL_HEIGHT = AMOUNT_OF_GRID_ROWS * (SPACING_SIZE + WIDTH_HEIGHT_IN_PX);

    private static final Color CANVAS_BACKGROUND_COLOR = Color.BLACK;
    private static final int AMOUNT_OF_HORIZONTAL_BUTTONS = 3;
    private static final int AMOUNT_OF_VERTICAL_BUTTONS = 3;
    private static final int MAX_WIDTH_OF_BUTTON = 50;
    private static final int MAX_HEIGHT_OF_BUTTON = 30;

    private final GraphicsContext graphicsContext2D;
    private final Pane parentPane;
    private final Button[] directionButtons;
    private final Drawable[] drawables;

    public GameView(Drawable[] drawables) {
        this.drawables = drawables;
        this.directionButtons = createDirectionButtons();

        GridPane buttonPane = new GridPane();
        Canvas canvasPane = new Canvas(CANVAS_PANEL_WIDTH, CANVAS_PANEL_HEIGHT);
        parentPane = new HBox(HORIZONTAL_SPACING_BETWEEN_PANES, buttonPane, canvasPane);
        parentPane.setBackground((new Background(new BackgroundFill(Color.rgb(10, 10, 20), CornerRadii.EMPTY, Insets.EMPTY))));

        graphicsContext2D = canvasPane.getGraphicsContext2D();
        addButtonsToGrid(buttonPane, directionButtons);
        fillCanvas();
    }

    private void fillCanvas() {
        graphicsContext2D.setFill(CANVAS_BACKGROUND_COLOR);
        graphicsContext2D.fillRect(0, 0, CANVAS_PANEL_WIDTH, CANVAS_PANEL_HEIGHT);
    }

    private Button[] createDirectionButtons() {

        return new Button[]{
                createButton(Direction.NORTH_WEST), createButton(Direction.NORTH), createButton(Direction.NORTH_EAST),
                createButton(Direction.WEST), createDisabledButton(), createButton(Direction.EAST),
                createButton(Direction.SOUTH_WEST), createButton(Direction.SOUTH), createButton(Direction.SOUTH_EAST),
        };
    }

    private Button createButton(Direction direction) {
        Button button = new Button(direction.getLabel());
        button.setMaxSize(MAX_WIDTH_OF_BUTTON, MAX_HEIGHT_OF_BUTTON);
        return button;
    }

    private Button createDisabledButton() {
        Button button = new Button("");
        button.setMaxSize(MAX_WIDTH_OF_BUTTON, MAX_HEIGHT_OF_BUTTON);
        button.setDisable(true);
        return button;
    }

    private void addButtonsToGrid(GridPane gridPane, Button[] buttons) {
        int buttonIndex = 0;
        for (int row = 0; row < AMOUNT_OF_HORIZONTAL_BUTTONS; row++) {
            for (int column = 0; column < AMOUNT_OF_VERTICAL_BUTTONS; column++) {
                gridPane.add(buttons[buttonIndex], column, row);
                buttonIndex++;
            }
        }
    }

    public void redraw() {
        for (Drawable drawable : drawables) {
            drawable.paint(graphicsContext2D);
        }
    }

    /**
     * Set the provided EventHandler for the button with Direction direction.
     *
     * @param eventHandler the {@code EventHandler} to set
     * @param direction    the {@code Direction} of the button for which we want to add the {@code EventHandler}
     */
    public void setActionListenerForButtonWithDirection(EventHandler<Event> eventHandler, Direction direction) {
        for (Button button : directionButtons) {
            if (button != null && button.getText().equals(direction.getLabel())) {
                button.setOnMouseClicked(eventHandler);
            }
        }
    }

    public Pane getParentPane() {
        return parentPane;
    }
}
