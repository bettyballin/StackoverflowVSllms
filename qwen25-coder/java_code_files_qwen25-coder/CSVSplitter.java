import java.lang.String;
public class CSVSplitter {
    public static void main(String[] args) {
        String csvLine = "abc,bcc,";
        String[] tokens = csvLine.split(",", -1); // The second argument '-1' keeps trailing empty strings

        for (String token : tokens) {
            if (token.isEmpty()) {
                System.out.println("null");
            } else {
                System.out.println(token);
            }
        }
    }
}