import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptContext;

// Define the Person class
class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

public class Main_217 {
    public static void main(String[] args) throws Exception {
        // Create a ScriptEngineManager
        ScriptEngineManager manager = new ScriptEngineManager();

        // Get the JavaScript engine
        ScriptEngine engine = manager.getEngineByName("javascript");

        // Create a Java Bean
        Person person = new Person("John", "Doe");

        // Add the Java Bean to the script engine's context
        engine.put("person", person);

        // Execute a script that accesses the Java Bean
        String script = "person.setFirstName('Jane'); person.setLastName('Smith');";
        engine.eval(script);

        // Print the updated Java Bean
        System.out.println(person.getFirstName()); // prints "Jane"
        System.out.println(person.getLastName()); // prints "Smith"
    }
}