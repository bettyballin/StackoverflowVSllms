/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenReplacer {
    public static void main(String[] stringArray) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("path/to/properties/file.properties"));
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        File file = new File("path/to/files");
        for (File file2 : file.listFiles()) {
            if (!file2.isFile()) continue;
            String string = new String(Files.readAllBytes(file2.toPath()));
            Matcher matcher = pattern.matcher(string);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                String string2 = matcher.group(1);
                String string3 = properties.getProperty(string2);
                matcher.appendReplacement(stringBuffer, string3 != null ? string3 : "");
            }
            matcher.appendTail(stringBuffer);
            Files.write(file2.toPath(), stringBuffer.toString().getBytes(), new OpenOption[0]);
        }
    }
}
