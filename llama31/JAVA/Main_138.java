import java.sql.*;
import java.util.Vector;

public class Main_138 {
    private static String var1 = "something";
    private static ObjectXXX var2 = null;

    public static void initObjectXXX() {
        var2 = new ObjectXXX();
    }

    public static void main(String[] args) {
        initObjectXXX();
        System.out.println(var1);
        System.out.println(var2);
    }
}

class ObjectXXX {
    // Define the ObjectXXX class
    public ObjectXXX() {
        System.out.println("ObjectXXX initialized");
    }
}