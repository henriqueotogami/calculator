package br.com.otogamidev.view;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame {

    
    public Calculator(){
        final int screenWidth = 232;
        final int screenHeight = 322;
        final Component windowCenteredOnTheScreen = null;

        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(windowCenteredOnTheScreen);
        setVisible(true);
    }

    public static void main(String[] args){
        new Calculator();
    }
}
