import java.util.function.Consumer;
import java.util.Objects;

public class ViewRenderer {
    public Consumer<String> newMethod() {
        Post post = new Post();
        return format -> {
            if (Objects.equals("html", format)) {
                // render html view
            } else if (Objects.equals("xml", format)) {
                // render xml view
            }
        };
    }

    public static void main(String[] args) {
    }
}

class Post {
    // Empty class definition
}