import java.lang.String;
public class Main_124 {
    public static void main(String[] args) {
        int Number = -5; // change this value
        System.out.println((Number >>> 31) + (~(Number >>> 31) & ~0));
    }
}