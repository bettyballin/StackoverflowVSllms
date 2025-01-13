import java.lang.String;
public class Main_509 {
    public static void main(String[] args) {
        System.out.println("RunFoo.py".matches("^Run.*\\.py$"));  // prints: true
        System.out.println("myRunFoo.py".matches("^Run.*\\.py$"));  // prints: false
        System.out.println("RunBar.py1".matches("^Run.*\\.py$"));  // prints: false
        System.out.println("Run42.txt".matches("^Run.*\\.py$"));  // prints: false
    }
}