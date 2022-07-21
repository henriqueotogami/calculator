package br.com.otogamidev.view;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Keyboard extends JPanel {
    private final Color COLOR_DARK_GREY = new Color(68,68,68);
    private final Color COLOR_LIGHT_GREY = new Color(68,68,68);
    private final Color COLOR_ORANGE = new Color(242,163,60);
    public Keyboard() {
        final int keyboardLines = 5;
        final int keyboardColumns = 4;
        setLayout(new GridLayout(keyboardLines, keyboardColumns));
        add(new Button("AC", COLOR_DARK_GREY));
        add(new Button("+/-", COLOR_DARK_GREY));
        add(new Button("%", COLOR_DARK_GREY));
        add(new Button("/", COLOR_ORANGE));

        add(new Button("7", COLOR_LIGHT_GREY));
        add(new Button("8", COLOR_LIGHT_GREY));
        add(new Button("9", COLOR_LIGHT_GREY));
        add(new Button("*", COLOR_ORANGE));

        add(new Button("4", COLOR_LIGHT_GREY));
        add(new Button("5", COLOR_LIGHT_GREY));
        add(new Button("6", COLOR_LIGHT_GREY));
        add(new Button("+", COLOR_ORANGE));

        add(new Button("1", COLOR_LIGHT_GREY));
        add(new Button("2", COLOR_LIGHT_GREY));
        add(new Button("3", COLOR_LIGHT_GREY));
        add(new Button("-", COLOR_ORANGE));

    }
}
