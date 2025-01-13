import java.util.HashMap;
import java.util.Map;

public class EmailSender_3_3 {
  public void sendEmail(String department, String comment, String sender) {
    // Load the HTML template
    String template = loadTemplate("email-template.html");

    // Create a data model for the template
    Map<String, String> data = new HashMap<>();
    data.put("department", department);
    data.put("comment", comment);
    data.put("sender", sender);

    // Render the template with the data model
    String html = renderTemplate(template, data);

    // Send the HTML email
    sendHtmlEmail(html);
  }

  // Implement the loadTemplate method
  private String loadTemplate(String filename) {
    // For simplicity, assume the template is a string
    return "<html><body>Department: ${department}<br>Comment: ${comment}<br>Sender: ${sender}</body></html>";
  }

  // Implement the renderTemplate method
  private String renderTemplate(String template, Map<String, String> data) {
    for (Map.Entry<String, String> entry : data.entrySet()) {
      template = template.replace("${" + entry.getKey() + "}", entry.getValue());
    }
    return template;
  }

  // Implement the sendHtmlEmail method
  private void sendHtmlEmail(String html) {
    // For simplicity, print the HTML email to the console
    System.out.println(html);
  }

  public static void main(String[] args) {
    EmailSender_3 emailSender = new EmailSender_3();
    emailSender.sendEmail("Sales", "This is a test comment", "John Doe");
  }
}