import java.lang.reflect.Field;

public class HibernateDirtyCheckingExample {
    public static void main(String[] args) {
        // Your code should be inside a method, not directly in the class
        HibernateDirtyCheckingExample example = new HibernateDirtyCheckingExample();
        example.runExample();
    }

    public void runExample() {
        // Assuming we have an entity class 'User' with a 'name' field
        // You need to initialize or inject the session
        // Here I assume you are using Hibernate and have a session factory
        SessionFactory sessionFactory = // Initialize or inject your session factory;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        User user = session.load(User.class, 1L); // Load a user from the database

        // Modify the user's name through the setter method
        user.setName("New Name"); // The proxy interceptor will mark the object as dirty

        // Modify the user's name directly using reflection
        try {
            Field nameField = User.class.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(user, "New Name"); // Hibernate will detect this change during field-level dirty checking
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // Handle the exception
        }

        // During flushing, Hibernate will update the database with the new name
        session.flush();
        session.getTransaction().commit();
        session.close();
    }
}