import java.util.List;
import java.util.ArrayList;

public class add {
    // Define AppContactDtl class
    class AppContactDtl {
        private int id;
        public int getId() {
            return id;
        }
    }

    // Define contactsList
    List<AppContactDtl> contactsList = new ArrayList<>();

    // Define EntityManager em
    EntityManager em = new EntityManager();

    // Define EntityManager class with remove and merge methods
    class EntityManager {
        public Object merge(Object obj) {
            return obj;
        }
        public void remove(Object obj) {
            // Implementation here
        }
    }

    // Inside your ApplNotifBean class add this function
    public String removeChild(int deleteId) {
        // Find out which Child should have been removed based on its ID
        for (AppContactDtl child : contactsList) {
            if (child.getId() == deleteId) {
                // Remove the entry from DB through the EntityManager or SessionFactory methods
                em.remove(em.merge(child));
                // ...then remove it from your own List
                contactsList.remove(child);
                break;
            }
        }
        return null;
    }

    public static void main(String[] args) {
    }
}