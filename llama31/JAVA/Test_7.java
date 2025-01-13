import java.lang.String;
public class Test_7 {
    public static void modifyPrimitive(int x) {
        x = 10;
    }

    public static void modifyObject(StringBuilder sb) {
        sb.append(" modified");
    }

    public static void main(String[] args) {
        int myInt = 5;
        modifyPrimitive(myInt);
        System.out.println(myInt);  // prints 5

        StringBuilder mySB = new StringBuilder("Hello");
        modifyObject(mySB);
        System.out.println(mySB.toString());  // prints "Hello modified"
    }
}