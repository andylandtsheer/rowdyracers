package com.switchfully.project.rowdyracers;

import com.switchfully.project.rowdyracers.views.GridView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameCanvas extends Canvas {

    private final GridView view;
    private List<Component> componentsToPaint;

    public GameCanvas() {
        this(new ArrayList<>());
    }

    public GameCanvas(List<Component> componentsToPaint) {
        this.componentsToPaint = componentsToPaint;
        view = new GridView(this);
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
