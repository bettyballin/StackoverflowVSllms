import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/processForm")
public class ProcessFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Integer, Person> people = new HashMap<>();

        for (int i = 1; ; i++) { // Loop through potential indices
            String nameParam = "person[" + i + "][name]";
            String ageParam = "person[" + i + "][age]";

            String nameValue = request.getParameter(nameParam);
            String ageValue = request.getParameter(ageParam);

            if (nameValue == null && ageValue == null) {
                break; // No more parameters found, exit loop
            }

            Person person = new Person(nameValue, Integer.parseInt(ageValue));
            people.put(i, person);
        }

        // Now you can process the 'people' map as needed
        response.getWriter().println("Received " + people.size() + " persons.");
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters omitted for brevity

    public static void main(String[] args) {
    }
}