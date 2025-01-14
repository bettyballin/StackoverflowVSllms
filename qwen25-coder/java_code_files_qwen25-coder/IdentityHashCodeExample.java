import java.lang.String;
public class IdentityHashCodeExample {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        int hashCode1 = System.identityHashCode(obj1);
        int hashCode2 = System.identityHashCode(obj2);

        System.out.println("Identity hash code for obj1: " + hashCode1);
        System.out.println("Identity hash code for obj2: " + hashCode2);
    }
}