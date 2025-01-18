import java.util.Set;
import java.util.HashSet;
import java.security.Permission;

public class MySecurityManager extends SecurityManager {
    private Set<String> blacklistedMethods = new HashSet<>();

    public void addBlacklistedMethod(String methodName) {
        blacklistedMethods.add(methodName);
    }

    @Override
    public void checkPermission(Permission perm) {
        if (blacklistedMethods.contains(perm.getName())) { // or other condition based on the Permission object
            throw new SecurityException("Access denied to method: " + perm.getName());
        } else {
            super.checkPermission(perm);
        }
    }

    public static void main(String[] args) {
    }
}