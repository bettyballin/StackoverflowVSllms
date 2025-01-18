import java.util.List;

@Root(name = "profile")
public class Profile {
    @Element(required = false)
    private String name;

    @Attribute(empty = "", required = false)
    @Convert(value = LanguageConverter.class)
    private List<String> langs;
}

@interface Root {
    String name();
}

@interface Element {
    boolean required() default true;
}

@interface Attribute {
    String empty() default "";
    boolean required() default true;
}

@interface Convert {
    Class<?> value();
}

class LanguageConverter {
    // Empty implementation
}