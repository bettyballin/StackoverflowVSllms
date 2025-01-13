public class UtilityMethodsorNullChecker {
    public static boolean anyNull(Object... args) {
        for (Object arg : args) {
            if (arg == null) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
    }
}