import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import java.io.StringWriter;

public class VelocityEngineExample {
    public static void main(String[] args) throws Exception {
        // Initialize Velocity Engine
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        // Load Template from file
        Template template = velocityEngine.getTemplate("template.vm");

        // Create context and add data
        VelocityContext context = new VelocityContext();
        context.put("name", "World");

        // Merge data with template and generate output string
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        // Output the result
        System.out.println(writer.toString());
    }
}