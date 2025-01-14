import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import java.io.StringWriter;

public class EmailGenerator {

    public static void main(String[] args) {
        // Initialize Velocity engine
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        // Load the template file, which should be placed in the templates directory
        Template template = velocityEngine.getTemplate("email-template.vm");

        // Create a context and add data
        VelocityContext context = new VelocityContext();
        context.put("name", "John Doe");
        context.put("content", "Welcome to our service!");

        // Merge data into template
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        // Get the output (email content)
        String emailContent = writer.toString();

        System.out.println(emailContent);
    }
}