// ServiceLayerr1.java

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Transactional {
    String value() default "";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Service {
}

@Transactional("txManager1") // use txManager1 based transaction management
@Service
public class ServiceLayerr1 {
    // Class implementation goes here
}