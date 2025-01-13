/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class FunctionMapper {
    private Map<String, Runnable> lookup = new HashMap<String, Runnable>();

    public FunctionMapper() {
        this.lookup.put("function1", this::function1);
        this.lookup.put("function2", this::function2);
        this.lookup.put("function3", this::function3);
    }

    public void callFunction(String string) {
        this.lookup.get(string).run();
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

    public static void main(String[] stringArray) {
        FunctionMapper functionMapper = new FunctionMapper();
        functionMapper.callFunction("function1");
    }
}
