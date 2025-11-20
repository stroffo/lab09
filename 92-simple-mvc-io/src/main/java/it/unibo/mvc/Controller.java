package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile = new File(
        System.getProperty("user.home")
        + System.getProperty("file.separator")
        + "output.txt"
    );

    public void setCurrentFile(final File file) {
        this.currentFile = file;
    }

    public File getCurrentFile() {
        return this.currentFile;
    }

    public String getFilePath() {
        return currentFile.getAbsolutePath();
    }

    public void writeToFile(final String message) throws IOException {
        try (
            final BufferedWriter w = new BufferedWriter(new FileWriter(currentFile))
        ) {
            w.write(message);
        } catch (final IOException e) {
            throw e;
        }
    }
}
