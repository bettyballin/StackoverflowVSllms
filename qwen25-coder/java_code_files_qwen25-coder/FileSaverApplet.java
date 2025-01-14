import java.applet.Applet;
import java.awt.*;
import java.io.*;

public class FileSaverApplet extends Applet {
    private Frame frame = new Frame();

    public void init() {
        Button saveButton = new Button("Save File");
        add(saveButton);
        saveButton.addActionListener(e -> saveFile());
    }

    private void saveFile() {
        FileDialog fileDialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        fileDialog.setVisible(true);

        String directory = fileDialog.getDirectory();
        String filename = fileDialog.getFile();

        if (directory != null && filename != null) {
            try (PrintWriter out = new PrintWriter(new FileWriter(directory + filename))) {
                // Write your file content here
                out.println("Hello, world!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
    }
}