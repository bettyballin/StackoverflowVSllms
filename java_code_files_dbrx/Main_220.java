import java.util.*;

public class Main {
    public String method() {
        Map<String, Object> model = new HashMap<String, Object>(); // Or a standard Model(Object[]) object.
        model.put("errors", "example error");
        return "login"; // This should match the view name you've mapped in config file for this request.
    }

    public static void main(String[] args) {
        Main main = new Main();
        String result = main.method();
        System.out.println("Returned: " + result);
    }
}