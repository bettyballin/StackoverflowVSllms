import java.lang.String;

public class HibernateExampleClass {
    public static void main(String[] args) {
        Session session = new Session();
        Object userId = "validId";
        
        // Using session.get()
        User userGet = (User) session.get(User.class, userId);
        if (userGet != null) {
            System.out.println(userGet.getName());
        }
    
        // Using session.load()
        try {
            User userLoad = (User) session.load(User.class, userId);
            // No database hit here
            System.out.println(userLoad.getName()); // Database hit here if name is not in the cache
        } catch (ObjectNotFoundException e) {
            System.out.println("User not found");
        }
    }
}

class User {
    private String name;
    public User(String name) { this.name = name; }
    public String getName() { return name; }
}

class Session {
    public Object get(Class<?> clazz, Object id) {
        // Simulate fetching from database
        if ("validId".equals(id)) {
            return new User("John Doe");
        } else {
            return null;
        }
    }

    public Object load(Class<?> clazz, Object id) throws ObjectNotFoundException {
        // Simulate lazy loading
        if ("validId".equals(id)) {
            return new User("John Doe");
        } else {
            throw new ObjectNotFoundException("User not found");
        }
    }
}

class ObjectNotFoundException extends Exception {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}