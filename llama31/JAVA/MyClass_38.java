import java.lang.String;
import org.apache.log4j.Logger;

public class MyClass_38_38 {
    private static final Logger logger = Logger.getLogger(MyClass_38.class);

    public void myMethod() {
        logger.debug("This is a debug message");
    }

	public static void main(String[] args) {
		MyClass_38 obj = new MyClass_38();
		obj.myMethod();
	}
}