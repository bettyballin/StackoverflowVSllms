import java.lang.String;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import java.util.Arrays;

public class MongoDBItemManager {
    public static void main(String[] args) {
        // Create a MongoDB client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Get a database and collection
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("items");

        // Create a document
        Document document = new Document("_id", 1)
                .append("ItemName", "Car")
                .append("ItemPriority", 7)
                .append("Properties", Arrays.asList(
                        new Document("Property", "Blue").append("Importance", 1),
                        new Document("Property", "Four Wheels").append("Importance", 2),
                        new Document("Property", "Sedan").append("Importance", 0)
                ));

        // Insert the document
        collection.insertOne(document);

        // Find a document by ItemName
        Document foundDocument = collection.find(Filters.eq("ItemName", "Car")).first();

        // Print the found document
        System.out.println(foundDocument.toJson());
    }
}