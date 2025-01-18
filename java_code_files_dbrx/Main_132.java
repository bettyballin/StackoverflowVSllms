import java.util.*;

public class Main {
    public static <T> List<T> createEmptyList() {
        return new ArrayList<T>();
    }

    public static void main(String[] args) {
        Object myObject = Main.<Integer>createEmptyList();
    }
}