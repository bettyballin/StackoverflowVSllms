public class Customer extends BusinessObject {
    private int id; // primary key
    private String name; // attributes...
    // Additional attributes can be added here

    public void updateClassification(CustomerClassification customerClassification) {
        Classification classification = customerClassification.getClassification();
        // DB operations to update or create new record on Classification table
        // Implementation omitted for brevity
    }
}

class BusinessObject {
    // Base class implementation (can be empty for this example)
}

class CustomerClassification {
    public Classification getClassification() {
        return new Classification();
    }
}

class Classification {
    // Classification class implementation (can be empty for this example)
}