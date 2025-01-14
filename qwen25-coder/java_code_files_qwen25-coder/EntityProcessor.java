import java.util.List;
import java.util.ArrayList;

public class EntityProcessor {
    public static void main(String[] args) {
        EntityManager em = null; // obtain EntityManager from somewhere...
        List<A> entities = A.getAllEntities(em);
        for (A entity : entities) {
            if (entity instanceof B) {
                B bEntity = (B) entity;
                // Handle B specific fields and logic here.
            } else {
                // Handle A specific logic here.
            }
        }
    }
}

class EntityManager {
    // EntityManager implementation
}

class A {
    public static List<A> getAllEntities(EntityManager em) {
        // Return list of A entities
        return new ArrayList<A>();
    }
}

class B extends A {
    // B specific fields and methods
}