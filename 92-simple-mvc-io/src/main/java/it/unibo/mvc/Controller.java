package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    private static File currentFile = new File(
        System.getProperty("user.home")
        + System.getProperty("file.separator")
        + "output.txt"
    );

    private Controller() {
    }

    /**
     * Sets a new file as the current file.
     * 
     * @param file the new file to set
     */
    public static void setCurrentFile(final File file) {
        Controller.currentFile = file;
    }

    /**
     * @return the current file
     */
    public static File getCurrentFile() {
        return Controller.currentFile;
    }

    /**
     * @return the current file's absolute path
     */
    public static String getFilePath() {
        return currentFile.getAbsolutePath();
    }

    /**
     * Writes a String into the current file.
     * If a break character is not present at the end of the message 
     * a <code>\n</code> break character will be added.
     * 
     * @param message - the message to write into the file
     * @throws IOException - If an I/O error occurs
     */
    public static void writeToFile(final String message) throws IOException {
        try (
            BufferedWriter w = new BufferedWriter(new FileWriter(currentFile))
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
