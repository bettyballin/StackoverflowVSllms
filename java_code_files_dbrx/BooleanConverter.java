public class BooleanConverter {
    static boolean asBoolean(String value) {
        return "Y".equalsIgnoreCase(value) || Boolean.parseBoolean(value);
    }

    static String fromBoolean(boolean boolValue) {
        return boolValue ? "Y" : "N"; /* or based on your convention */
    }

    public static void main(String[] args) {
    }
}