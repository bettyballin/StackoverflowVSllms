// Blah.java
package com.example;

public class Blah {
    protected String message;

    public Blah(String msg) {
        this.message = msg;
    }

    public String getMessage(){
        return this.message;
    }   
}

// Bloo.java
package com.example;

public class Bloo extends Blah {
    public Bloo(String testing) {
        super(testing);
    }
}

// TestBlah.java
package com.test;

import com.example.Blah;
import com.example.Bloo;

public class TestBlah {
    public static void main(String[] args) {
        Blah a = new Blah("Blah");
        Bloo b = new Bloo("Bloo");
        System.out.println(a.getMessage());
        System.out.println(b.getMessage());
    }
}