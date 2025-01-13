import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.yaml.snakeyaml.Yaml;

public class YamlLoader {
    public static void main(String[] args) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        File file = new File("src/main/resources/foo.yaml");
        Object loaded = yaml.load(new FileInputStream(file));
        System.out.println(loaded);
    }
}