package packageB;

import packageA.Blah;
import packageA.Bloo;

public class TestBlah {

    public static void main(String[] args) {
        Blah a = new Blah("Blah");
        Bloo b = new Bloo("Bloo");

        // Correctly accessing protected method and field
        System.out.println(a.getMessage());
        // System.out.println(a.testing); // This will not work as 'testing' is protected and TestBlah is in another package.

        // Direct access not allowed, need to use a public method
        System.out.println(b.getMessage());
        // System.out.println(b.testing); // This will not compile because 'testing' is not accessible directly here.
        
        // Accessing protected field via accessor method within subclass
        // Assuming you added getTesting() in Bloo.java
        System.out.println(b.getTesting()); // Works! Via public method of subclass
    }
}