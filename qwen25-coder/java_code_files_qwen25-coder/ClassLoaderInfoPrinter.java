import java.lang.String;
import java.lang.Integer;

public class ClassLoaderInfoPrinter {
    static ClassLoader cl = SomeClass.class.getClassLoader();
    
    static {
        System.out.println("ClassLoader for " + SomeClass.class + ": " + cl + ", Address: " + Integer.toHexString(System.identityHashCode(cl)));
    }
    
    public static void main(String[] args) {
    }
}

class SomeClass {
    // Empty class definition
}