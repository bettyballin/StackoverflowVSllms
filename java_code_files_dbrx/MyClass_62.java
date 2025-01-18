import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import java.io.StringWriter;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;

public class MyClass {
    public static void main(String[] args) {
        // context map with keys customer and order
        Map<String, Object> context = new HashMap<>();
        context.put("customer", "John Doe");
        context.put("order", "Order #1234");

        // Load a template file called "template" using Velocity
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "classpath");
        properties.setProperty("classpath.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        VelocityEngine velocityEngine = new VelocityEngine(properties);
        VelocityContext velocityContext = new VelocityContext(context);
        StringWriter writer = new StringWriter();
        Template template = velocityEngine.getTemplate("template.vm");
        template.merge(velocityContext, writer);
        System.out.println(writer.toString());  // prints your formatted message
    }
}