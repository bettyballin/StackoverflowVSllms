import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseDaoImpl {

    public void deleteCourse(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Course courseToDelete = (Course) session.load(Course.class, id);
            if (null != courseToDelete) {
                session.delete(courseToDelete);
            }
            tx.commit();
        } catch (HibernateException asd) {
            // rollback
            throw new RuntimeException("Error saving user", asd);
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        // Optionally, create an instance and call deleteCourse
        // CourseDaoImpl dao = new CourseDaoImpl();
        // dao.deleteCourse(1); // sample id = 1
    }
}