import java.lang.Integer;
import java.lang.String;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.propertyeditors.CustomEditorConfigurer;

public class EditorRegistrar {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Integer.class, new IntegerPropertyEditor());
    }
    public static void main(String[] args) {
    }
}