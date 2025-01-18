import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

// Simulated classes for HttpServletRequest and HttpServletResponse
class HttpServletRequest {}
class HttpServletResponse {
    public java.io.PrintWriter getWriter() {
        return new java.io.PrintWriter(System.out);
    }
}

// Simulated ObjectMapper from Jackson library
class ObjectMapper {
    public String writeValueAsString(Object obj) {
        return obj.toString();
    }
}

// Simulated MyModel class
class MyModel {
    @Override
    public String toString() {
        return "MyModel{}";
    }
}

public class JsonModelDispatcher {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Create a list of model objects
        List<MyModel> models = getAllModels();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(models);
        response.getWriter().print(jsonString);
    }

    public List<MyModel> getAllModels() {
        // Dummy implementation returning a list with one MyModel instance
        List<MyModel> models = new ArrayList<>();
        models.add(new MyModel());
        return models;
    }

    public static void main(String[] args) {
        // Create instances for testing
        JsonModelDispatcher dispatcher = new JsonModelDispatcher();
        try {
            dispatcher.doGet(new HttpServletRequest(), new HttpServletResponse());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}