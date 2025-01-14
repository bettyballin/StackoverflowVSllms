import java.util.List;
import java.util.Arrays;

public class ResponseDataAccessor {
    public Object[] getData() {
        List<String> lst = Arrays.asList("element1", "element2");
        String msg = "success";
        return new Object[]{lst, msg};
    }

    public static void main(String[] args) {
    }
}