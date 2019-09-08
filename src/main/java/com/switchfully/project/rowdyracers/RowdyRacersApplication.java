package com.switchfully.project.rowdyracers;

import com.switchfully.project.rowdyracers.gui.components.grid.GridController;
import com.switchfully.project.rowdyracers.gui.components.grid.GridView;
import com.switchfully.project.rowdyracers.gui.window.RowdyRacersWindow;

public class RowdyRacersApplication {

    public static void main(String[] args) {

        RowdyRacersWindow mainWindow = new RowdyRacersWindow("Rowdy Racers");

        mainWindow
                .launch();

        new GridController(
                new GridView(
                        mainWindow.getGameCanvas()),
                mainWindow.getGameControls());
    }


}
