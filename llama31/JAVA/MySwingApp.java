import org.hibernate.Session;
import org.hibernate.HibernateUtil;

public class MySwingApp {
    public void doSomeDatabaseWork() {
        Session session = HibernateUtil.getSession();
        // do some database work using the session
        HibernateUtil.closeSession();
    }

    public static void main(String[] args) {
        MySwingApp app = new MySwingApp();
        app.doSomeDatabaseWork();
    }
}