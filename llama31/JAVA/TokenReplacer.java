import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenReplacer {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("path/to/properties/file.properties"));

        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");

        File dir = new File("path/to/files");
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                String content = new String(Files.readAllBytes(file.toPath()));
                Matcher matcher = pattern.matcher(content);
                StringBuffer sb = new StringBuffer();
                while (matcher.find()) {
                    String key = matcher.group(1);
                    String value = props.getProperty(key);
                    matcher.appendReplacement(sb, value != null ? value : "");
                }
                matcher.appendTail(sb);
                Files.write(file.toPath(), sb.toString().getBytes());
            }
        }
    }
}