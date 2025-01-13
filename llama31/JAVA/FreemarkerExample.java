import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import javax.servlet.ServletContext;
import java.io.Writer;

public class FreemarkerExample {
    public void setupFreemarker(ServletContext servletContext, Object dataModel, Writer writer) throws Exception {
        // Set up FreeMarker configuration
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setServletContextForTemplateLoading(servletContext, "WEB-INF/templates");

        // Use a template
        Template template = cfg.getTemplate("mytemplate.ftl");
        template.process(dataModel, writer);
    }

    public static void main(String[] args) throws Exception {
        // Create an instance of FreemarkerExample
        FreemarkerExample example = new FreemarkerExample();
        
        // Assume you have a ServletContext and Writer instance
        ServletContext servletContext = null; // Replace with your ServletContext instance
        Object dataModel = null; // Replace with your data model
        Writer writer = null; // Replace with your Writer instance
        
        // Call the setupFreemarker method
        example.setupFreemarker(servletContext, dataModel, writer);
    }
}