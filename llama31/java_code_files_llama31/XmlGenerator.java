/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XmlGenerator {
    public static void main(String[] stringArray) {
        String string = "/path/to/your/xml/file.xml";
        File file = new File(string);
        try (FileWriter fileWriter = new FileWriter(file);){
            fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            fileWriter.write("<playlist version=\"1\" xmlns=\"http://xspf.org/ns/0/\">\n");
            fileWriter.write("    <title>My Band Rocks Your Socks</title>\n");
            fileWriter.write("    <trackList>\n");
            String[] stringArray2 = new String[]{"url1,image1,title1", "url2,image2,title2"};
            if (stringArray2 != null) {
                for (String string2 : stringArray2) {
                    String[] stringArray3 = string2.split(",");
                    fileWriter.write("        <track>\n");
                    for (int i = 0; i < stringArray3.length; ++i) {
                        if (i == 0) {
                            fileWriter.write("            <location>" + stringArray3[0] + "</location>\n");
                            continue;
                        }
                        if (i == 1) {
                            fileWriter.write("            <image>" + stringArray3[1] + "</image>\n");
                            continue;
                        }
                        if (i != 2) continue;
                        fileWriter.write("            <title>" + stringArray3[2] + "</title>\n");
                    }
                    fileWriter.write("        </track>\n");
                }
            }
            fileWriter.write("    </trackList>\n");
            fileWriter.write("</playlist>\n");
        }
        catch (IOException iOException) {
            System.err.println("Error writing to file: " + iOException.getMessage());
        }
    }
}
