package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    
    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame("Simple MVC I/O");

    public SimpleGUI() {
        final JPanel canvas = new JPanel();


        frame.setContentPane(canvas);
    }
    
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();

        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
