import java.lang.String;
@FunctionalInterface
interface FormatHandler {
    void handle(String format);
}

public class Example_2 {
    public static void respondTo(FormatHandler handler) {
        String format = "html"; // or "xml"
        handler.handle(format);
    }

    public static void main(String[] args) {
        respondTo(format -> {
            if ("html".equals(format)) {
                // new.html.java logic here
            } else if ("xml".equals(format)) {
                // render XML logic here
            }
        });
    }
}