import java.util.prefs.Preferences;

public class MyClass {
    public static void main(String[] args) {
        new MyClass().myMethod();
    }

    public void myMethod() {
        // write a value to the preferences node (will be stored persistently)
        Preferences prefs = Preferences.userNodeForPackage(this.getClass());
        prefs.put("lastOpenedFile", "myfile.txt");
        
        // getting back the value from preference object
        String lastOpenedFile = prefs.get("lastOpenedFile", null);  // will return "myfile.txt"
    }
}