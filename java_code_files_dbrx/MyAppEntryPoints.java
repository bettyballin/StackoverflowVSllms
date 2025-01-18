import java.util.Scanner;

// The MainEntryPoint Class - determines which Module/Namespace is loaded based on user input
public class MyAppEntryPoints implements EntryPoint {
    public void onModuleLoad() {
        // Based on your own condition (URL, User Input etc)
        if(someCondition()){
            GWT.create(AdminModule.class);
        } else {
            GWT.create(HomeModule.class);
        }
    }

    private boolean someCondition() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 'admin' or 'home': ");
        String input = scanner.nextLine();
        return "admin".equalsIgnoreCase(input);
    }

    public static void main(String[] args) {
        MyAppEntryPoints app = new MyAppEntryPoints();
        app.onModuleLoad();
    }
}

// Define EntryPoint interface
interface EntryPoint {
    void onModuleLoad();
}

// Define GWT class with create method
class GWT {
    public static Object create(Class<?> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            System.out.println("Failed to create instance of " + clazz.getName());
            return null;
        }
    }
}

// Define AdminModule class
class AdminModule {
    public AdminModule() {
        System.out.println("AdminModule loaded");
    }
}

// Define HomeModule class
class HomeModule {
    public HomeModule() {
        System.out.println("HomeModule loaded");
    }
}