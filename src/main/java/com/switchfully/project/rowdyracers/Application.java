package com.switchfully.project.rowdyracers;

public class Application {

    public static void main(String[] args) {
        new GameFrame("Rowdy Racers", new CanvasPanel(), new ControlPanel())
                .launch();
    }



}
