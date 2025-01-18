interface ICrudable {
    void create();
    void read();
    void update();
    void delete();
}

abstract class BusinessObject implements ICrudable {
    // Abstract class implementing ICrudable
}

class Classification extends BusinessObject {
    // Implementation of CRUD methods here

    @Override
    public void create() {
        // Implementation code
    }

    @Override
    public void read() {
        // Implementation code
    }

    @Override
    public void update() {
        // Implementation code
    }

    @Override
    public void delete() {
        // Implementation code
    }
}

class CustomerClassification {
    private Classification classification;
    private int level;

    public void setLevel(int level) { 
        this.level = level;
    }
    // Other behavior added directly to customer classification objects here
}