import java.util.List;
import org.simpleframework.xml.*;

public class Node_1 {
    @Root(name = "node")
    class Node {
        @TextList(inline = true)
        List<String> texts;

        @ElementList(entry="child", inline=true, type = String.class)
        List<String> children;
    }

    public static void main(String[] args) {
    }
}