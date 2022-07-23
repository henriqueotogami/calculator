package br.com.otogamidev.view;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Keyboard extends JPanel {
    private final Color COLOR_DARK_GREY = new Color(68,68,68);
    private final Color COLOR_LIGHT_GREY = new Color(68,68,68);
    private final Color COLOR_ORANGE = new Color(242,163,60);

    public Keyboard() {
        final int oneColumn = 1;
        final int twoColumns = 2;
        final int threeColumns = 3;
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        setLayout(gridBagLayout);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        gridBagConstraints.gridwidth = threeColumns;
        addGridButtonOnLayout("AC",  COLOR_DARK_GREY,  gridBagConstraints,0,0);

        gridBagConstraints.gridwidth = oneColumn;
        addGridButtonOnLayout("/",   COLOR_ORANGE,     gridBagConstraints,3,0);

        addGridButtonOnLayout("7",   COLOR_LIGHT_GREY, gridBagConstraints,0,1);
        addGridButtonOnLayout("8",   COLOR_LIGHT_GREY, gridBagConstraints,1,1);
        addGridButtonOnLayout("9",   COLOR_LIGHT_GREY, gridBagConstraints,2,1);
        addGridButtonOnLayout("X",   COLOR_ORANGE,     gridBagConstraints,3,1);

        addGridButtonOnLayout("4",   COLOR_LIGHT_GREY, gridBagConstraints,0,2);
        addGridButtonOnLayout("5",   COLOR_LIGHT_GREY, gridBagConstraints,1,2);
        addGridButtonOnLayout("6",   COLOR_LIGHT_GREY, gridBagConstraints,2,2);
        addGridButtonOnLayout("-",   COLOR_ORANGE,     gridBagConstraints,3,2);

        addGridButtonOnLayout("1",   COLOR_LIGHT_GREY, gridBagConstraints,0,3);
        addGridButtonOnLayout("2",   COLOR_LIGHT_GREY, gridBagConstraints,1,3);
        addGridButtonOnLayout("3",   COLOR_LIGHT_GREY, gridBagConstraints,2,3);
        addGridButtonOnLayout("+",   COLOR_ORANGE,     gridBagConstraints,3,3);

        gridBagConstraints.gridwidth = twoColumns;
        addGridButtonOnLayout("0",   COLOR_LIGHT_GREY, gridBagConstraints,0,4);

        gridBagConstraints.gridwidth = oneColumn;
        addGridButtonOnLayout(",",   COLOR_LIGHT_GREY, gridBagConstraints,2,4);
        addGridButtonOnLayout("=",   COLOR_ORANGE,     gridBagConstraints,3,4);
    }

    private void addGridButtonOnLayout(final String buttonText, final Color buttonColor,
                                       final GridBagConstraints gridBagConstraints, final int positionX,
                                       final int positionY) {
        gridBagConstraints.gridx = positionX;
        gridBagConstraints.gridy = positionY;
        Button button = new Button(buttonText, buttonColor);
        add(button, gridBagConstraints);
    }
}
