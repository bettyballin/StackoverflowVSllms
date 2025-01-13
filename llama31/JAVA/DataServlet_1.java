import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

// Java Servlet
@WebServlet("/data")
public class DataServlet_1_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve data from Java process
        Data data = fetchDataFromJavaProcess();
        
        // Serialize data to JSON using Jackson
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(data);
        
        // Set response content type to JSON
        resp.setContentType("application/json");
        
        // Write JSON data to response output stream
        resp.getWriter().write(json);
    }
    
    private Data fetchDataFromJavaProcess() {
        // Replace with your Java process to retrieve data
        Data data = new Data();
        data.setName("John Doe");
        data.setAge(30);
        return data;
    }
}

// Data class
public class Data {
    private String name;
    private int age;
    
    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public static void main(String[] args) {
    }
}