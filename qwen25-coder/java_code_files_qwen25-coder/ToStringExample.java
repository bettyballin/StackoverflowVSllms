import java.lang.String;
public class ToStringExample {
    static Object someObject = new Object();
    static String s = someObject.toString();

    static {
        System.out.println(s);
    }

    public static void main(String[] args) {
    }
}