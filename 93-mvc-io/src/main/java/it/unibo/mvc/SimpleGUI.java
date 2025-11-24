package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    
    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame("Simple MVC I/O");
    private final Controller controller = new SimpleController();

    public SimpleGUI() {
        final JPanel canvas = new JPanel(new BorderLayout());

        final JTextField textField = new JTextField();
        canvas.add(textField, BorderLayout.NORTH);
        
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFocusable(false);
        canvas.add(textArea, BorderLayout.CENTER);

        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
        canvas.add(buttonPanel, BorderLayout.SOUTH);

        JButton printButton = new JButton("Print");
        JButton historyButton = new JButton("Show History");

        buttonPanel.add(printButton);
        buttonPanel.add(historyButton);

        frame.setContentPane(canvas);

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                try {
                    controller.enqueue(textField.getText());
                    controller.dequeueAndPrint();
                } catch (Exception e) {
                    // ...
                }
            }
        });

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                try {
                    textArea.setText(controller.getPrintHisory().toString());
                } catch (Exception e) {
                    // ...
                }
            }
        });
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
