package br.com.otogamidev.view;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame {


    public Calculator(){
        final int screenWidth = 232;
        final int screenHeight = 322;
        final Component windowCenteredOnTheScreen = null;

        arrangeLayout();
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(windowCenteredOnTheScreen);
        setVisible(true);
    }

    public static void main(String[] args){
        new Calculator();
    }

    private void arrangeLayout() {
        final int displayWidth = 233;
        final int displayHeight = 60;

        setLayout(new BorderLayout());

        Display display = new Display();
        display.setPreferredSize(new Dimension(displayWidth, displayHeight));
        add(display, BorderLayout.NORTH);

        Keyboard keyboard = new Keyboard();
        add(keyboard, BorderLayout.CENTER);
    }
}
