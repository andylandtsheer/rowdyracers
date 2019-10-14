package com.switchfully.project.rowdyracers;

import com.switchfully.project.rowdyracers.domain.Game;
import com.switchfully.project.rowdyracers.domain.Grid;
import com.switchfully.project.rowdyracers.domain.Player;
import com.switchfully.project.rowdyracers.fxgui.GameController;
import com.switchfully.project.rowdyracers.fxgui.GameView;
import com.switchfully.project.rowdyracers.fxgui.elements.Drawable;
import com.switchfully.project.rowdyracers.fxgui.elements.GridGE;
import com.switchfully.project.rowdyracers.fxgui.elements.PlayerGE;
import com.switchfully.project.rowdyracers.fxgui.elements.WallGE;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;

import static com.switchfully.project.rowdyracers.fxgui.GameView.*;

public class RowdyRacersFxApplication extends Application {

    public static final int AMOUNT_OF_GRID_ROWS = 10;
    public static final int AMOUNT_OF_GRID_COLUMNS = 10;
    public static final int SPACING_SIZE = 5;

    private static final int SCENE_WIDTH = CANVAS_PANEL_WIDTH + HORIZONTAL_SPACING_BETWEEN_PANES + BUTTONS_PANEL_WIDTH;
    private static final int SCENE_HEIGHT = CANVAS_PANEL_HEIGHT;

    @Override
    public void start(Stage stage) {

        // Create the startup model
        Game gameModel = new Game(
                new Grid(AMOUNT_OF_GRID_ROWS, AMOUNT_OF_GRID_COLUMNS),
                new Player("player-red"),
                new Player("player-blue")
        );

        // Create the startup view
        GameView gameView = new GameView(
                new Drawable[]{
                        new GridGE(gameModel.getGrid()),
                        new PlayerGE(gameModel.getPlayerRed()),
                        new PlayerGE(gameModel.getPlayerBlue()),
                        new WallGE(gameModel.getWalls())
                }
        );

        // Create the startup controller
        GameController gameController = new GameController(
                gameModel,
                gameView);

        // Start the domain game logic (basically, start the game)
        gameController.start();

        // Launch the actual window (stage)
        Scene scene = new Scene(gameView.getParentPane(), SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
