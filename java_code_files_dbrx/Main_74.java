public class Main {
    public static void main(String[] args) {
        if (!MySingleton.getInstance().typeInitialisedSuccessfully) {  // Our data hasn't been initialized yet
            MySingleton.initializeData();                             // So let's initialize it right now...
        }
    }
}

class MySingleton {
    public boolean typeInitialisedSuccessfully;
    private static MySingleton instance = null;

    private MySingleton() {
        typeInitialisedSuccessfully = false;
    }

    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }

    public static void initializeData() {
        MySingleton inst = getInstance();
        if (!inst.typeInitialisedSuccessfully) {
            // Initialization logic here
            inst.typeInitialisedSuccessfully = true;
            System.out.println("Data initialized.");
        }
    }
}