// Example code snippet using Hibernate ORM
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    // Other application logic...
  }
}