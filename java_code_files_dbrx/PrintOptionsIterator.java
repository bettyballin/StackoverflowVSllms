import java.lang.String;
public class PrintOptionsIterator {
    static Object[] option = {"Option1", "Option2", "Option3"};
    static java.io.PrintStream out = System.out;

    static {
        for (Object o : option) {
            out.print(o); // or a more appropriate way of converting/displaying objects based on their type
        }
    }

    public static void main(String[] args) {
        // Main method can remain empty or include additional functionality if needed
    }
}