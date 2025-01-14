package packageA;

import java.lang.String;

public class Bloo extends Blah {
    public Bloo(String testing) {
        super(testing);
    }

    // You can add a method to access the protected field if you need
    public String getTesting() {
        return this.message;
    }

    public static void main(String[] args) {
    }
}

class Blah {
    protected String message;

    public Blah(String message) {
        this.message = message;
    }
}