import java.lang.String;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

public class MyTagModel implements TemplateModel {
    @Override
    public Object getAsString() throws TemplateModelException {
        // implement the logic of your JSP tag here
        return "Hello, World!";
    }

    public static void main(String[] args) {
        MyTagModel model = new MyTagModel();
        try {
            System.out.println(model.getAsString());
        } catch (TemplateModelException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}