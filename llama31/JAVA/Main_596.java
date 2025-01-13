import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.core.JsonParser;
import java.io.File;
import java.io.IOException;

public class Main_596 {
    public static void main(String[] args) throws IOException {
        // Create a YAML mapper with safe configuration
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.configure(MapperFeature.ACCEPT_YAML_LIST, false);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, false);

        // Deserialize the YAML file
        File yamlFile = new File("path/to/yaml/file.yaml");
        ObjectGraph objectGraph = mapper.readValue(yamlFile, ObjectGraph.class);
    }
}