import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import java.io.StringWriter;

public class Main_109 {
    public static void main(String[] args) {
        // Initialize the Velocity engine
        VelocityEngine ve = new VelocityEngine();
        ve.init();

        // Load the template
        Template template = ve.getTemplate("email.vm");

        // Create a context and add data
        VelocityContext context = new VelocityContext();
        context.put("name", "John");
        context.put("message", "Hello, this is a test email");

        // Render the template
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        // Send the email
        String emailContent = writer.toString();
        System.out.println(emailContent);
    }
}