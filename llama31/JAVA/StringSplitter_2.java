import java.lang.String;

public class StringSplitter_2_2 {
    String[] parts;

    public StringSplitter_2() {
        parts = split("hello,world,j2me", ',');
    }

    public static String[] split(String str, char delimiter) {
        String[] parts = str.split(String.valueOf(delimiter));
        return parts;
    }

    public static void main(String[] args) {
        StringSplitter_2 splitter = new StringSplitter_2();
        for (String part : splitter.parts) {
            System.out.println(part);
        }
    }
}