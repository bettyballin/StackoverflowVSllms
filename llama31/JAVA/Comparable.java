// Removed the redundant import statement
public class CustomComparable {
    // Renamed the interface to avoid conflict with java.lang.Comparable
    public interface CustomComparable<T> {
        int compareTo(T o);
    }
    
    public static void main(String[] args) {
    }
}