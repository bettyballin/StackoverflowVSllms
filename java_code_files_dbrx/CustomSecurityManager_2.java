import java.lang.String;
// Create a custom SecurityManager extending java.lang.SecurityManager
public class CustomSecurityManager_2 extends java.lang.SecurityManager {
    private final String packageName;
    public CustomSecurityManager_2(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public void checkPackageAccess(String pkg) {
        if (!pkg.equals(this.packageName)) {
            throw new SecurityException("No access to packages other than: " + this.packageName);
        }
    }
}

// Initialize custom security manager with your package name and call setSecurityManager() method of the System class in main() or static block
public class MainClass {
  public static void main(String[] args){
      System.setSecurityManager( new CustomSecurityManager_2("your_package_name") ) ;

      // Your other code here ...
   }
}