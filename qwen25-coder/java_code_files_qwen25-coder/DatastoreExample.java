import java.util.ArrayList;
import java.util.List;
import com.google.cloud.datastore.*;

public class DatastoreExample {
    private final Datastore datastore;

    public DatastoreExample(Datastore datastore) {
        this.datastore = datastore;
    }

    // Creating a User entity
    public Key createUser(String name, String email) {
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("User");
        Key userKey = datastore.allocateId(keyFactory.newKey());
        Entity user = Entity.newBuilder(userKey)
                .set("name", name)
                .set("email", email)
                .build();
        datastore.put(user);
        return userKey;
    }

    // Creating a Message entity with a reference to User
    public void createMessage(Key userKey, String messageText) {
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Message");
        Key messageKey = datastore.allocateId(keyFactory.newKey());
        Entity message = Entity.newBuilder(messageKey)
                .set("text", messageText)
                .set("author", userKey) // Storing a reference to the user
                .build();
        datastore.put(message);
    }

    // Fetching messages for a specific user
    public List<Entity> getMessagesForUser(Key userKey) {
        Query<Entity> query = Query.newEntityQueryBuilder()
                .setKind("Message")
                .setFilter(StructuredQuery.PropertyFilter.eq("author", userKey))
                .setLimit(100)
                .build();

        QueryResults<Entity> results = datastore.run(query);
        List<Entity> messages = new ArrayList<>();
        while (results.hasNext()) {
            messages.add(results.next());
        }
        return messages;
    }

    public static void main(String[] args) {
        // Example usage (requires Datastore instance):
        // Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        // DatastoreExample example = new DatastoreExample(datastore);
        // Key userKey = example.createUser("Alice", "alice@example.com");
        // example.createMessage(userKey, "Hello, world!");
        // List<Entity> messages = example.getMessagesForUser(userKey);
    }
}