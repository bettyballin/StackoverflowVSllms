import java.util.UUID;

// Object model (no ID property)
public class MyObject_2 {
    private String objectId; // internal identifier

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}

// Repository/DAO (handles ID translation)
public class MyObject_2Repository {
    public MyObject getObject(int databaseId) {
        // retrieve object from database using databaseId
        MyObject obj = new MyObject(); // assuming MyObject has a no-arg constructor
        // simulate retrieving object from database
        obj.setObjectId(UUID.randomUUID().toString()); // set internal identifier
        return obj;
    }
    
    public void saveObject(MyObject obj) {
        // save object to database using internal identifier
        int databaseId = 1; // simulate databaseId
        // update database
        System.out.println("Saving object to database with databaseId: " + databaseId);
    }

    public static void main(String[] args) {
        MyObjectRepository repository = new MyObjectRepository();
        MyObject obj = repository.getObject(1);
        repository.saveObject(obj);
    }
}