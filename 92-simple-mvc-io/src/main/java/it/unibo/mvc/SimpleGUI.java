package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public class SimpleGUI {

    private static final int PROPORTION = 4;

    private final JFrame frame = new JFrame();
    private final JPanel canvas = new JPanel();

    public SimpleGUI() {
        canvas.setLayout(new BorderLayout());

        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);

        final JButton saveBtn = new JButton("Save");
        canvas.add(saveBtn, BorderLayout.SOUTH);

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                try {
                    Controller.writeToFile(textArea.getText());
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace(); // NOPMD
                }
            }
        });

        frame.setContentPane(canvas);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JPanel getCanvas() {
        return this.canvas;
    }

    protected void display() {
        this.display(PROPORTION);
    }

    protected void display(final int proportion) {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();

        frame.setSize(sw / proportion, sh / proportion);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
