import java.lang.String;

public class StringSplitter {
    public static void main(String[] args) {
        String str = "Hello,World\\,This,Is,A,Test";
        String[] array = str.split("(?<!\\\\),");
        for (String s : array) {
            System.out.println(s);
        }
    }
}