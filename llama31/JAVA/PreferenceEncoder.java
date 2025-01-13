import java.lang.String;

public class PreferenceEncoder {
    public static void main(String[] args) {
        String[] values = {"value1", "value2", "value3"};
        String encoded = String.join(",", values);

        // Save encoded string to Eclipse preference
        // For demonstration purposes, we'll just print it out
        System.out.println("Encoded string: " + encoded);

        // Later, read and decode the string
        String decoded = encoded; // Replace with preference.getString("key", "");
        String[] decodedValues = decoded.split(",");

        // Print out the decoded values
        System.out.println("Decoded values:");
        for (String value : decodedValues) {
            System.out.println(value);
        }
    }
}