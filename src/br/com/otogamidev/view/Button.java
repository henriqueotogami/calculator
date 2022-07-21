package br.com.otogamidev.view;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Button extends JButton {

    public Button(final String mathText, final Color mathTextColor) {
        setText(mathText);
        setFont(new Font("courier", Font.PLAIN, 25));
        setOpaque(true);
        setBackground(mathTextColor);
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
