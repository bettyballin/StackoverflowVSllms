import java.util.Arrays;
import java.util.List;

public class MyBean_1 {
    private List<String> tagList = Arrays.asList("TAG1", "TAG2", "TAG3");

    public String getTagListAsString() {
        return String.join(", ", tagList);
    }

    public static void main(String[] args) {
        MyBean_1 myBean = new MyBean_1();
        System.out.println(myBean.getTagListAsString());
    }
}