package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser extends SimpleGUI {
    public SimpleGUIWithFileChooser() {
        super();

        final JPanel browsePanel = new JPanel();
        browsePanel.setLayout(new BorderLayout());
        canvas.add(browsePanel, BorderLayout.NORTH);

        final JTextField browseField = new JTextField();
        browseField.setEditable(false);
        browseField.setFocusable(false);
        browsePanel.add(browseField, BorderLayout.CENTER);

        final JButton browseBtn = new JButton("Browse...");
        browsePanel.add(browseBtn, BorderLayout.LINE_END);
    }

    public static void main(final String... args) {
        new SimpleGUIWithFileChooser().display();
    }

}
