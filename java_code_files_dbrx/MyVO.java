import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface WebService {
}

@Retention(RetentionPolicy.RUNTIME)
@interface WebMethod {
    String operationName() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@interface WebParam {
    String name() default "";
}

@WebService()
public class MyVO {
    @WebMethod(operationName = "operation")
    public YourResult operation(@WebParam(name="param") String param) {
        // Method implementation
        return null;
    }
}

class YourResult {
    // YourResult class implementation
}