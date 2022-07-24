package br.com.otogamidev.view;

import br.com.otogamidev.model.Memory;
import br.com.otogamidev.model.ObserverMemory;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel implements ObserverMemory {

    private JLabel label;

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(final JLabel label) {
        this.label = label;
    }

    public Display() {
        Memory.getSingletonInstance().addObserver(this);
        setBackground(new Color(46,49,50));
        setLabel(new JLabel(Memory.getSingletonInstance().getActualText()));
        getLabel().setForeground(Color.WHITE);
        getLabel().setFont(new Font("courier", Font.PLAIN, 30));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
        add(getLabel());
    }


    @Override
    public void changeValue(final String newValue) {
        getLabel().setText(newValue);
    }
}
