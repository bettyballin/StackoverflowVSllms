import java.util.List;
import java.util.ArrayList;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EmployeeService {
    private static final String API_URL = "http://www.business.com/Employees";

    public List<Employee> getEmployees(String accessKey, boolean allDepartments) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(API_URL + "?allDepartments=" + Boolean.toString(allDepartments)))
            .header("Authorization", "Bearer " + accessKey)
            .GET() // Specify the GET method
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Process the response and convert it to List<Employee>
        return parseEmployees(response.body());
    }

    private List<Employee> parseEmployees(String responseBody) {
        // Implement parsing logic here
        return new ArrayList<>();
    }

    public static void main(String[] args) {
    }
}

class Employee {
    // Minimal Employee class
}