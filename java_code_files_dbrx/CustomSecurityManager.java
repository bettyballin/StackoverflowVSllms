import java.lang.String;
public class CustomSecurityManager {
    class MyCustomSecurityManager extends SecurityManager {
        @Override
        public void checkAccess(Thread t) {
            // Do any checks here e.g., check the maximum number of threads,
            // specific types or origins of threads etc.
            super.checkAccess(t);
        }
    }
    public static void main(String[] args) {
    }
}