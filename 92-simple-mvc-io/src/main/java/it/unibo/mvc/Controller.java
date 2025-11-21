package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static File currentFile = new File(
        System.getProperty("user.home")
        + System.getProperty("file.separator")
        + "output.txt"
    );

    public void setCurrentFile(final File file) {
        Controller.currentFile = file;
    }

    public File getCurrentFile() {
        return Controller.currentFile;
    }

    public String getFilePath() {
        return currentFile.getAbsolutePath();
    }

    public static void writeToFile(final String message) throws IOException {
        try (
            final BufferedWriter w = new BufferedWriter(new FileWriter(currentFile))
        ) {
            var formattedMessage = message;
            if (!formattedMessage.endsWith("\n")) {
                formattedMessage += "\n";
            }
        
            w.write(formattedMessage);
        } catch (final IOException e) {
            throw e;
        }
    }
}
