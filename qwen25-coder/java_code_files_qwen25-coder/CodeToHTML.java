import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.Color;

public class CodeToHTML {

    public static void exportCodeToHTML(File file) {
        // Read the file content
        try {
            String codeContent = new String(Files.readAllBytes(file.toPath()));

            // Here you would include logic to convert the content with syntax highlighting to HTML
            // This is a simplified example and does not handle actual formatting

            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<html><body style='color: #")
                       .append(rgbToHex(new Color(0, 0, 0)))
                       .append("'>")
                       .append(codeContent.replace("\n", "<br>").replace(" ", "&nbsp;"))
                       .append("</body></html>");

            // Write the html content to a file
            String outputPath = file.getParent() + "/" + file.getName() + ".html";
            try (FileWriter writer = new FileWriter(outputPath)) {
                writer.write(htmlBuilder.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String rgbToHex(Color color) {
        return String.format("%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
    }
}