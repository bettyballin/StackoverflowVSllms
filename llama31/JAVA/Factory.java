public class Factory {
    public <T> T create() {
        return (T) new Object();
    }
}

class Event {}

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Event event = factory.create(); 
    }
}