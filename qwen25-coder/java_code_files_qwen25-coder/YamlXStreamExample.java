import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class YamlXStreamExample {
    public static void main(String[] args) {
        // Create an XStream object
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.processAnnotations(MyObject.class);
        
        // Example object to serialize
        MyObject myObject = new MyObject("example", 123);

        // Convert the Java object to XML string first
        String xmlString = xstream.toXML(myObject);

        try {
            // Create an ObjectMapper for YAML
            ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

            // Deserialize the XML string to a JSON node, then convert it to YAML
            Object jsonNode = yamlMapper.readTree(xmlString);
            String yamlString = yamlMapper.writeValueAsString(jsonNode);
            
            System.out.println("Serialized YAML:\n" + yamlString);

            // To deserialize: Convert back to JSON first, then parse with XStream
            Object deserializedJsonNode = yamlMapper.readTree(yamlString);
            String jsonFromYaml = yamlMapper.writeValueAsString(deserializedJsonNode);
            MyObject deserializedObject = (MyObject)xstream.fromXML(jsonFromYaml);

            System.out.println("Deserialized object:\n" + deserializedObject.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@XStreamAlias("MyObject")
class MyObject {
    private String name;
    private int id;

    public MyObject() {
        // default constructor
    }

    public MyObject(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getters and setters (optional depending on serialization requirements)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public int getId() {
        return id;
    } 

    public void setId(int id) {
        this.id = id;
    } 

    @Override
    public String toString() {
        return "MyObject{" +
               "name='" + name + '\'' +
               ", id=" + id +
               '}';
    }
}