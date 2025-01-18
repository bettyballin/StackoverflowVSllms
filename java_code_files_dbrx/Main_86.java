// Main.java
import java.util.List;
import x.y.UserDto;

public class Main {
    public static void main(String[] args) {
        // Assuming 'session' is an instance of a class that provides the 'createQuery' method
        Session session = new Session();
        String paramValue = "someValue"; // Set your parameter value here

        List<UserDto> dtos = session.createQuery(
                "SELECT new x.y.UserDto(u.name, u.contacts) FROM User u WHERE u.xyz=:param1",
                UserDto.class)
                .setParameter("param1", paramValue)
                .getResultList();

        // You can add code here to work with 'dtos' if needed
    }
}

// Mock classes to simulate the required functionality
class Session {
    public <T> Query<T> createQuery(String hql, Class<T> clazz) {
        return new Query<>();
    }
}

class Query<T> {
    public Query<T> setParameter(String name, Object value) {
        // Set the parameter for the query
        return this;
    }

    public List<T> getResultList() {
        // Execute the query and return the results
        return null; // Return an appropriate list based on your context
    }
}