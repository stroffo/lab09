package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
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
        browseField.setText(Controller.getFilePath());
        browsePanel.add(browseField, BorderLayout.CENTER);

        final JButton browseBtn = new JButton("Browse...");
        browsePanel.add(browseBtn, BorderLayout.LINE_END);
        
        browseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ignored) {
                final JFileChooser fileChooser = new JFileChooser(Controller.getCurrentFile());
                var res = fileChooser.showSaveDialog(browsePanel);

                if (res == JFileChooser.APPROVE_OPTION) {
                    Controller.setCurrentFile(fileChooser.getSelectedFile());
                    browseField.setText(Controller.getFilePath());
                }
            }            
        });
    }

    public static void main(final String... args) {
        new SimpleGUIWithFileChooser().display();
    }

}
