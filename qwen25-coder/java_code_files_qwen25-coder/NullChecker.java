public class NullChecker {
    public static boolean anyNull(Object... objects) {
        for (Object obj : objects) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Object a = new Object();
        Object b = null;
        Object c = new Object();
        Object d = new Object();

        if (anyNull(a, b, c, d)) {
            System.out.println("At least one object is null.");
        } else {
            System.out.println("All objects are non-null.");
        }
    }
}