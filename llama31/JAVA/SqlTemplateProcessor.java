import java.util.Map;
import java.util.HashMap;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

public class SqlTemplateProcessor {

    public static void main(String[] args) throws Exception {
        // Example with FreeMarker
        String sqlTemplate = "SELECT ${columns} FROM ${table} WHERE ${condition}";
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("columns", "...");
        dataModel.put("table", "...");
        dataModel.put("condition", "...");

        Configuration cfg = new Configuration(new Version("2.3.29"));
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setDefaultEncoding("UTF-8");

        Template template = new Template("sqlTemplate", sqlTemplate, cfg);
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        template.process(dataModel, stringWriter);
        String sqlQuery = stringWriter.toString();
        System.out.println(sqlQuery);
    }
}