import java.lang.String;

public class EnumMatcher {
    enum A {
        B,
        C,
        D
    }

    public static void main(String[] args) {
        String str = "C";
        A enumValue = A.valueOf(str);
        if (enumValue == A.C) {
            System.out.println("Match!");
        }
    }
}