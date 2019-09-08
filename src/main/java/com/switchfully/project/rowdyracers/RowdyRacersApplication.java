package com.switchfully.project.rowdyracers;

import com.switchfully.project.rowdyracers.views.GridController;
import com.switchfully.project.rowdyracers.views.GridView;

public class RowdyRacersApplication {

    public static void main(String[] args) {

        RowdyRacersWindow mainWindow = new RowdyRacersWindow("Rowdy Racers");

        mainWindow
                .launch();

        GridController gridController =
                new GridController(
                        new GridView(
                                mainWindow.getGameCanvas(),
                                mainWindow.getGameControls()));
    }


}
