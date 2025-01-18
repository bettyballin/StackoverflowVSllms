import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        String[] str = {"element1", "element2", "element3"};
        int size = str.length;

        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; ++i) {
            joiner.add(str[i]);
        }
        System.out.println(joiner); // prints: [element1, element2, element3]
    }
}