enum Parameter {
    CTITLE("NAME", "T", 0xAAB),
    // Add more parameters here...
    FOO("FOO", "T", 0xABC);

    private final String name;
    private final String type;
    private final int value;

    Parameter(String name, String type, int value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}

public class Connector {
    public static <T> void getParameter(Parameter param, T otherParam) {
        // Use param.getValue(), param.getName(), and param.getType() as needed
        System.out.println("Getting parameter: " + param.getName());
        // Logic to get the parameter from library using param
    }

    public static void main(String[] args) {
        Connector.getParameter(Parameter.CTITLE, null);
    }
}