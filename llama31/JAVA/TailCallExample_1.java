import java.lang.String;
public class TailCallExample_1 {
    public static void main(String[] args) {
        recursiveMethod(10);
    }

    public static void recursiveMethod(int i) {
        if (i == 0) {
            return;
        }
        recursiveMethod(i - 1); // This is a tail call
    }
}