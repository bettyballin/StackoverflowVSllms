import java.util.HashMap;
import java.util.Map;

public class FunctionMapper {
    private Map<String, Runnable> lookup = new HashMap<>();

    public FunctionMapper() {
        lookup.put("function1", this::function1);
        lookup.put("function2", this::function2);
        lookup.put("function3", this::function3);
    }

    public void callFunction(String input) {
        lookup.get(input).run();
    }

    private void function1() {
        System.out.println("Function 1 called");
    }

    private void function2() {
        System.out.println("Function 2 called");
    }

    private void function3() {
        System.out.println("Function 3 called");
    }

    public static void main(String[] args) {
        FunctionMapper mapper = new FunctionMapper();
        mapper.callFunction("function1");
    }
}