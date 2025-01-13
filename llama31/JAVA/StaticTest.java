import java.lang.String;
public class StaticTest {
    public static int x = 10;

    public static void main(String[] args) {
        System.out.println(x);
        x = 20;
        System.out.println(x);
    }
}