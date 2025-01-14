import java.util.List;
import java.util.ArrayList;

public class UserDao {
    public static void main(String[] args) {
        // Assuming you have an EntityManager em
        EntityManager em = new EntityManager();

        String jpql = "SELECT u.name, u.contacts FROM User u WHERE u.xyz = :param1";
        Object yourParamValue = null; // Placeholder for your parameter value

        List<Object[]> results = em.createQuery(jpql)
                                  .setParameter("param1", yourParamValue)
                                  .getResultList();

        List<UserDto> userDtos = new ArrayList<>();
        for (Object[] result : results) {
            String name = (String) result[0];
            List<Contacts> contacts = (List<Contacts>) result[1];
            userDtos.add(new UserDto(name, contacts));
        }
    }
}

// Mock implementation of EntityManager and Query for compilation purposes
class EntityManager {
    public Query createQuery(String jpql) {
        return new Query();
    }
}

class Query {
    public Query setParameter(String name, Object value) {
        return this;
    }

    public List<Object[]> getResultList() {
        // Return an empty list for compilation purposes
        return new ArrayList<>();
    }
}

class UserDto {
    private String name;
    private List<Contacts> contacts;

    public UserDto(String name, List<Contacts> contacts) {
        this.name = name;
        this.contacts = contacts;
    }
}

class Contacts {
    // Placeholder class
}