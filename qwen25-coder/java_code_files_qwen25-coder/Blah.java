package packageA;
import java.lang.String;

public class Blah {
    protected String message;

    public Blah(String msg) {
        this.message = msg;
    }

    protected String getMessage(){
        return this.message;
    }   

    public static void main(String[] args) {
    }
}