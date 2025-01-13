public class ParameterEnum {
    // Parameter.java (enum)
    public enum Parameter {
        CTITLE("CTITLE", "T", 0xAAB);
        // ... (all 6000 parameters)

        private final String name;
        private final String type;
        private final int value;

        Parameter(String name, String type, int value) {
            this.name = name;
            this.type = type;
            this.value = value;
        }
    }

    public static void main(String[] args) {
    }
}