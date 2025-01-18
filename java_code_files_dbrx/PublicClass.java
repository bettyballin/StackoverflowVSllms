import java.lang.String;
// Public members are accessible from any class.
public class PublicClass {
    public int publicField;

    // Package-private (default) members are only visible inside the same package.
    int defaultPackagePrivateField;

    // Protected members can be accessed by classes within the same package and subclasses outside of that package.
    protected class ProtectedClass {
        protected int protectedField;
    }

    // Private members are only allowed to used in their own declared entity (class, method).
    private static class PrivateClass {
        private void privMethod() {}

        public static void main(String[] args) {
        }
    }
}