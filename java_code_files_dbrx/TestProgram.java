import javax.naming.NamingException;

public class TestProgram {
    public static void main(String[] args) {
        System.setSecurityManager(new MySecurityManager());
        NamingException ex = new NamingException(); // This will throw SecurityException
    }
}

class MySecurityManager extends SecurityManager {
    // Custom implementation if needed
}