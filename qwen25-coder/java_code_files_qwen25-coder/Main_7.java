// File: com/library1/LibraryClass.java
package com.library1;

public class LibraryClass {
    public static void function() {
        // Implementation of the function from library 1
        System.out.println("LibraryClass function called");
    }
}

// File: com/library2/AnotherLibraryClass.java
package com.library2;

public class AnotherLibraryClass {
    public static void function() {
        // Implementation of the function from library 2
        System.out.println("AnotherLibraryClass function called");
    }
}

// File: Main_7.java
import java.lang.String;
import com.library1.LibraryClass;
import com.library2.AnotherLibraryClass;

public class Main_7 {
    public static void main(String[] args) {
        LibraryClass.function(); // Calls the function from library 1
        AnotherLibraryClass.function(); // Calls the function from library 2
    }
}