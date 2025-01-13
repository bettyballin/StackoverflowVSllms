import java.lang.String;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.yaml.YamlDriver;

public class YamlSerializer {
    public static String serializeToYaml(Object obj) {
        XStream xstream = new XStream(new YamlDriver());
        return xstream.toXML(obj);
    }

    public static Object deserializeFromYaml(String yaml) {
        XStream xstream = new XStream(new YamlDriver());
        return xstream.fromXML(yaml);
    }

    public static void main(String[] args) {
        // Example usage
        Person person = new Person("John Doe", 30);
        String yaml = serializeToYaml(person);
        System.out.println(yaml);

        Person deserializedPerson = (Person) deserializeFromYaml(yaml);
        System.out.println(deserializedPerson.getName() + ", " + deserializedPerson.getAge());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}