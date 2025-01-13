import java.lang.String;

public class ToStringStylerConfigurer {
    ToStringStylerRegistry registry = ToStringStylerRegistry.getInstance();

    public ToStringStylerConfigurer() {
        registry.register(new CustomToStringCreator());
    }

    public static void main(String[] args) {
        new ToStringStylerConfigurer();
    }
}