import com.thoughtworks.xstream.XStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YamlFactory;

public class YamlTest {
    public static void main(String[] args) {
        XStream xstream = new XStream();

        // Create a new POJO and convert it to XML
        Foo foo = new Foo("Hello", "World!");
        String xml = xstream.toXML(foo);
        System.out.println("XML:");
        System.out.println(xml);

        // Convert the same POJO to JSON using Jackson
        ObjectMapper jsonMapper = new ObjectMapper();
        try {
            String json = jsonMapper.writeValueAsString(foo);
            System.out.println("\nJSON:");
            System.out.println(json);
        } catch (Exception e) {
            // Handle Exception here.
            e.printStackTrace();
        }

        // Convert the same POJO to YAML using Jackson with YAMLFactory
        ObjectMapper yamlMapper = new ObjectMapper(new YamlFactory());
        try {
            String yml = yamlMapper.writeValueAsString(foo);
            System.out.println("\nYAML:");
            System.out.println(yml);
        } catch (Exception e) {
            // Handle Exception here.
            e.printStackTrace();
        }
    }
}

class Foo {
    private String hello;
    private String world;

    public Foo(String hello, String world) {
        this.hello = hello;
        this.world = world;
    }

    public String getHello() {
        return hello;
    }

    public String getWorld() {
        return world;
    }
}