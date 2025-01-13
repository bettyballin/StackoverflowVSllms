/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyParser {
    public static void main(String[] stringArray) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(new File("path/to/your/properties/file.properties")));
        StringBuilder stringBuilder = new StringBuilder("<html><body>");
        for (String string : properties.stringPropertyNames()) {
            String string2 = properties.getProperty(string);
            if (string2.equalsIgnoreCase("Y") || string2.equalsIgnoreCase("N")) {
                stringBuilder.append("<p>").append(string).append("</p>");
                stringBuilder.append("<input type='radio' name='").append(string).append("' value='Y'>Yes");
                stringBuilder.append("<input type='radio' name='").append(string).append("' value='N'>No");
                continue;
            }
            if (string2.contains(",")) {
                String[] stringArray2;
                stringBuilder.append("<p>").append(string).append("</p>");
                stringBuilder.append("<select name='").append(string).append("'>");
                for (String string3 : stringArray2 = string2.split(",")) {
                    stringBuilder.append("<option value='").append(string3.trim()).append("'>").append(string3.trim()).append("</option>");
                }
                stringBuilder.append("</select>");
                continue;
            }
            if (string.contains("path")) {
                stringBuilder.append("<p>").append(string).append("</p>");
                stringBuilder.append("<input type='text' name='").append(string).append("' value='").append(string2).append("' readonly>");
                continue;
            }
            stringBuilder.append("<p>").append(string).append("</p>");
            stringBuilder.append("<input type='text' name='").append(string).append("' value='").append(string2).append("'>");
        }
        stringBuilder.append("</body></html>");
        System.out.println(stringBuilder.toString());
    }
}
