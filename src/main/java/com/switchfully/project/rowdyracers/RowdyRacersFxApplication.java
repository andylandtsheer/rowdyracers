package com.switchfully.project.rowdyracers;

import com.switchfully.project.rowdyracers.domain.Game;
import com.switchfully.project.rowdyracers.domain.Grid;
import com.switchfully.project.rowdyracers.domain.Player;
import com.switchfully.project.rowdyracers.fxgui.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RowdyRacersFxApplication extends Application {

    public static final int AMOUNT_OF_GRID_ROWS = 10;
    public static final int AMOUNT_OF_GRID_COLUMNS = 10;
    public static final int SPACING_SIZE = 5;

    public static final int WINDOW_WIDTH = 1050;
    public static final int WINDOW_HEIGHT = 750;

    @Override
    public void start(Stage stage) {


        // Create the domain objects
        Game game = new Game(
                new Grid(AMOUNT_OF_GRID_ROWS, AMOUNT_OF_GRID_COLUMNS),
                new Player("player-red"),
                new Player("player-blue")
        );

        // Create the GUI handlers
        GameController gameController = new GameController(game);

        // Start the domain game logic
        gameController.start();

        // Launch the actual window
        Scene scene = new Scene(gameController.getGameView().getLayout(), WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
