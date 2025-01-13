import javax.servlet.http.HttpServletRequest;

// Define the DecoratorMapper interface
interface DecoratorMapper {
    String getDecorator(HttpServletRequest request);
}

public class CustomDecoratorMapper implements DecoratorMapper {
    @Override
    public String getDecorator(HttpServletRequest request) {
        String decorator = (String) request.getAttribute("decorator");
        if (decorator != null) {
            return decorator;
        }
        return null;
    }

    public static void main(String[] args) {
        // For testing purposes, you might want to create an instance of your class here
        CustomDecoratorMapper mapper = new CustomDecoratorMapper();
        // To actually test getDecorator, you'd need to mock or obtain a HttpServletRequest instance
        // For simplicity, that's omitted here
    }
}