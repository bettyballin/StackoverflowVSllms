import java.lang.String;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.YamlConfig;

public class YamlConfigurator {
    public static void main(String[] args) {
        YamlConfig yamlConfig = new YamlConfig();
        yamlConfig.setSkipClassTags(true);
        Yaml jYaml = new Yaml(yamlConfig);
    }
}