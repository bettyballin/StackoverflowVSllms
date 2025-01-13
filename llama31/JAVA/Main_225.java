import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class Main_225 {
    public static void main(String[] args) throws IOException {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        Template template = ve.getTemplate("template.vm");

        VelocityContext context = new VelocityContext();
        context.put("bean", new Bean("some value")); // define the bean object

        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        System.out.println(writer.toString());
    }
}

class Bean {
    private String value;

    public Bean(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}