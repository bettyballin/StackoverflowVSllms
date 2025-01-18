import java.util.List;
import java.util.ArrayList;

public class CustomReturnType {
    private String message;
    private List<Object> data;

    // Constructor
    public CustomReturnType(String message, List<Object> data) {
        this.message = message;
        this.data = data;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public List<Object> getData() {
        return data;
    }

    // Setters
    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    // Then you can do this:
    public static CustomReturnType myFunc() {
        // Your implementation here...
        String message = "Your message";
        List<Object> data = new ArrayList<>();
        // Populate 'data' as needed

        return new CustomReturnType(message, data);
    }
}