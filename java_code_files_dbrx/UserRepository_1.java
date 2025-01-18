import java.lang.String;
// ORM Example using JPA (Java) and LINQ example using C#

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserRepository_1 {

    @PersistenceContext
    EntityManager em; // Injects an EntityManager for managing persistence and queries of entities

    void save(User user) {
        this.em.persist(user); // Saving data through ORM in Java
    }

    public static void main(String[] args) {
    }
}

// Simple User class
class User {
    // User fields and methods
}