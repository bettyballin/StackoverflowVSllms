class LocalSessionFactoryBean {
    public void addAnnotatedClass(Class<?> annotatedClass) {
        // Method implementation
    }
}

class LdapUser {
    // LdapUser class definition
}

public class Main {
    public static void main(String[] args) {
        // Get your LocalSessionFactoryBean
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.addAnnotatedClass(LdapUser.class);
    }
}