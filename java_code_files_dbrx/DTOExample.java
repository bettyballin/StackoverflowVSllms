import java.util.concurrent.CompletableFuture;

public class DTOExample {
    private int id;
    private String name;

    public DTOExample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters (if needed)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "DTOExample{id=" + id + ", name='" + name + "'}";
    }

    public static void main(String[] args) throws Exception {
        int id = 1; // Sample ID
        MyServiceClient.getDTO(id).thenAccept((dto) -> {
            // use dto here for view manipulation, etc..
            System.out.println("Received DTO: " + dto);
        }).get(); // Wait for the CompletableFuture to complete
    }
}

class MyServiceClient {
    public static CompletableFuture<DTOExample> getDTO(int id) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate fetching DTO from a service
            DTOExample dto = new DTOExample(id, "Sample Name");
            return dto;
        });
    }
}