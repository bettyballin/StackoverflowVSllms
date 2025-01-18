public class UserDAOorHibernateUserAccessor {

    Session session;
    User user;

    {
        session = HibernateUtil.getSessionFactory().openSession();
        user = session.load(User.class, 5); // Get a user with id equal to 5
        session.close();
    }

    public static void main(String[] args) {
    }
}