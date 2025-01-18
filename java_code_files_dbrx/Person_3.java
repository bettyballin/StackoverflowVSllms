import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person_3 {
    private String name;
    private int age;

    // Constructors
    public Person_3() {
    }

    public Person_3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public int getAge() {
		return age;
	}

    public void setAge(int age) {
        this.age = age;
    }
}

class MainClass {
    public static void main(String[] args) {
        // Create a mock request object
        Request request = new Request();

        // In your servlet or JSP:
        List<Person_3> people = new ArrayList<>();
        Person_3 person;
        int indexCounter = 1;
        while (true) { // you might decide to use a different looping condition based on input data size or an error indicator
            String paramName = "person[" + indexCounter + "][name]";
            if (!request.getParameterMap().containsKey(paramName)) break;
            person = new Person_3();
            person.setName(request.getParameter(paramName));
            person.setAge(Integer.parseInt(request.getParameter("person[" + indexCounter + "][age]")));
            people.add(person);
            indexCounter++;
        }
        
        // Optional: Print the list of people
        for (Person_3 p : people) {
            System.out.println("Name: " + p.getName() + ", Age: " + p.getAge());
        }
    }
}

// Mock Request class to simulate the request object
class Request {
    private Map<String, String> parameters;

    public Request() {
        parameters = new HashMap<>();
        // Populate parameters with some test data if needed
        parameters.put("person[1][name]", "Alice");
        parameters.put("person[1][age]", "30");
        parameters.put("person[2][name]", "Bob");
        parameters.put("person[2][age]", "25");
        // Add more parameters as needed
    }

    public String getParameter(String name) {
        return parameters.get(name);
    }

    public Map<String, String> getParameterMap() {
        return parameters;
    }
}