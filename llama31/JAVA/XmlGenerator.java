import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class XmlGenerator {
    public static void main(String[] args) {
        // Set the file path and name
        String filePath = "/path/to/your/xml/file.xml";

        // Create a File object
        File file = new File(filePath);

        // Create a FileWriter object
        try (FileWriter writer = new FileWriter(file)) {
            // Write the XML content to the file
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<playlist version=\"1\" xmlns=\"http://xspf.org/ns/0/\">\n");
            writer.write("    <title>My Band Rocks Your Socks</title>\n");
            writer.write("    <trackList>\n");

            // Simulate the request parameter
            String[] sports = {"url1,image1,title1", "url2,image2,title2"};

            if (sports != null) {
                for (String total : sports) {
                    String[] sa = total.split(",");
                    writer.write("        <track>\n");
                    for (int j = 0; j < sa.length; j++) {
                        if (j == 0) {
                            writer.write("            <location>" + sa[0] + "</location>\n");
                        } else if (j == 1) {
                            writer.write("            <image>" + sa[1] + "</image>\n");
                        } else if (j == 2) {
                            writer.write("            <title>" + sa[2] + "</title>\n");
                        }
                    }
                    writer.write("        </track>\n");
                }
            }

            writer.write("    </trackList>\n");
            writer.write("</playlist>\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}