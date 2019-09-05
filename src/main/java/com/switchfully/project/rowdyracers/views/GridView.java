package com.switchfully.project.rowdyracers.views;

import javax.swing.*;
import java.awt.*;

public class GridView {

    public JFrame launch() {
        JFrame frame = new JFrame();
        frame.setSize(450, 500);
        JPanel contentPane = new JPanel(new FlowLayout());
        contentPane.add(new Label("Hello"));
        Canvas comp = new Canvas();
        comp.setBackground(Color.blue);
        comp.setSize(450, 500);
        contentPane.add(comp);
        frame.add(contentPane);
        return frame;
    }

}
