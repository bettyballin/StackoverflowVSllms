import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class EmailFormatter {

    public static String formatEmail(List<String> comments) throws Exception {
        StringBuilder emailBuilder = new StringBuilder();
        // Read the template file
        BufferedReader reader = new BufferedReader(new FileReader("email_template.html"));
        String line;
        while ((line = reader.readLine()) != null) {
            // Replace placeholder with actual comments
            if (line.contains("<div class=\"comment-section\" id=\"comments-placeholder\">")) {
                emailBuilder.append(line + "\n");
                for (String comment : comments) {
                    emailBuilder.append("<div class=\"comment\">" + comment + "</div>\n");
                }
            } else {
                emailBuilder.append(line + "\n");
            }
        }
        reader.close();
        return emailBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        // Example comments list
        List<String> comments = List.of(
                "This is the first comment.",
                "Another important point here."
        );

        String formattedEmail = formatEmail(comments);
        System.out.println(formattedEmail);
    }
}