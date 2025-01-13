import java.lang.String;

public class StringCaster {
    Object obj = "Hello";
    String str = (String) obj;

    public static void main(String[] args) {
        StringCaster caster = new StringCaster();
        System.out.println(caster.str);
    }
}