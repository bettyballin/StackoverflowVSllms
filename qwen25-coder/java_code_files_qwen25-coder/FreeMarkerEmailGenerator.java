import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.StringWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerEmailGenerator {

    public static void main(String[] args) throws IOException, TemplateException {
        // Prepare the FreeMarker configuration
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(FreeMarkerEmailGenerator.class, "/templates");

        // Prepare the data model
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("username", "JohnDoe");

        // Get the template (uses cache internally if set to do so):
        Template template = cfg.getTemplate("email_template.ftl");  // use /templates/email_template.ftl

        // Merge data model with template
        StringWriter out = new StringWriter();
        template.process(dataModel, out);

        System.out.println(out.toString());
    }
}