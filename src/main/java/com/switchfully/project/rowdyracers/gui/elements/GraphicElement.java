package com.switchfully.project.rowdyracers.gui.elements;

import java.awt.*;

/**
 * Represent the GUI counterparts of domain objects.
 * Subclasses should not contain any domain logic, but merely code to allow to represent
 * their corresponding domain object in the GUI.
 */
public abstract class GraphicElement extends Component {

    @Override
    public abstract void paint(Graphics g);

}
