import java.lang.String;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class EntityRetriever {
    public static void main(String[] args) {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query query = new Query("MyEntity");
        PreparedQuery preparedQuery = datastore.prepare(query);
        Iterable<Entity> entities = preparedQuery.asIterable();

        for (Entity entity : entities) {
            // Print or display the entity data
            System.out.println(entity.getKey());
            System.out.println(entity.getProperty("name"));
        }
    }
}