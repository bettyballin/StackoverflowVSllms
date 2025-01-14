import java.util.Arrays;
import java.util.List;

public class Main_65 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "World", "This", "Is", "Java");
        String result = String.join(",", list);
        System.out.println(result); // Outputs: Hello,World,This,Is,Java
    }
}