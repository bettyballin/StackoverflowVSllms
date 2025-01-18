import java.lang.String;
public class NullPointerExceptionExample {
    String s = null;
    {
        if(s==null){ // Here, NullPointerException would be caught as 's' is null(not pointing to any object)
        }
    }
    public static void main(String[] args) {
    }
}