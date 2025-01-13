import java.util.List;

public interface Result {
    List<String> getList();
    String getString();
}

class MyFunctionResult implements Result {
    private List<String> list;
    private String string;

    public MyFunctionResult(List<String> list, String string) {
        this.list = list;
        this.string = string;
    }

    @Override
    public List<String> getList() {
        return list;
    }

    @Override
    public String getString() {
        return string;
    }
}

public class Main {
    public static Result myFunction() {
        // ...
        List<String> list = null; // Initialize list
        String string = null; // Initialize string
        return new MyFunctionResult(list, string);
    }

    public static void main(String[] args) {
        myFunction();
    }
}