/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main_423 {
    public static void main(String[] stringArray) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        Pattern pattern = Pattern.compile("hello");
        List list2 = list.stream().filter(pattern.asPredicate()).collect(Collectors.toList());
        String string2 = "SELECT * FROM table WHERE column IN (" + list2.stream().map(String::valueOf).map(string -> "'" + string.replace("'", "''") + "'").collect(Collectors.joining(", ")) + ")";
        System.out.println(string2);
    }
}
