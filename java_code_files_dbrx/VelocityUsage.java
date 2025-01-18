import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import java.io.StringWriter;

public class VelocityUsage {
    public void generateHtmlPage() throws Exception {
        // Initialize the engine with default config (no need to create properties file)
        final VelocityEngine ve = new VelocityEngine();
        ve.setProperty("resource.loader", "file");
        ve.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        ve.setProperty("file.resource.loader.path", "templates"); // set path where templates are saved
        ve.init(); // initializes velocity
        // Create the context and add data
        final VelocityContext ctx = new VelocityContext();
        ctx.put("name", "Velocity template engine"); // use data in a template
        // Get and render our template
        final Template template = ve.getTemplate("my-template.html.vm"); // get the templatedata from a file
        final StringWriter writer = new StringWriter(); // can be used to read directly into a stream as well
        template.merge(ctx, writer); // merge replaces variables in the template with real data and creates output
        // Now use HTML
        System.out.println("Result: " + writer.toString()); // print out result onto console or save it to file
    }

    public static void main(String[] args) throws Exception {
        new VelocityUsage().generateHtmlPage();
    }
}