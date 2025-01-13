import java.lang.String;
import org.directwebremoting.convert.AbstractConverter;

public class CustomConverter extends AbstractConverter {
    @Override
    public String toJavascript(Object obj, String varName) {
        // Assuming 'obj' is an instance of your Java class
        String jsClassName = "my.beautiful.package.MyClass";
        return "new " + jsClassName + "(" + varName + ")";
    }

    public static void main(String[] args) {
    }
}