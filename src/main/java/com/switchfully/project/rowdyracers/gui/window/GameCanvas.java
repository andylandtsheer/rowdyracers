package com.switchfully.project.rowdyracers.gui.window;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameCanvas extends Canvas {

    private List<Component> componentsToPaint;

    public GameCanvas() {
        this(new ArrayList<>());
    }

    public GameCanvas(List<Component> componentsToPaint) {
        this.componentsToPaint = componentsToPaint;
    }

    public void addComponent(Component component) {
        componentsToPaint.add(component);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Component component: componentsToPaint) {
            component.paint(g);
        }
    }
}
