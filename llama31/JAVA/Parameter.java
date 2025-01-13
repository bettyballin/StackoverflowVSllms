import java.lang.String;

// Define a generic class Parameter
class Parameter<T> {
    private String name;
    private String type;
    private int code;

    public Parameter(String name, String type, int code) {
        this.name = name;
        this.type = type;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCode() {
        return code;
    }
}

// Parameter.java (contains a subset of parameters)
class ParameterClass {
    public static final Parameter<String> CTITLE = new Parameter<>("CTITLE", "T", 0xAAB);
    // ... (e.g., 1000 parameters)
}

// Parameter2.java (contains another subset of parameters)
class Parameter2 {
    public static final Parameter<String> parameter1001 = new Parameter<>("PARAM1001", "T", 0xBBB);
    // ... (e.g., another 1000 parameters)
}

public class Main {
    public static void main(String[] args) {
        System.out.println(ParameterClass.CTITLE.getName());
        System.out.println(Parameter2.parameter1001.getName());
    }
}