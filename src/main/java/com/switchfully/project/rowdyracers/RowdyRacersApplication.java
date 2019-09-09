package com.switchfully.project.rowdyracers;

import com.switchfully.project.rowdyracers.domain.Game;
import com.switchfully.project.rowdyracers.domain.Grid;
import com.switchfully.project.rowdyracers.domain.Player;
import com.switchfully.project.rowdyracers.gui.GameController;
import com.switchfully.project.rowdyracers.gui.window.RowdyRacersWindow;

public class RowdyRacersApplication {

    public static void main(String[] args) {

        // Create the actual window (it is not yet launched)
        RowdyRacersWindow mainWindow = new RowdyRacersWindow("Rowdy Racers");

        // Create the domain objects
        Game game = new Game(
                new Grid(10, 10),
                new Player("player-red"),
                new Player("player-blue")
        );

        // Create the GUI handlers
        GameController gameController = new GameController(
                mainWindow.getGameCanvas(),
                mainWindow.getGameControls(),
                game);

        // Start the domain game logic
        gameController.start();

        // Launch the actual window
        mainWindow.launch();
    }


}
