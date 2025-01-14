import java.lang.String;
import java.io.IOException;

// Minimal stub for JspException
class JspException extends Exception {
}

// Minimal stub for SimpleTagSupport
class SimpleTagSupport {
    public void doTag() throws JspException, IOException {
        // default implementation
    }
}

public class ThrowExceptionTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        throw new RuntimeException("Custom Exception from Tag");
    }
  
    public static void main(String[] args) {
    }
}